package astmade;
import antlrfile.*;

public class AST extends MIDLBaseVisitor<String> {

    public String astParseTree = "";
    public StringBuilder astMaker = new StringBuilder("");

    public String visitSpecification(MIDLParser.SpecificationContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level)));
        astMaker.append("specification( \n");
        for (int i = 0; i < ctx.getChildCount(); i++)
            visit(ctx.getChild(i));
        astMaker.append(" ) ");
        return null;
    }

    public String visitDefinition(MIDLParser.DefinitionContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }

    public String visitModule(MIDLParser.ModuleContext ctx, int level) {
        System.out.println("LINE:" + ctx.getStart().getLine());  //check
        astMaker.append("    ".repeat(Math.max(0, level))).append("module(").append("    ".repeat(Math.max(0, level)));
        astMaker.append("ID:").append(ctx.getChild(1).getText()).append("\n");
        for(int i = 3;i < ctx.getChildCount()-1;i++)
            visit(ctx.getChild(i));
        astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        return null;
    }

    public String visitType_decl(MIDLParser.Type_declContext ctx, int level) {
        if (ctx.getChildCount() == 1)
            visit(ctx.getChild(0));
        else {
            astMaker.append("    ".repeat(Math.max(0, level))).append("struct(\n").append("    ".repeat(Math.max(0, level)));
            astMaker.append("ID:").append(ctx.ID().getText()).append("\n");
            astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        return null;
    }

    public String visitStruct_type(MIDLParser.Struct_typeContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level))).append("struct(\n").append("    ".repeat(Math.max(0, level)));
        astMaker.append("ID:").append(ctx.getChild(1).getText()).append("\n");
        visit(ctx.getChild(3));
        astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        return null;
    }

    public String visitMember_list(MIDLParser.Member_listContext ctx, int level) {
        int n = ctx.getChildCount();
        if (n == 0)
            return null;
        else {
            for (int i = 0; i < n / 3; i++) {
                astMaker.append("    ".repeat(Math.max(0, level))).append("member(\n");
                visit(ctx.getChild(3 * i));
                visit(ctx.getChild(3 * i + 1));
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
            }
        }
        return null;
    }

    public String visitType_spec(MIDLParser.Type_specContext ctx, int level) {
        visit(ctx.getChild(0));
        return null;
    }

    public String visitScoped_name(MIDLParser.Scoped_nameContext ctx, int level) {
        return null;
    }

    public String visitBase_type_spec(MIDLParser.Base_type_specContext ctx, int level) {
        //终结符
        if (ctx.getChild(0).getChildCount() == 0) {
            astMaker.append("    ".repeat(Math.max(0, level)));
            astMaker.append(ctx.getChild(0).getText()).append("\n");
        }
        else
            visit(ctx.getChild(0));
        return null;
    }

    public String visitFloating_pt_type(MIDLParser.Floating_pt_typeContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level)));
        astMaker.append(ctx.getChild(0).getText()).append("\n");
        return null;
    }

    public String visitInteger_type(MIDLParser.Integer_typeContext ctx, int level) {
        visit(ctx.getChild(0));
        return null;
    }

    public String visitSigned_int(MIDLParser.Signed_intContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level)));
        astMaker.append(ctx.getChild(0).getText()).append("\n");
        return null;
    }

    public String visitUnsigned_int(MIDLParser.Unsigned_intContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level)));
        astMaker.append(ctx.getChild(0).getText()).append("\n");
        return null;
    }

    public String visitDeclarators(MIDLParser.DeclaratorsContext ctx, int level) {
        int n = ctx.getChildCount();
        for(int i = 0;i < n;i++)
            if(ctx.getChild(i).getChildCount()!=0)
                visit(ctx.getChild(i));
        return null;
    }

    public String visitDeclarator(MIDLParser.DeclaratorContext ctx, int level) {
        visit(ctx.getChild(0));
        return null;
    }

    public String visitSimple_declarator(MIDLParser.Simple_declaratorContext ctx, int level) {

        if (ctx.getChildCount() != 1) {
            astMaker.append("    ".repeat(Math.max(0, level))).append("=(\n").append("    ".repeat(Math.max(0, level)));
            astMaker.append("ID:").append(ctx.getChild(0).getText()).append("\n");
            visit(ctx.or_expr());
            astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else {
            astMaker.append("    ".repeat(Math.max(0, level)));
            astMaker.append("ID:").append(ctx.getChild(0).getText()).append("\n");
        }
        return null;
    }

    public String visitArray_declarator(MIDLParser.Array_declaratorContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level))).append("array(\n").append("    ".repeat(Math.max(0, level)));
        astMaker.append("ID:").append(ctx.getChild(0).getText()).append("\n");
        visit(ctx.getChild(2));
        if (ctx.getChildCount() != 4)
            visit(ctx.exp_list());
        astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        return null;
    }

    public String visitExp_list(MIDLParser.Exp_listContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level))).append("arrayValues(\n");
        int n = ctx.getChildCount();
        for (int i = 0; i < n; i ++)
            if(ctx.getChild(i).getChildCount()>0)
                visit(ctx.getChild(i));
        astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        return null;
    }

    public String visitOr_expr(MIDLParser.Or_exprContext ctx, int level) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astMaker.append("    ".repeat(Math.max(0, level))).append("|(\n");
                visit(ctx.getChild(i - 1));
                if (i == n - 2)
                    visit(ctx.getChild(i + 1));
            }
            for (int i = 1; i < n; i += 2)
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else visit(ctx.getChild(0));
        return null;
    }

    public String visitXor_expr(MIDLParser.Xor_exprContext ctx, int level) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astMaker.append("    ".repeat(Math.max(0, level))).append("^(\n");
                visit(ctx.getChild(i - 1));
                if (i == n - 2)
                    visit(ctx.getChild(i + 1));
            }
            for (int i = 1; i < n; i += 2)
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else visit(ctx.getChild(0));
        return null;
    }

    public String visitAnd_expr(MIDLParser.And_exprContext ctx, int level) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astMaker.append("    ".repeat(Math.max(0, level))).append("&(\n");
                visit(ctx.getChild(i - 1));
                if (i == n - 2)
                    visit(ctx.getChild(i + 1));
            }
            for (int i = 1; i < n; i += 2)
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else visit(ctx.getChild(0));
        return null;
    }

    public String visitShift_expr(MIDLParser.Shift_exprContext ctx, int level) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astMaker.append("    ".repeat(Math.max(0, level)));
                astMaker.append(ctx.getChild(i).getText()).append("\n");
                visit(ctx.getChild(i - 1));
                if (i == n - 2)
                    visit(ctx.getChild(i + 1));
            }
            for (int i = 1; i < n; i += 2)
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else visit(ctx.getChild(0));
        return null;
    }

    public String visitAdd_expr(MIDLParser.Add_exprContext ctx, int level) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astMaker.append("    ".repeat(Math.max(0, level)));
                astMaker.append(ctx.getChild(i).getText()).append("(\n");
                visit(ctx.getChild(i - 1));
                if (i == n - 2)
                    visit(ctx.getChild(i + 1));
            }
            for (int i = 1; i < n; i += 2)
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else visit(ctx.getChild(0));
        return null;
    }

    public String visitMult_expr(MIDLParser.Mult_exprContext ctx, int level) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astMaker.append("    ".repeat(Math.max(0, level)));
                astMaker.append(ctx.getChild(i).getText()).append("(\n");
                visit(ctx.getChild(i - 1));
                if (i == n - 2)
                    visit(ctx.getChild(i + 1));
            }
            for (int i = 1; i < n; i += 2)
                astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else visit(ctx.getChild(0));
        return null;
    }

    public String visitUnary_expr(MIDLParser.Unary_exprContext ctx, int level) {

        if (ctx.getChildCount() != 1) {
            astMaker.append("    ".repeat(Math.max(0, level)));
            astMaker.append(ctx.getChild(0).getText()).append("(\n");
        }
        visit(ctx.literal());
        if (ctx.getChildCount() != 1)
            astMaker.append("    ".repeat(Math.max(0, level))).append(")\n");
        return null;
    }

    public String visitLiteral(MIDLParser.LiteralContext ctx, int level) {
        astMaker.append("    ".repeat(Math.max(0, level)));
        astMaker.append(ctx.getChild(0)).append("\n");
        return null;
    }
}


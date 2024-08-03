package astmade;
import antlrfile.*;

public class ASTBuilder extends MIDLBaseVisitor<String> {

    public StringBuilder astParseTree = new StringBuilder();
    public int level = 0;

    @Override
    public String visitSpecification(MIDLParser.SpecificationContext ctx) {
        astParseTree.append("specification(\n");
        for (int i = 0; i < ctx.getChildCount(); i++)
            visit(ctx.getChild(i));
        astParseTree.append(" ) ");
        return null;
    }

    @Override
    public String visitDefinition(MIDLParser.DefinitionContext ctx) {
        level ++;
        visit(ctx.getChild(0));
        level --;
        return null;
    }

    @Override
    public String visitModule(MIDLParser.ModuleContext ctx) {
        System.out.println("LINE:" + ctx.getStart().getLine());  //check
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append("module( \n");
        astParseTree.append("    ".repeat(Math.max(0, level + 1)));
        astParseTree.append("ID:").append(ctx.getChild(1).getText()).append(" \n");
        astParseTree.append("    ".repeat(Math.max(0, level + 1)));
        astParseTree.append("member:" + " (\n");
        for(int i = 3;i < ctx.getChildCount()-1;i++) {
            level ++;
            System.out.println(level);
            visit(ctx.getChild(i));
            level --;
        }
        astParseTree.append("    ".repeat(Math.max(0, level + 1)));
        astParseTree.append(")\n");
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append(")\n");
        return null;
    }

    @Override
    public String visitType_decl(MIDLParser.Type_declContext ctx) {
        //struct_type
        if (ctx.getChildCount() == 1) {
            level ++;
            visit(ctx.getChild(0));
            level --;
        }
        //"struct" ID
        else {
            astParseTree.append("    ".repeat(Math.max(0, level)));
            astParseTree.append("struct( \n");
            System.out.println(level);
            astParseTree.append("    ".repeat(Math.max(0, level + 1)));
            astParseTree.append("ID:").append(ctx.ID().getText()).append(" \n");
            astParseTree.append("    ".repeat(Math.max(0, level)));
            astParseTree.append(")\n");
        }
        return null;
    }

    @Override
    public String visitStruct_type(MIDLParser.Struct_typeContext ctx) {
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append("struct( \n");
        astParseTree.append("    ".repeat(Math.max(0, level + 1)));
        astParseTree.append("ID:").append(ctx.getChild(1).getText()).append(" \n");
        level++;
        visit(ctx.getChild(3));
        level--;
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append(") \n");
        return null;
    }

    @Override
    public String visitMember_list(MIDLParser.Member_listContext ctx) {
        int n = ctx.getChildCount();
        if (n == 0)
            return null;
        else {
            for (int i = 0; i < n / 3; i++) {
                astParseTree.append("    ".repeat(Math.max(0, level)));
                astParseTree.append("member(\n");
                visit(ctx.getChild(3 * i));
                visit(ctx.getChild(3 * i + 1));
                astParseTree.append("    ".repeat(Math.max(0, level)));
                astParseTree.append(")\n");
            }
        }
        return null;
    }

    @Override
    public String visitType_spec(MIDLParser.Type_specContext ctx) {
        level++;
        visit(ctx.getChild(0));
        level--;
        return null;
    }

    @Override
    public String visitScoped_name(MIDLParser.Scoped_nameContext ctx) {
        return null;
    }

    @Override
    public String visitBase_type_spec(MIDLParser.Base_type_specContext ctx) {
        //终结符
        if (ctx.getChild(0).getChildCount() == 0) {
            astParseTree.append("    ".repeat(Math.max(0, level)));
            astParseTree.append(ctx.getChild(0).getText()).append(" \n");
        }
        else {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitFloating_pt_type(MIDLParser.Floating_pt_typeContext ctx) {
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append(ctx.getChild(0).getText()).append("\n");
        return null;
    }

    @Override
    public String visitInteger_type(MIDLParser.Integer_typeContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }

    @Override
    public String visitSigned_int(MIDLParser.Signed_intContext ctx) {
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append(ctx.getChild(0).getText()).append("\n");
        return null;
    }

    @Override
    public String visitUnsigned_int(MIDLParser.Unsigned_intContext ctx) {
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append(ctx.getChild(0).getText()).append("\n");
        return null;
    }

    @Override
    public String visitDeclarators(MIDLParser.DeclaratorsContext ctx) {
        int n = ctx.getChildCount();
        for(int i = 0;i < n;i++)
        {
            if(ctx.getChild(i).getChildCount()!=0)
            {
                level++;
                visit(ctx.getChild(i));
                level--;
            }

        }
        return null;
    }

    @Override
    public String visitDeclarator(MIDLParser.DeclaratorContext ctx) {
        visit(ctx.getChild(0));
        return null;
    }

    @Override
    public String visitSimple_declarator(MIDLParser.Simple_declaratorContext ctx) {

        if (ctx.getChildCount() != 1) {
            astParseTree.append("    ".repeat(Math.max(0, level)));
            astParseTree.append("ID:").append(ctx.getChild(0).getText());
            astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append("value=(");
            level++;
            visit(ctx.or_expr());
            level--;
            astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")\n");
        }
        else
        {
            astParseTree.append("    ".repeat(Math.max(0, level)));
            astParseTree.append("ID:").append(ctx.getChild(0).getText()).append("\n");
        }
        return null;
    }

    @Override
    public String visitArray_declarator(MIDLParser.Array_declaratorContext ctx) {
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append("array(\n");
        astParseTree.append("    ".repeat(Math.max(0, level + 1)));
        astParseTree.append("ID:").append(ctx.getChild(0).getText());

        level++;
        visit(ctx.getChild(2));
        level--;

        level++;
        if (ctx.getChildCount() != 4) {
            visit(ctx.exp_list());
        }
        level--;

        astParseTree.append("\n");
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append(")\n");
        return null;
    }

    @Override
    public String visitExp_list(MIDLParser.Exp_listContext ctx) {
        astParseTree.append("\n");
        astParseTree.append("    ".repeat(Math.max(0, level)));
        astParseTree.append("arrayValues(\n").append("    ".repeat(Math.max(0, level + 1)));
        int n = ctx.getChildCount();
        level++;
        if (n > 1) {
            for (int i = 0; i < n - 1; i ++) {
                if(ctx.getChild(i).getChildCount()>0)
                {
                    visit(ctx.getChild(i));
                    astParseTree.append(" ");
                }
            }
        } else {
            visit(ctx.getChild(0));
        }
        visit(ctx.getChild(n - 1));
        level--;
        astParseTree.append("\b)");
        return null;
    }

    @Override
    public String visitOr_expr(MIDLParser.Or_exprContext ctx) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append("|(").append('\n').append("    ".repeat(Math.max(0, level+1)));
                level++;
                visit(ctx.getChild(i - 1));
                level--;
                if (i == n - 2){
                    level++;
                    visit(ctx.getChild(i + 1));
                    level--;
                }

            }
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
            }
        }
        else
        {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitXor_expr(MIDLParser.Xor_exprContext ctx) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append("^(").append('\n').append("    ".repeat(Math.max(0, level+1)));
                level++;
                visit(ctx.getChild(i - 1));
                level--;
                if (i == n - 2)
                {
                    level++;
                    visit(ctx.getChild(i + 1));
                    level--;
                }
            }
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
            }
        }
        else
        {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitAnd_expr(MIDLParser.And_exprContext ctx) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append("&(").append('\n').append("    ".repeat(Math.max(0, level+1)));
                level++;
                visit(ctx.getChild(i - 1));
                level--;
                if (i == n - 2)
                {
                    level++;
                    visit(ctx.getChild(i + 1));
                    level--;
                }
            }
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
            }
        }
        else
        {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitShift_expr(MIDLParser.Shift_exprContext ctx) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                //>>或<<
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(ctx.getChild(i).getText()).append("(").append('\n').append("    ".repeat(Math.max(0, level+1)));
                level++;
                visit(ctx.getChild(i - 1));
                astParseTree.append(" ");
                level--;
                if (i == n - 2)
                {
                    level++;
                    visit(ctx.getChild(i + 1));
                    level--;
                }
            }
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
            }
        }
        else
        {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitAdd_expr(MIDLParser.Add_exprContext ctx) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(ctx.getChild(i).getText()).append("(").append('\n').append("    ".repeat(Math.max(0, level+1)));
                level++;
                visit(ctx.getChild(i - 1));
                astParseTree.append(" ");
                level--;
                if (i == n - 2)
                {
                    level++;
                    visit(ctx.getChild(i + 1));
                    level--;
                }
            }
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
            }
        }
        else
        {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitMult_expr(MIDLParser.Mult_exprContext ctx) {
        int n = ctx.getChildCount();
        if(n > 1) {
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(ctx.getChild(i).getText()).append("(").append('\n').append("    ".repeat(Math.max(0, level+1)));
                level++;
                visit(ctx.getChild(i - 1));
                astParseTree.append(" ");
                level--;
                if (i == n - 2)
                {
                    level++;
                    visit(ctx.getChild(i + 1));
                    level--;
                }
            }
            for (int i = 1; i < n; i += 2) {
                astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
            }
        }
        else
        {
            visit(ctx.getChild(0));
        }
        return null;
    }

    @Override
    public String visitUnary_expr(MIDLParser.Unary_exprContext ctx) {

        if (ctx.getChildCount() != 1) {
            astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(ctx.getChild(0).getText()).append("(").append('\n').append("    ".repeat(Math.max(0, level+1)));
        }
        level++;
        visit(ctx.literal());
        level--;
        if (ctx.getChildCount() != 1) {
            astParseTree.append('\n').append("    ".repeat(Math.max(0, level))).append(")");
        }
        return null;
    }

    @Override
    public String visitLiteral(MIDLParser.LiteralContext ctx) {
        astParseTree.append(ctx.getChild(0));
        return null;
    }
}

package astmade;
import org.antlr.v4.runtime.tree.*;

import antlrfile.*;
import org.antlr.v4.runtime.*;
import java.io.*;

public class ASTFormatter{
    private static final String inputFile = "src\\input.midl";
    private static final String outputFile = "src\\SyntaxOut.txt";
    public static void main(String[] args) throws Exception {
        File input = new File(inputFile);
        BufferedReader reader = new BufferedReader(new FileReader(input));
        File output = new File(outputFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(output));
        String line;
        while((line = reader.readLine()) != null) {
            CharStream inputChars = CharStreams.fromString(line);
            MIDLLexer lexer = new MIDLLexer(inputChars);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MIDLParser parser = new MIDLParser(tokens);
            ParseTree tree = parser.specification();
            ASTBuilder builder = new ASTBuilder();
            builder.visit(tree);
            System.out.println(builder.astParseTree);
            writer.write(builder.astParseTree + "\n");
            writer.flush();
        }
        reader.close();
        writer.close();
    }
}

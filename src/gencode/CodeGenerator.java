package gencode;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import errortest.Entity;
import errortest.SemanticAnalyzer;
import errortest.Specification;

public class CodeGenerator {
    private static final String FILE_PATH = "src/SyntaxOut.txt";
    private static final String TO_PATH = "src/result.txt";

    public static void main(String[] args) throws Exception{
        generateCCodeToFile(SemanticAnalyzer.parseSpecifications(FILE_PATH), TO_PATH);
    }
    public static void generateCCodeToFile(List<Specification> specifications, String filename) {
        StringBuilder cCode = new StringBuilder();

        for(Specification specification: specifications) {
            for (Entity entity : specification.getEntities()) {
                if (entity.getStatus()) {
                    generateEntityCCode(entity, cCode, 0);
                }
            }
        }

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(cCode.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateEntityCCode(Entity entity, StringBuilder cCode, int indentLevel) {
        String indent = "    ".repeat(indentLevel);

        if (!entity.getEntitys().isEmpty()) {
            // It's a struct
            cCode.append(indent).append("struct ").append(entity.getType()).append(" {\n");
            for (Entity member : entity.getEntitys()) {
                if(member.getStatus()) {
                    generateEntityCCode(member, cCode, indentLevel + 1);
                }
            }
            cCode.append(indent).append("} ").append(entity.getId()).append(";\n");
        } else {
            // It's a simple variable
            cCode.append(indent).append(entity.getType()).append(" ").append(entity.getId());
            if (entity.getValue() != null) {
                cCode.append(" = ").append(entity.getValue());
            }
            cCode.append(";\n");
        }
    }
}

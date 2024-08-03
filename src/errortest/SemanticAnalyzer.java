package errortest;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class SemanticAnalyzer {

    private static final String FILE_PATH = "src/SyntaxOut.txt";
    private static Set<String> symbols = new HashSet<>(Set.of(
        "boolean",
        "short",
        "long",
        "unsigned",
        "int8",
        "int16",
        "int32",
        "int64",
        "uint8",
        "uint16",
        "uint32",
        "uint64",
        "char",
        "string",
        "float",
        "double",
        "struct",
        "module"
    ));
    private static Set<String> addedSymbols = new HashSet<>();
    private static SymbolChecker symbolChecker = new SymbolChecker();
    public static void main(String[] args) {
        try {
            List<Specification> specifications = parseSpecifications(FILE_PATH);
            System.out.println(specifications);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Specification> parseSpecifications(String filePath) throws IOException {
        List<Specification> specifications = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        Specification currentSpec = null;

        while ((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.startsWith("specification(")) {
                currentSpec = new Specification();
                specifications.add(currentSpec);
            } else if (line.startsWith("struct(") || line.startsWith("module(")) {
                parseStructOrModule(line, reader, currentSpec);
            }
        }
        reader.close();
        return specifications;
    }

    private static void parseStructOrModule(String line, BufferedReader reader, Specification spec) throws IOException {
        String type = line.indexOf('(') == -1 ? line : line.substring(0, line.indexOf('('));
        if(!symbols.contains(type) && !addedSymbols.contains(type)) {
            System.err.println("Not defined in symbol! The name is \" + nestedLine");
        }
        String id = null;
        Entity entity = new Entity(type, id);
        spec.addEntity(entity);

        String nestedLine;
        while ((nestedLine = reader.readLine()) != null) {
            nestedLine = nestedLine.trim();
            if (nestedLine.equals(")")) {
                break;
            } else if (nestedLine.startsWith("member")) {
                parseEntity(nestedLine, reader, entity);
            } else if(nestedLine.startsWith("ID:")) {
                entity.setId(extractId(nestedLine));
                if(addedSymbols.contains(entity.getId())) {
                    System.err.println("Already have this id in former: " + entity.getId());
                    entity.setStatus(false);
                }
                addedSymbols.add(entity.getId());
            }
        }
    }

    private static void parseEntity(String line, BufferedReader reader, Entity entity) throws IOException {
        Entity member = new Entity();
        String nestedLine;
        while ((nestedLine = reader.readLine()) != null) {
            nestedLine = nestedLine.trim();
            if (nestedLine.equals(")")) {
                break;
            } else if (nestedLine.startsWith("ID:")) {
                member.setId(extractId(nestedLine));
            } else if (nestedLine.startsWith("value=")) {
                String former = extractValue(nestedLine, reader);
                if(symbols.contains(member.getType()) && !Set.of("struct", "module", "boolean", "char", "string").contains(member.getType())) {
                    try {
                        member.setValue((member.getType().equals("double") || member.getType().equals("float")) ? ExpressionEvaluator.evaluateExpressionOfDouble(former) : ExpressionEvaluator.evaluateExpression(former));
                    } catch(Exception e) {
                        member.setValue(former);
                        member.setStatus(false);
                        System.err.println("Type can not match with value! The name is " + member.getId() + " the value is " + member.getValue() + " the type is " + member.getType());
                        continue;
                    }
                } else {
                    member.setValue(former);
                }
                if(symbols.contains(member.getType()) && !member.getType().equals("struct") && !member.getType().equals("module")) {
                    if(!symbolChecker.checkType(member.getValue(), member.getType())) {
                        member.setStatus(false);
                        System.err.println("Type can not match with value! The name is " + member.getId() + " the value is " + member.getValue() + " the type is " + member.getType());
                    }
                }
            } else if (nestedLine.startsWith("member")) {
                parseEntity(nestedLine, reader, member);
            } else {
                if(nestedLine.indexOf('(') != -1) {
                    nestedLine = nestedLine.substring(0, nestedLine.indexOf('('));
                }
                if(!symbols.contains(nestedLine) && !addedSymbols.contains(nestedLine)) {
                    member.setStatus(false);
                    System.err.println("Not defined in symbol! The name is " + nestedLine);
                }
                member.setType(nestedLine);
            }
        }
        entity.addEntity(member);
    }

    private static String extractId(String line) {
        Matcher matcher = Pattern.compile("ID:(\\w+)").matcher(line);
        return matcher.find() ? matcher.group(1) : null;
    }

    private static String extractValue(String line, BufferedReader reader) throws IOException{
        StringBuilder ret = new StringBuilder(line.substring(line.indexOf('(') + 1));
        int left = 0;
        String nestedLine;
        while ((nestedLine = reader.readLine()) != null) {
            nestedLine = nestedLine.trim();
            if (nestedLine.equals(")")) {
                if(left == 0) {
                    break;
                }
                left--;
                ret.append(nestedLine);
            } else {
                if(nestedLine.indexOf('(') != -1) {
                    left++;
                }
                ret.append(nestedLine);
            }
        }
        return ret.toString();
    }
}
package errortest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ExpressionEvaluator {
    private static final Set<Character> OPERATORS = new HashSet<>(Arrays.asList(
        '+', '-', '*', '/', '%', '&', '|', '^', '~', '>', '<'
    ));
    public static void main(String[] args) {
        String result1 = evaluateExpression("|(1^(2&(3>>(4+(5*(6/(7%(8~(9))))))))");
        String result2 = evaluateExpression("+(1-(2 3))");
        String result3 = evaluateExpression("*(1%(2/(4 3)))");
        
        System.out.println("Result 1: " + result1);
        System.out.println("Result 2: " + result2);
        System.out.println("Result 3: " + result3);
    }
    
    public static String evaluateExpression(String expression) {
        String[] tokens = expression.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        List<Long> numbers = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (String token : tokens) {
            if (isNumeric(token)) {
                long value = Long.parseLong(token);
                if(characters.size() >= 1 && numbers.size() >= 1) {
                    long num = performOperation(numbers.get(0), value, characters.get(0));
                    numbers.add(num);
                    characters.remove(0);
                    numbers.remove(0);
                } else {
                    numbers.add(value);
                }
            } else {
                if(OPERATORS.contains(token.charAt(0))) {
                    characters.add(token.charAt(0));
                }
            }

        }
        return String.valueOf(numbers.get(0));
    }
    public static boolean isNumeric(String str) {
        for (int i = str.length(); --i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
    private static long performOperation(long a, long b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            case '%':
                return a % b;
            case '&':
                return a & b;
            case '|':
                return a | b;
            case '^':
                return a ^ b;
            case '~':
                return ~b;
            case '>':
                return a >> b;
            case '<':
                return a << b;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
    public static String evaluateExpressionOfDouble(String expression) {
        String[] tokens = expression.split("(?<=\\D)(?=\\d)|(?<=\\d)(?=\\D)");
        List<Double> numbers = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (String token : tokens) {
            if (isNumericDouble(token)) {
                double value = Double.parseDouble(token);
                if (characters.size() >= 1 && numbers.size() >= 1) {
                    double num = performOperation(numbers.get(0), value, characters.get(0));
                    numbers.add(num);
                    characters.remove(0);
                    numbers.remove(0);
                } else {
                    numbers.add(value);
                }
            } else {
                if (OPERATORS.contains(token.charAt(0))) {
                    characters.add(token.charAt(0));
                }
            }
        }
        return String.valueOf(numbers.get(0));
    }

    public static boolean isNumericDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static double performOperation(double a, double b, char operation) {
        switch (operation) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new IllegalArgumentException("Division by zero is not allowed.");
                }
                return a / b;
            case '%':
                return a % b;
            default:
                throw new IllegalArgumentException("Invalid operation: " + operation);
        }
    }
}
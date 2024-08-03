package errortest;

import javax.swing.*;

public class SymbolChecker {

    public boolean checkType(String test, String type) {
        switch (type.toLowerCase()) {
            case "boolean":
                return checkBoolean(test);
            case "short":
                return checkShort(test);
            case "long":
                return checkLong(test);
            case "unsigned":
                return checkUnsigned(test);
            case "int8":
                return checkInt8(test);
            case "int16":
                return checkInt16(test);
            case "int32":
                return checkInt32(test);
            case "int64":
                return checkInt64(test);
            case "uint8":
                return checkUint8(test);
            case "uint16":
                return checkUint16(test);
            case "uint32":
                return checkUint32(test);
            case "uint64":
                return checkUint64(test);
            case "char":
                return checkChar(test);
            case "string":
                return checkString(test);
            case "float":
                return checkFloat(test);
            case "double":
                return checkDouble(test);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    private boolean checkBoolean(String test) {
        return "true".equalsIgnoreCase(test) || "false".equalsIgnoreCase(test);
    }

    private boolean checkShort(String test) {
        try {
            Short.parseShort(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkLong(String test) {
        try {
            Long.parseLong(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkUnsigned(String test) {
        try {
            long value = Long.parseLong(test);
            return value >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkInt8(String test) {
        try {
            int value = Integer.parseInt(test);
            return value >= -128 && value <= 127;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkInt16(String test) {
        try {
            int value = Integer.parseInt(test);
            return value >= -32768 && value <= 32767;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkInt32(String test) {
        try {
            long value = Long.parseLong(test);
            return value >= Integer.MIN_VALUE && value <= Integer.MAX_VALUE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkInt64(String test) {
        try {
            double value = Double.parseDouble(test);
            return value >= (double) Long.MIN_VALUE && (double)value <= Long.MAX_VALUE;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkUint8(String test) {
        try {
            int value = Integer.parseInt(test);
            return value >= 0 && value <= 255;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkUint16(String test) {
        try {
            int value = Integer.parseInt(test);
            return value >= 0 && value <= 65535;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkUint32(String test) {
        try {
            long value = Long.parseLong(test);
            return value >= 0 && value <= 4294967295L;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkUint64(String test) {
        try {
            // BigInteger is used because unsigned long range is not supported by primitive types
            java.math.BigInteger value = new java.math.BigInteger(test);
            return value.compareTo(java.math.BigInteger.ZERO) >= 0 &&
                    value.compareTo(new java.math.BigInteger("18446744073709551615")) <= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkChar(String test) {
        if(test.length() > 4) {
            return false;
        } else if(test.charAt(0) != '\'' || test.charAt(test.length() - 1) != '\'') {
            return false;
        } else if(test.length() == 4 && test.charAt(1) != '\\') {
            return false;
        }
        return true;
    }

    private boolean checkString(String test) {
        return test != null;
    }

    private boolean checkFloat(String test) {
        try {
            Float.parseFloat(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkDouble(String test) {
        try {
            Double.parseDouble(test);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

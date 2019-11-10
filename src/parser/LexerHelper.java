package parser;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import types.CharType;
import types.IntType;
import types.RealType;
import types.Type;

public class LexerHelper {

    public static int lexemeToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return -1;
    }

    public static char lexemeToChar(String str) {
        if (str.charAt(0) != '\'')
            return 0;
        if (str.charAt(str.length() - 1) != '\'')
            return 0;
        if (str.equals("'\\n'"))
            return '\n';
        if (str.equals("'"))
            return '\'';
        if (str.equals("'\\t'"))
            return '\t';
        if (str.length() == 3)
            return str.charAt(1);   // Single Character
        if (str.charAt(1) == ('\\')) {
            try {
                String numberStr = str.substring(2, str.length() - 2);
                try {
                    return (char) Integer.parseInt(numberStr);   // utf-8
                } catch (NumberFormatException e) {
                    System.out.println("UTF-8 Character Error: " + e);
                }
            } catch (StringIndexOutOfBoundsException e1) {
                System.out.println(e1 + "");
                System.out.println(str);
            }
        }
        return 0;
    }

    public static double lexemeToReal(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException e) {
            System.out.println(e);
        }
        return -1;
    }

    public static Type lexemeToType(String str) {
        String typeStr = str.substring(1, str.length() - 1).trim();
        switch (typeStr) {
            case "double":
                return RealType.getInstance();
            case "int":
                return IntType.getInstance();
            case "char":
                return CharType.getInstance();
            default:
                throw new ValueException(String.format("Cast does not support '%s' type", typeStr));
        }
    }
}

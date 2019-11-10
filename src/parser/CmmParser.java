// Generated from src/parser/Cmm.g4 by ANTLR 4.7
package parser;

import ast.Program;
import ast.definitions.*;
import ast.expressions.*;
import ast.statements.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.TerminalNode;
import types.*;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmmParser extends Parser {
    public static final int
            T__0 = 1, T__1 = 2, T__2 = 3, T__3 = 4, T__4 = 5, T__5 = 6, T__6 = 7, T__7 = 8, T__8 = 9,
            T__9 = 10, T__10 = 11, T__11 = 12, T__12 = 13, T__13 = 14, T__14 = 15, T__15 = 16, T__16 = 17,
            T__17 = 18, T__18 = 19, T__19 = 20, T__20 = 21, T__21 = 22, T__22 = 23, T__23 = 24,
            T__24 = 25, T__25 = 26, T__26 = 27, T__27 = 28, T__28 = 29, T__29 = 30, T__30 = 31,
            T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, T__37 = 38,
            WS = 39, COMMENT = 40, CHAR_CONSTANT = 41, INT_CONSTANT = 42, REAL_CONSTANT = 43,
            ID = 44;
    public static final int
            RULE_program = 0, RULE_definitions = 1, RULE_variable_definition = 2,
            RULE_typedef_variable_definition = 3, RULE_primative = 4, RULE_type = 5,
            RULE_statements = 6, RULE_statement = 7, RULE_function_invocation = 8,
            RULE_expression = 9, RULE_function_definition = 10, RULE_parameter_list = 11,
            RULE_return_type = 12, RULE_typedef_definition = 13, RULE_struct_definition = 14;
    public static final String[] ruleNames = {
            "program", "definitions", "variable_definition", "typedef_variable_definition",
            "primative", "type", "statements", "statement", "function_invocation",
            "expression", "function_definition", "parameter_list", "return_type",
            "typedef_definition", "struct_definition"
    };
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u01ac\4\2\t\2\4" +
                    "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
                    "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\3\2\3\2" +
                    "\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3\62\n\3\f\3\16\3\65" +
                    "\13\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4=\n\4\f\4\16\4@\13\4\3\4\3\4\3\4\3\4" +
                    "\3\4\5\4G\n\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5P\n\5\f\5\16\5S\13\5\3\5" +
                    "\3\5\3\5\3\5\6\5Y\n\5\r\5\16\5Z\3\5\3\5\5\5_\n\5\3\5\3\5\3\6\3\6\3\6\3" +
                    "\6\3\6\3\6\5\6i\n\6\3\7\3\7\3\7\3\7\3\7\3\7\5\7q\n\7\3\7\3\7\3\7\3\7\3" +
                    "\7\6\7x\n\7\r\7\16\7y\3\7\7\7}\n\7\f\7\16\7\u0080\13\7\3\b\3\b\3\b\3\b" +
                    "\7\b\u0086\n\b\f\b\16\b\u0089\13\b\3\b\3\b\3\b\7\b\u008e\n\b\f\b\16\b" +
                    "\u0091\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u009c\n\t\f\t\16\t" +
                    "\u009f\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u00aa\n\t\f\t\16\t" +
                    "\u00ad\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00bb" +
                    "\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00c5\n\t\3\t\3\t\5\t\u00c9\n" +
                    "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00d5\n\t\3\t\3\t\3\t\3" +
                    "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00e8\n\t\3" +
                    "\n\3\n\3\n\3\n\3\n\5\n\u00ef\n\n\3\n\3\n\7\n\u00f3\n\n\f\n\16\n\u00f6" +
                    "\13\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3" +
                    "\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3" +
                    "\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u011a\n\13\3\13\3\13\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13" +
                    "\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\7\13" +
                    "\u013b\n\13\f\13\16\13\u013e\13\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r" +
                    "\3\r\3\r\3\r\3\r\5\r\u014d\n\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0155\n\r\7" +
                    "\r\u0157\n\r\f\r\16\r\u015a\13\r\3\16\3\16\3\16\3\16\3\16\5\16\u0161\n" +
                    "\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u016a\n\17\f\17\16\17\u016d" +
                    "\13\17\3\17\3\17\3\17\3\17\3\17\6\17\u0174\n\17\r\17\16\17\u0175\3\17" +
                    "\3\17\3\17\3\17\5\17\u017c\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17" +
                    "\u0185\n\17\f\17\16\17\u0188\13\17\3\17\3\17\3\17\3\17\3\17\6\17\u018f" +
                    "\n\17\r\17\16\17\u0190\3\17\3\17\3\17\3\17\5\17\u0197\n\17\3\17\3\17\3" +
                    "\17\5\17\u019c\n\17\3\20\3\20\3\20\3\20\3\20\6\20\u01a3\n\20\r\20\16\20" +
                    "\u01a4\3\20\3\20\3\20\3\20\3\20\3\20\2\4\f\24\21\2\4\6\b\n\f\16\20\22" +
                    "\24\26\30\32\34\36\2\6\3\2\33\35\4\2\32\32\36\36\3\2\37$\3\2%&\2\u01d5" +
                    "\2 \3\2\2\2\4\63\3\2\2\2\6F\3\2\2\2\bH\3\2\2\2\nh\3\2\2\2\fp\3\2\2\2\16" +
                    "\u0081\3\2\2\2\20\u00e7\3\2\2\2\22\u00e9\3\2\2\2\24\u0119\3\2\2\2\26\u013f" +
                    "\3\2\2\2\30\u0158\3\2\2\2\32\u0160\3\2\2\2\34\u0162\3\2\2\2\36\u019d\3" +
                    "\2\2\2 !\5\4\3\2!\"\7\3\2\2\"#\7\4\2\2#$\7\5\2\2$%\7\6\2\2%&\5\16\b\2" +
                    "&\'\b\2\1\2\'\3\3\2\2\2()\5\34\17\2)*\b\3\1\2*\62\3\2\2\2+,\5\6\4\2,-" +
                    "\b\3\1\2-\62\3\2\2\2./\5\26\f\2/\60\b\3\1\2\60\62\3\2\2\2\61(\3\2\2\2" +
                    "\61+\3\2\2\2\61.\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64\3\2\2\2\64" +
                    "\5\3\2\2\2\65\63\3\2\2\2\66\67\5\f\7\2\678\7.\2\28>\b\4\1\29:\7\7\2\2" +
                    ":;\7.\2\2;=\b\4\1\2<9\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2" +
                    "@>\3\2\2\2AB\7\b\2\2BG\3\2\2\2CD\5\b\5\2DE\b\4\1\2EG\3\2\2\2F\66\3\2\2" +
                    "\2FC\3\2\2\2G\7\3\2\2\2HI\7\t\2\2I^\7.\2\2JK\7.\2\2KQ\b\5\1\2LM\7\7\2" +
                    "\2MN\7.\2\2NP\b\5\1\2OL\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R_\3\2\2" +
                    "\2SQ\3\2\2\2TU\7\n\2\2UV\7,\2\2VW\7\13\2\2WY\b\5\1\2XT\3\2\2\2YZ\3\2\2" +
                    "\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7.\2\2]_\b\5\1\2^J\3\2\2\2^X\3\2" +
                    "\2\2_`\3\2\2\2`a\7\b\2\2a\t\3\2\2\2bc\7\f\2\2ci\b\6\1\2de\7\r\2\2ei\b" +
                    "\6\1\2fg\7\16\2\2gi\b\6\1\2hb\3\2\2\2hd\3\2\2\2hf\3\2\2\2i\13\3\2\2\2" +
                    "jk\b\7\1\2kl\5\n\6\2lm\b\7\1\2mq\3\2\2\2no\7\17\2\2oq\b\7\1\2pj\3\2\2" +
                    "\2pn\3\2\2\2q~\3\2\2\2rw\f\3\2\2st\7\n\2\2tu\7,\2\2uv\7\13\2\2vx\b\7\1" +
                    "\2ws\3\2\2\2xy\3\2\2\2yw\3\2\2\2yz\3\2\2\2z{\3\2\2\2{}\b\7\1\2|r\3\2\2" +
                    "\2}\u0080\3\2\2\2~|\3\2\2\2~\177\3\2\2\2\177\r\3\2\2\2\u0080~\3\2\2\2" +
                    "\u0081\u0087\7\20\2\2\u0082\u0083\5\6\4\2\u0083\u0084\b\b\1\2\u0084\u0086" +
                    "\3\2\2\2\u0085\u0082\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087" +
                    "\u0088\3\2\2\2\u0088\u008f\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\5\20" +
                    "\t\2\u008b\u008c\b\b\1\2\u008c\u008e\3\2\2\2\u008d\u008a\3\2\2\2\u008e" +
                    "\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0092\3\2" +
                    "\2\2\u0091\u008f\3\2\2\2\u0092\u0093\7\21\2\2\u0093\17\3\2\2\2\u0094\u0095" +
                    "\7\22\2\2\u0095\u0096\5\24\13\2\u0096\u009d\b\t\1\2\u0097\u0098\7\7\2" +
                    "\2\u0098\u0099\5\24\13\2\u0099\u009a\b\t\1\2\u009a\u009c\3\2\2\2\u009b" +
                    "\u0097\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2" +
                    "\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\b\2\2\u00a1" +
                    "\u00e8\3\2\2\2\u00a2\u00a3\7\23\2\2\u00a3\u00a4\5\24\13\2\u00a4\u00ab" +
                    "\b\t\1\2\u00a5\u00a6\7\7\2\2\u00a6\u00a7\5\24\13\2\u00a7\u00a8\b\t\1\2" +
                    "\u00a8\u00aa\3\2\2\2\u00a9\u00a5\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9" +
                    "\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\u00ae\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae" +
                    "\u00af\7\b\2\2\u00af\u00e8\3\2\2\2\u00b0\u00b1\7\24\2\2\u00b1\u00b2\7" +
                    "\5\2\2\u00b2\u00b3\5\24\13\2\u00b3\u00ba\7\6\2\2\u00b4\u00b5\5\16\b\2" +
                    "\u00b5\u00b6\b\t\1\2\u00b6\u00bb\3\2\2\2\u00b7\u00b8\5\20\t\2\u00b8\u00b9" +
                    "\b\t\1\2\u00b9\u00bb\3\2\2\2\u00ba\u00b4\3\2\2\2\u00ba\u00b7\3\2\2\2\u00bb" +
                    "\u00bc\3\2\2\2\u00bc\u00c8\b\t\1\2\u00bd\u00c4\7\25\2\2\u00be\u00bf\5" +
                    "\16\b\2\u00bf\u00c0\b\t\1\2\u00c0\u00c5\3\2\2\2\u00c1\u00c2\5\20\t\2\u00c2" +
                    "\u00c3\b\t\1\2\u00c3\u00c5\3\2\2\2\u00c4\u00be\3\2\2\2\u00c4\u00c1\3\2" +
                    "\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\b\t\1\2\u00c7\u00c9\3\2\2\2\u00c8" +
                    "\u00bd\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\u00e8\3\2\2\2\u00ca\u00cb\7\26" +
                    "\2\2\u00cb\u00cc\7\5\2\2\u00cc\u00cd\5\24\13\2\u00cd\u00d4\7\6\2\2\u00ce" +
                    "\u00cf\5\16\b\2\u00cf\u00d0\b\t\1\2\u00d0\u00d5\3\2\2\2\u00d1\u00d2\5" +
                    "\20\t\2\u00d2\u00d3\b\t\1\2\u00d3\u00d5\3\2\2\2\u00d4\u00ce\3\2\2\2\u00d4" +
                    "\u00d1\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7\b\t\1\2\u00d7\u00e8\3\2" +
                    "\2\2\u00d8\u00d9\7\27\2\2\u00d9\u00da\5\24\13\2\u00da\u00db\7\b\2\2\u00db" +
                    "\u00dc\b\t\1\2\u00dc\u00e8\3\2\2\2\u00dd\u00de\5\22\n\2\u00de\u00df\7" +
                    "\b\2\2\u00df\u00e0\b\t\1\2\u00e0\u00e8\3\2\2\2\u00e1\u00e2\5\24\13\2\u00e2" +
                    "\u00e3\7\30\2\2\u00e3\u00e4\5\24\13\2\u00e4\u00e5\7\b\2\2\u00e5\u00e6" +
                    "\b\t\1\2\u00e6\u00e8\3\2\2\2\u00e7\u0094\3\2\2\2\u00e7\u00a2\3\2\2\2\u00e7" +
                    "\u00b0\3\2\2\2\u00e7\u00ca\3\2\2\2\u00e7\u00d8\3\2\2\2\u00e7\u00dd\3\2" +
                    "\2\2\u00e7\u00e1\3\2\2\2\u00e8\21\3\2\2\2\u00e9\u00ea\7.\2\2\u00ea\u00f4" +
                    "\7\5\2\2\u00eb\u00ee\5\24\13\2\u00ec\u00ef\3\2\2\2\u00ed\u00ef\7\7\2\2" +
                    "\u00ee\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f0\3\2\2\2\u00f0\u00f1" +
                    "\b\n\1\2\u00f1\u00f3\3\2\2\2\u00f2\u00eb\3\2\2\2\u00f3\u00f6\3\2\2\2\u00f4" +
                    "\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6\u00f4\3\2" +
                    "\2\2\u00f7\u00f8\7\6\2\2\u00f8\u00f9\b\n\1\2\u00f9\23\3\2\2\2\u00fa\u00fb" +
                    "\b\13\1\2\u00fb\u00fc\7.\2\2\u00fc\u011a\b\13\1\2\u00fd\u00fe\5\22\n\2" +
                    "\u00fe\u00ff\b\13\1\2\u00ff\u011a\3\2\2\2\u0100\u0101\7,\2\2\u0101\u011a" +
                    "\b\13\1\2\u0102\u0103\7-\2\2\u0103\u011a\b\13\1\2\u0104\u0105\7+\2\2\u0105" +
                    "\u011a\b\13\1\2\u0106\u0107\7\5\2\2\u0107\u0108\5\24\13\2\u0108\u0109" +
                    "\7\6\2\2\u0109\u010a\b\13\1\2\u010a\u011a\3\2\2\2\u010b\u010c\7\5\2\2" +
                    "\u010c\u010d\5\n\6\2\u010d\u010e\7\6\2\2\u010e\u010f\5\24\13\t\u010f\u0110" +
                    "\b\13\1\2\u0110\u011a\3\2\2\2\u0111\u0112\7\32\2\2\u0112\u0113\5\24\13" +
                    "\b\u0113\u0114\b\13\1\2\u0114\u011a\3\2\2\2\u0115\u0116\7\'\2\2\u0116" +
                    "\u0117\5\24\13\3\u0117\u0118\b\13\1\2\u0118\u011a\3\2\2\2\u0119\u00fa" +
                    "\3\2\2\2\u0119\u00fd\3\2\2\2\u0119\u0100\3\2\2\2\u0119\u0102\3\2\2\2\u0119" +
                    "\u0104\3\2\2\2\u0119\u0106\3\2\2\2\u0119\u010b\3\2\2\2\u0119\u0111\3\2" +
                    "\2\2\u0119\u0115\3\2\2\2\u011a\u013c\3\2\2\2\u011b\u011c\f\17\2\2\u011c" +
                    "\u011d\7\31\2\2\u011d\u011e\5\24\13\20\u011e\u011f\b\13\1\2\u011f\u013b" +
                    "\3\2\2\2\u0120\u0121\f\7\2\2\u0121\u0122\t\2\2\2\u0122\u0123\5\24\13\b" +
                    "\u0123\u0124\b\13\1\2\u0124\u013b\3\2\2\2\u0125\u0126\f\6\2\2\u0126\u0127" +
                    "\t\3\2\2\u0127\u0128\5\24\13\7\u0128\u0129\b\13\1\2\u0129\u013b\3\2\2" +
                    "\2\u012a\u012b\f\5\2\2\u012b\u012c\t\4\2\2\u012c\u012d\5\24\13\6\u012d" +
                    "\u012e\b\13\1\2\u012e\u013b\3\2\2\2\u012f\u0130\f\4\2\2\u0130\u0131\t" +
                    "\5\2\2\u0131\u0132\5\24\13\5\u0132\u0133\b\13\1\2\u0133\u013b\3\2\2\2" +
                    "\u0134\u0135\f\20\2\2\u0135\u0136\7\n\2\2\u0136\u0137\5\24\13\2\u0137" +
                    "\u0138\7\13\2\2\u0138\u0139\b\13\1\2\u0139\u013b\3\2\2\2\u013a\u011b\3" +
                    "\2\2\2\u013a\u0120\3\2\2\2\u013a\u0125\3\2\2\2\u013a\u012a\3\2\2\2\u013a" +
                    "\u012f\3\2\2\2\u013a\u0134\3\2\2\2\u013b\u013e\3\2\2\2\u013c\u013a\3\2" +
                    "\2\2\u013c\u013d\3\2\2\2\u013d\25\3\2\2\2\u013e\u013c\3\2\2\2\u013f\u0140" +
                    "\5\32\16\2\u0140\u0141\7.\2\2\u0141\u0142\7\5\2\2\u0142\u0143\5\30\r\2" +
                    "\u0143\u0144\7\6\2\2\u0144\u0145\5\16\b\2\u0145\u0146\b\f\1\2\u0146\27" +
                    "\3\2\2\2\u0147\u0148\5\n\6\2\u0148\u0149\7.\2\2\u0149\u014c\b\r\1\2\u014a" +
                    "\u014d\3\2\2\2\u014b\u014d\7\7\2\2\u014c\u014a\3\2\2\2\u014c\u014b\3\2" +
                    "\2\2\u014d\u0157\3\2\2\2\u014e\u014f\7\t\2\2\u014f\u0150\7.\2\2\u0150" +
                    "\u0151\7.\2\2\u0151\u0154\b\r\1\2\u0152\u0155\3\2\2\2\u0153\u0155\7\7" +
                    "\2\2\u0154\u0152\3\2\2\2\u0154\u0153\3\2\2\2\u0155\u0157\3\2\2\2\u0156" +
                    "\u0147\3\2\2\2\u0156\u014e\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2" +
                    "\2\2\u0158\u0159\3\2\2\2\u0159\31\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c" +
                    "\5\n\6\2\u015c\u015d\b\16\1\2\u015d\u0161\3\2\2\2\u015e\u015f\7\3\2\2" +
                    "\u015f\u0161\b\16\1\2\u0160\u015b\3\2\2\2\u0160\u015e\3\2\2\2\u0161\33" +
                    "\3\2\2\2\u0162\u019b\7(\2\2\u0163\u017b\5\f\7\2\u0164\u0165\7.\2\2\u0165" +
                    "\u016b\b\17\1\2\u0166\u0167\7\7\2\2\u0167\u0168\7.\2\2\u0168\u016a\b\17" +
                    "\1\2\u0169\u0166\3\2\2\2\u016a\u016d\3\2\2\2\u016b\u0169\3\2\2\2\u016b" +
                    "\u016c\3\2\2\2\u016c\u016e\3\2\2\2\u016d\u016b\3\2\2\2\u016e\u017c\7\b" +
                    "\2\2\u016f\u0170\7\n\2\2\u0170\u0171\7,\2\2\u0171\u0172\7\13\2\2\u0172" +
                    "\u0174\b\17\1\2\u0173\u016f\3\2\2\2\u0174\u0175\3\2\2\2\u0175\u0173\3" +
                    "\2\2\2\u0175\u0176\3\2\2\2\u0176\u0177\3\2\2\2\u0177\u0178\7.\2\2\u0178" +
                    "\u0179\b\17\1\2\u0179\u017a\3\2\2\2\u017a\u017c\7\b\2\2\u017b\u0164\3" +
                    "\2\2\2\u017b\u0173\3\2\2\2\u017c\u019c\3\2\2\2\u017d\u017e\7\t\2\2\u017e" +
                    "\u0196\7.\2\2\u017f\u0180\7.\2\2\u0180\u0186\b\17\1\2\u0181\u0182\7\7" +
                    "\2\2\u0182\u0183\7.\2\2\u0183\u0185\b\17\1\2\u0184\u0181\3\2\2\2\u0185" +
                    "\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0186\u0187\3\2\2\2\u0187\u0189\3\2" +
                    "\2\2\u0188\u0186\3\2\2\2\u0189\u0197\7\b\2\2\u018a\u018b\7\n\2\2\u018b" +
                    "\u018c\7,\2\2\u018c\u018d\7\13\2\2\u018d\u018f\b\17\1\2\u018e\u018a\3" +
                    "\2\2\2\u018f\u0190\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191" +
                    "\u0192\3\2\2\2\u0192\u0193\7.\2\2\u0193\u0194\b\17\1\2\u0194\u0195\3\2" +
                    "\2\2\u0195\u0197\7\b\2\2\u0196\u017f\3\2\2\2\u0196\u018e\3\2\2\2\u0197" +
                    "\u019c\3\2\2\2\u0198\u0199\5\36\20\2\u0199\u019a\b\17\1\2\u019a\u019c" +
                    "\3\2\2\2\u019b\u0163\3\2\2\2\u019b\u017d\3\2\2\2\u019b\u0198\3\2\2\2\u019c" +
                    "\35\3\2\2\2\u019d\u019e\5\f\7\2\u019e\u01a2\7\20\2\2\u019f\u01a0\5\6\4" +
                    "\2\u01a0\u01a1\b\20\1\2\u01a1\u01a3\3\2\2\2\u01a2\u019f\3\2\2\2\u01a3" +
                    "\u01a4\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a4\u01a5\3\2\2\2\u01a5\u01a6\3\2" +
                    "\2\2\u01a6\u01a7\7\21\2\2\u01a7\u01a8\7.\2\2\u01a8\u01a9\7\b\2\2\u01a9" +
                    "\u01aa\b\20\1\2\u01aa\37\3\2\2\2(\61\63>FQZ^hpy~\u0087\u008f\u009d\u00ab" +
                    "\u00ba\u00c4\u00c8\u00d4\u00e7\u00ee\u00f4\u0119\u013a\u013c\u014c\u0154" +
                    "\u0156\u0158\u0160\u016b\u0175\u017b\u0186\u0190\u0196\u019b\u01a4";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = {
            null, "'void'", "'main'", "'('", "')'", "','", "';'", "'type'", "'['",
            "']'", "'int'", "'double'", "'char'", "'struct'", "'{'", "'}'", "'write'",
            "'read'", "'if'", "'else'", "'while'", "'return'", "'='", "'.'", "'-'",
            "'*'", "'/'", "'%'", "'+'", "'>'", "'>='", "'<'", "'<='", "'!='", "'=='",
            "'&&'", "'||'", "'!'", "'typedef'"
    };
    private static final String[] _SYMBOLIC_NAMES = {
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, null, null, null, null, null, null, null, null, null,
            null, null, null, "WS", "COMMENT", "CHAR_CONSTANT", "INT_CONSTANT", "REAL_CONSTANT",
            "ID"
    };
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public CmmParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "Cmm.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final ProgramContext program() throws RecognitionException {
        ProgramContext _localctx = new ProgramContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_program);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(30);
                ((ProgramContext) _localctx).definitions = definitions();
                setState(31);
                match(T__0);
                setState(32);
                ((ProgramContext) _localctx).m = match(T__1);
                setState(33);
                match(T__2);
                setState(34);
                match(T__3);
                setState(35);
                ((ProgramContext) _localctx).statements = statements();
                ((ProgramContext) _localctx).ast = new Program((((ProgramContext) _localctx).definitions != null ? (((ProgramContext) _localctx).definitions.start) : null).getLine(), (((ProgramContext) _localctx).definitions != null ? (((ProgramContext) _localctx).definitions.start) : null).getCharPositionInLine() + 1, ((ProgramContext) _localctx).definitions.ast, ((ProgramContext) _localctx).statements.ast);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DefinitionsContext definitions() throws RecognitionException {
        DefinitionsContext _localctx = new DefinitionsContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_definitions);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(49);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            setState(47);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
                                case 1: {
                                    setState(38);
                                    ((DefinitionsContext) _localctx).typedef_definition = typedef_definition();
                                    _localctx.ast.addAll(((DefinitionsContext) _localctx).typedef_definition.ast);
                                }
                                break;
                                case 2: {
                                    setState(41);
                                    ((DefinitionsContext) _localctx).variable_definition = variable_definition();
                                    _localctx.ast.addAll(((DefinitionsContext) _localctx).variable_definition.ast);
                                }
                                break;
                                case 3: {
                                    setState(44);
                                    ((DefinitionsContext) _localctx).function_definition = function_definition();
                                    _localctx.ast.add(((DefinitionsContext) _localctx).function_definition.ast);
                                }
                                break;
                            }
                        }
                    }
                    setState(51);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Variable_definitionContext variable_definition() throws RecognitionException {
        Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_variable_definition);
        int _la;
        try {
            setState(68);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__9:
                case T__10:
                case T__11:
                case T__12:
                    enterOuterAlt(_localctx, 1);
                {
                    {
                        setState(52);
                        ((Variable_definitionContext) _localctx).type = type(0);
                        setState(53);
                        ((Variable_definitionContext) _localctx).id1 = match(ID);
                        _localctx.ast.add(new VarDefinition(((Variable_definitionContext) _localctx).id1.getLine(), ((Variable_definitionContext) _localctx).id1.getCharPositionInLine() + 1, (((Variable_definitionContext) _localctx).id1 != null ? ((Variable_definitionContext) _localctx).id1.getText() : null), ((Variable_definitionContext) _localctx).type.ast));
                        setState(60);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == T__4) {
                            {
                                {
                                    setState(55);
                                    match(T__4);
                                    setState(56);
                                    ((Variable_definitionContext) _localctx).id2 = match(ID);
                                    _localctx.ast.add(new VarDefinition(((Variable_definitionContext) _localctx).id2.getLine(), ((Variable_definitionContext) _localctx).id2.getCharPositionInLine() + 1, (((Variable_definitionContext) _localctx).id2 != null ? ((Variable_definitionContext) _localctx).id2.getText() : null), ((Variable_definitionContext) _localctx).type.ast));
                                }
                            }
                            setState(62);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                    setState(63);
                    match(T__5);
                }
                break;
                case T__6:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(65);
                    ((Variable_definitionContext) _localctx).tvd = typedef_variable_definition();
                    _localctx.ast.addAll(((Variable_definitionContext) _localctx).tvd.ast);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Typedef_variable_definitionContext typedef_variable_definition() throws RecognitionException {
        Typedef_variable_definitionContext _localctx = new Typedef_variable_definitionContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_typedef_variable_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(70);
                match(T__6);
                setState(71);
                ((Typedef_variable_definitionContext) _localctx).td = match(ID);
                setState(92);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case ID: {
                        {
                            setState(72);
                            ((Typedef_variable_definitionContext) _localctx).id = match(ID);
                            _localctx.ast.add(new VarDefinition(((Typedef_variable_definitionContext) _localctx).td.getLine(), ((Typedef_variable_definitionContext) _localctx).td.getCharPositionInLine() + 1, (((Typedef_variable_definitionContext) _localctx).id != null ? ((Typedef_variable_definitionContext) _localctx).id.getText() : null), TypedefDefinition.getTypedefType((((Typedef_variable_definitionContext) _localctx).td != null ? ((Typedef_variable_definitionContext) _localctx).td.getText() : null))));
                            setState(79);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == T__4) {
                                {
                                    {
                                        setState(74);
                                        match(T__4);
                                        setState(75);
                                        ((Typedef_variable_definitionContext) _localctx).id2 = match(ID);
                                        _localctx.ast.add(new VarDefinition(((Typedef_variable_definitionContext) _localctx).id2.getLine(), ((Typedef_variable_definitionContext) _localctx).id2.getCharPositionInLine() + 1, (((Typedef_variable_definitionContext) _localctx).id2 != null ? ((Typedef_variable_definitionContext) _localctx).id2.getText() : null), TypedefDefinition.getTypedefType((((Typedef_variable_definitionContext) _localctx).td != null ? ((Typedef_variable_definitionContext) _localctx).td.getText() : null))));
                                    }
                                }
                                setState(81);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                        }
                    }
                    break;
                    case T__7: {
                        {
                            setState(86);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            do {
                                {
                                    {
                                        setState(82);
                                        match(T__7);
                                        setState(83);
                                        ((Typedef_variable_definitionContext) _localctx).c = match(INT_CONSTANT);
                                        setState(84);
                                        match(T__8);
                                        _localctx.indexes.add(LexerHelper.lexemeToInt((((Typedef_variable_definitionContext) _localctx).c != null ? ((Typedef_variable_definitionContext) _localctx).c.getText() : null)));
                                    }
                                }
                                setState(88);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            } while (_la == T__7);
                            setState(90);
                            ((Typedef_variable_definitionContext) _localctx).id = match(ID);
                            _localctx.ast.add(new VarDefinition(((Typedef_variable_definitionContext) _localctx).td.getLine(), ((Typedef_variable_definitionContext) _localctx).td.getCharPositionInLine() + 1, (((Typedef_variable_definitionContext) _localctx).id != null ? ((Typedef_variable_definitionContext) _localctx).id.getText() : null), ArrayType.createArray(TypedefDefinition.getTypedefType((((Typedef_variable_definitionContext) _localctx).td != null ? ((Typedef_variable_definitionContext) _localctx).td.getText() : null)), _localctx.indexes)));
                        }
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(94);
                match(T__5);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrimativeContext primative() throws RecognitionException {
        PrimativeContext _localctx = new PrimativeContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_primative);
        try {
            setState(102);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__9:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(96);
                    match(T__9);
                    ((PrimativeContext) _localctx).ast = IntType.getInstance();
                }
                break;
                case T__10:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(98);
                    match(T__10);
                    ((PrimativeContext) _localctx).ast = RealType.getInstance();
                }
                break;
                case T__11:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(100);
                    match(T__11);
                    ((PrimativeContext) _localctx).ast = CharType.getInstance();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeContext type() throws RecognitionException {
        return type(0);
    }

    private TypeContext type(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        TypeContext _localctx = new TypeContext(_ctx, _parentState);
        TypeContext _prevctx = _localctx;
        int _startState = 10;
        enterRecursionRule(_localctx, 10, RULE_type, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(110);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case T__9:
                    case T__10:
                    case T__11: {
                        setState(105);
                        ((TypeContext) _localctx).primative = primative();
                        ((TypeContext) _localctx).ast = ((TypeContext) _localctx).primative.ast;
                    }
                    break;
                    case T__12: {
                        setState(108);
                        match(T__12);
                        ((TypeContext) _localctx).ast = StructType.getInstance();
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(124);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new TypeContext(_parentctx, _parentState);
                                _localctx.t = _prevctx;
                                _localctx.t = _prevctx;
                                pushNewRecursionContext(_localctx, _startState, RULE_type);
                                setState(112);
                                if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(117);
                                _errHandler.sync(this);
                                _alt = 1;
                                do {
                                    switch (_alt) {
                                        case 1: {
                                            {
                                                setState(113);
                                                match(T__7);
                                                setState(114);
                                                ((TypeContext) _localctx).c = match(INT_CONSTANT);
                                                setState(115);
                                                match(T__8);
                                                _localctx.indexes.add(LexerHelper.lexemeToInt((((TypeContext) _localctx).c != null ? ((TypeContext) _localctx).c.getText() : null)));
                                            }
                                        }
                                        break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                    setState(119);
                                    _errHandler.sync(this);
                                    _alt = getInterpreter().adaptivePredict(_input, 9, _ctx);
                                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                                ((TypeContext) _localctx).ast = ArrayType.createArray(((TypeContext) _localctx).t.ast, _localctx.indexes);
                            }
                        }
                    }
                    setState(126);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 10, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final StatementsContext statements() throws RecognitionException {
        StatementsContext _localctx = new StatementsContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_statements);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(127);
                match(T__13);
                setState(133);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0)) {
                    {
                        {
                            setState(128);
                            ((StatementsContext) _localctx).v = variable_definition();
                            for (Definition d : ((StatementsContext) _localctx).v.ast) {
                                _localctx.ast.add((Statement) d);
                            }
                        }
                    }
                    setState(135);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(141);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__19) | (1L << T__20) | (1L << T__23) | (1L << T__36) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID))) != 0)) {
                    {
                        {
                            setState(136);
                            ((StatementsContext) _localctx).s = statement();
                            _localctx.ast.addAll(((StatementsContext) _localctx).s.ast);
                        }
                    }
                    setState(143);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(144);
                match(T__14);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_statement);
        int _la;
        try {
            setState(229);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(146);
                    match(T__15);
                    setState(147);
                    ((StatementContext) _localctx).e1 = expression(0);
                    _localctx.ast.add(new Write((((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getLine(), (((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e1.ast));
                    setState(155);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__4) {
                        {
                            {
                                setState(149);
                                match(T__4);
                                setState(150);
                                ((StatementContext) _localctx).e2 = expression(0);
                                _localctx.ast.add(new Write((((StatementContext) _localctx).e2 != null ? (((StatementContext) _localctx).e2.start) : null).getLine(), (((StatementContext) _localctx).e2 != null ? (((StatementContext) _localctx).e2.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e2.ast));
                            }
                        }
                        setState(157);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(158);
                    match(T__5);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(160);
                    match(T__16);
                    setState(161);
                    ((StatementContext) _localctx).e1 = expression(0);
                    _localctx.ast.add(new Read((((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getLine(), (((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e1.ast));
                    setState(169);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == T__4) {
                        {
                            {
                                setState(163);
                                match(T__4);
                                setState(164);
                                ((StatementContext) _localctx).e2 = expression(0);
                                _localctx.ast.add(new Read((((StatementContext) _localctx).e2 != null ? (((StatementContext) _localctx).e2.start) : null).getLine(), (((StatementContext) _localctx).e2 != null ? (((StatementContext) _localctx).e2.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e2.ast));
                            }
                        }
                        setState(171);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(172);
                    match(T__5);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(174);
                    match(T__17);
                    setState(175);
                    match(T__2);
                    setState(176);
                    ((StatementContext) _localctx).c = expression(0);
                    setState(177);
                    match(T__3);
                    setState(184);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T__13: {
                            setState(178);
                            ((StatementContext) _localctx).s1 = statements();
                            _localctx.stmts.addAll(((StatementContext) _localctx).s1.ast);
                        }
                        break;
                        case T__2:
                        case T__15:
                        case T__16:
                        case T__17:
                        case T__19:
                        case T__20:
                        case T__23:
                        case T__36:
                        case CHAR_CONSTANT:
                        case INT_CONSTANT:
                        case REAL_CONSTANT:
                        case ID: {
                            setState(181);
                            ((StatementContext) _localctx).s2 = statement();
                            _localctx.stmts.addAll(((StatementContext) _localctx).s2.ast);
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    _localctx.ast.add(new If((((StatementContext) _localctx).c != null ? (((StatementContext) _localctx).c.start) : null).getLine(), (((StatementContext) _localctx).c != null ? (((StatementContext) _localctx).c.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).c.ast, _localctx.stmts));
                    ((StatementContext) _localctx).stmts = new ArrayList<Statement>();
                    setState(198);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 17, _ctx)) {
                        case 1: {
                            setState(187);
                            match(T__18);
                            setState(194);
                            _errHandler.sync(this);
                            switch (_input.LA(1)) {
                                case T__13: {
                                    setState(188);
                                    ((StatementContext) _localctx).s1 = statements();
                                    _localctx.stmts.addAll(((StatementContext) _localctx).s1.ast);
                                }
                                break;
                                case T__2:
                                case T__15:
                                case T__16:
                                case T__17:
                                case T__19:
                                case T__20:
                                case T__23:
                                case T__36:
                                case CHAR_CONSTANT:
                                case INT_CONSTANT:
                                case REAL_CONSTANT:
                                case ID: {
                                    setState(191);
                                    ((StatementContext) _localctx).s2 = statement();
                                    _localctx.stmts.addAll(((StatementContext) _localctx).s2.ast);
                                }
                                break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                            _localctx.ast.add(new Else((((StatementContext) _localctx).s1 != null ? (((StatementContext) _localctx).s1.start) : null).getLine(), (((StatementContext) _localctx).s1 != null ? (((StatementContext) _localctx).s1.start) : null).getCharPositionInLine() + 1, _localctx.stmts));
                            ((StatementContext) _localctx).stmts = new ArrayList<Statement>();
                        }
                        break;
                    }
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(200);
                    match(T__19);
                    setState(201);
                    match(T__2);
                    setState(202);
                    ((StatementContext) _localctx).e1 = expression(0);
                    setState(203);
                    match(T__3);
                    setState(210);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case T__13: {
                            setState(204);
                            ((StatementContext) _localctx).s1 = statements();
                            _localctx.stmts.addAll(((StatementContext) _localctx).s1.ast);
                        }
                        break;
                        case T__2:
                        case T__15:
                        case T__16:
                        case T__17:
                        case T__19:
                        case T__20:
                        case T__23:
                        case T__36:
                        case CHAR_CONSTANT:
                        case INT_CONSTANT:
                        case REAL_CONSTANT:
                        case ID: {
                            setState(207);
                            ((StatementContext) _localctx).s2 = statement();
                            _localctx.stmts.addAll(((StatementContext) _localctx).s2.ast);
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    _localctx.ast.add(new While((((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getLine(), (((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e1.ast, _localctx.stmts));
                    ((StatementContext) _localctx).stmts = new ArrayList<Statement>();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(214);
                    match(T__20);
                    setState(215);
                    ((StatementContext) _localctx).e1 = expression(0);
                    setState(216);
                    match(T__5);
                    _localctx.ast.add(new Return((((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getLine(), (((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e1.ast));
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(219);
                    ((StatementContext) _localctx).fi = function_invocation();
                    setState(220);
                    match(T__5);
                    _localctx.ast.add((Statement) ((StatementContext) _localctx).fi.ast);
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(223);
                    ((StatementContext) _localctx).e1 = expression(0);
                    setState(224);
                    match(T__21);
                    setState(225);
                    ((StatementContext) _localctx).e2 = expression(0);
                    setState(226);
                    match(T__5);
                    _localctx.ast.add(new Assignment((((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getLine(), (((StatementContext) _localctx).e1 != null ? (((StatementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((StatementContext) _localctx).e1.ast, ((StatementContext) _localctx).e2.ast));
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Function_invocationContext function_invocation() throws RecognitionException {
        Function_invocationContext _localctx = new Function_invocationContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_function_invocation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(231);
                ((Function_invocationContext) _localctx).id = match(ID);
                setState(232);
                match(T__2);
                setState(242);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__23) | (1L << T__36) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID))) != 0)) {
                    {
                        {
                            setState(233);
                            ((Function_invocationContext) _localctx).e1 = expression(0);
                            setState(236);
                            _errHandler.sync(this);
                            switch (_input.LA(1)) {
                                case T__2:
                                case T__3:
                                case T__23:
                                case T__36:
                                case CHAR_CONSTANT:
                                case INT_CONSTANT:
                                case REAL_CONSTANT:
                                case ID: {
                                }
                                break;
                                case T__4: {
                                    setState(235);
                                    match(T__4);
                                }
                                break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                            _localctx.parameters.add(((Function_invocationContext) _localctx).e1.ast);
                        }
                    }
                    setState(244);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(245);
                match(T__3);
                ((Function_invocationContext) _localctx).ast = new FuncExpression(((Function_invocationContext) _localctx).id.getLine(), ((Function_invocationContext) _localctx).id.getCharPositionInLine() + 1, (((Function_invocationContext) _localctx).id != null ? ((Function_invocationContext) _localctx).id.getText() : null), _localctx.parameters);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        return expression(0);
    }

    private ExpressionContext expression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
        ExpressionContext _prevctx = _localctx;
        int _startState = 18;
        enterRecursionRule(_localctx, 18, RULE_expression, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(279);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 22, _ctx)) {
                    case 1: {
                        setState(249);
                        ((ExpressionContext) _localctx).ID = match(ID);
                        ((ExpressionContext) _localctx).ast = new Variable(((ExpressionContext) _localctx).ID.getLine(), ((ExpressionContext) _localctx).ID.getCharPositionInLine() + 1, (((ExpressionContext) _localctx).ID != null ? ((ExpressionContext) _localctx).ID.getText() : null));
                    }
                    break;
                    case 2: {
                        setState(251);
                        ((ExpressionContext) _localctx).fi = function_invocation();
                        ((ExpressionContext) _localctx).ast = ((ExpressionContext) _localctx).fi.ast;
                    }
                    break;
                    case 3: {
                        setState(254);
                        ((ExpressionContext) _localctx).i = match(INT_CONSTANT);
                        ((ExpressionContext) _localctx).ast = new IntLiteral(((ExpressionContext) _localctx).i.getLine(), ((ExpressionContext) _localctx).i.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((ExpressionContext) _localctx).i != null ? ((ExpressionContext) _localctx).i.getText() : null)));
                    }
                    break;
                    case 4: {
                        setState(256);
                        ((ExpressionContext) _localctx).r = match(REAL_CONSTANT);
                        ((ExpressionContext) _localctx).ast = new RealLiteral(((ExpressionContext) _localctx).r.getLine(), ((ExpressionContext) _localctx).r.getCharPositionInLine() + 1, LexerHelper.lexemeToReal((((ExpressionContext) _localctx).r != null ? ((ExpressionContext) _localctx).r.getText() : null)));
                    }
                    break;
                    case 5: {
                        setState(258);
                        ((ExpressionContext) _localctx).c = match(CHAR_CONSTANT);
                        ((ExpressionContext) _localctx).ast = new CharLiteral(((ExpressionContext) _localctx).c.getLine(), ((ExpressionContext) _localctx).c.getCharPositionInLine() + 1, LexerHelper.lexemeToChar((((ExpressionContext) _localctx).c != null ? ((ExpressionContext) _localctx).c.getText() : null)));
                    }
                    break;
                    case 6: {
                        setState(260);
                        match(T__2);
                        setState(261);
                        ((ExpressionContext) _localctx).e1 = expression(0);
                        setState(262);
                        match(T__3);
                        ((ExpressionContext) _localctx).ast = ((ExpressionContext) _localctx).e1.ast;
                    }
                    break;
                    case 7: {
                        setState(265);
                        match(T__2);
                        setState(266);
                        ((ExpressionContext) _localctx).p = primative();
                        setState(267);
                        match(T__3);
                        setState(268);
                        ((ExpressionContext) _localctx).e1 = expression(7);
                        ((ExpressionContext) _localctx).ast = new Cast((((ExpressionContext) _localctx).p != null ? (((ExpressionContext) _localctx).p.start) : null).getLine(), (((ExpressionContext) _localctx).p != null ? (((ExpressionContext) _localctx).p.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).p.ast, ((ExpressionContext) _localctx).e1.ast);
                    }
                    break;
                    case 8: {
                        setState(271);
                        match(T__23);
                        setState(272);
                        ((ExpressionContext) _localctx).e1 = expression(6);
                        ((ExpressionContext) _localctx).ast = new UnaryMinus((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast);
                    }
                    break;
                    case 9: {
                        setState(275);
                        match(T__36);
                        setState(276);
                        ((ExpressionContext) _localctx).e1 = expression(1);
                        ((ExpressionContext) _localctx).ast = new Not((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast);
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(314);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 24, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(312);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 23, _ctx)) {
                                case 1: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(281);
                                    if (!(precpred(_ctx, 13)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                                    setState(282);
                                    match(T__22);
                                    setState(283);
                                    ((ExpressionContext) _localctx).e2 = expression(14);
                                    ((ExpressionContext) _localctx).ast = new StructAccess((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 2: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(286);
                                    if (!(precpred(_ctx, 5)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                    setState(287);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__24) | (1L << T__25) | (1L << T__26))) != 0))) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(288);
                                    ((ExpressionContext) _localctx).e2 = expression(6);
                                    ((ExpressionContext) _localctx).ast = new Arithmetic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 3: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(291);
                                    if (!(precpred(_ctx, 4)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                    setState(292);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == T__23 || _la == T__27)) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(293);
                                    ((ExpressionContext) _localctx).e2 = expression(5);
                                    ((ExpressionContext) _localctx).ast = new Arithmetic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 4: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(296);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(297);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31) | (1L << T__32) | (1L << T__33))) != 0))) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(298);
                                    ((ExpressionContext) _localctx).e2 = expression(4);
                                    ((ExpressionContext) _localctx).ast = new Comparison((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 5: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(301);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(302);
                                    ((ExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == T__34 || _la == T__35)) {
                                        ((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(303);
                                    ((ExpressionContext) _localctx).e2 = expression(3);
                                    ((ExpressionContext) _localctx).ast = new Logic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                                case 6: {
                                    _localctx = new ExpressionContext(_parentctx, _parentState);
                                    _localctx.e1 = _prevctx;
                                    _localctx.e1 = _prevctx;
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(306);
                                    if (!(precpred(_ctx, 14)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                                    setState(307);
                                    match(T__7);
                                    setState(308);
                                    ((ExpressionContext) _localctx).e2 = expression(0);
                                    setState(309);
                                    match(T__8);
                                    ((ExpressionContext) _localctx).ast = new Indexing((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, ((ExpressionContext) _localctx).e2.ast);
                                }
                                break;
                            }
                        }
                    }
                    setState(316);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 24, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final Function_definitionContext function_definition() throws RecognitionException {
        Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_function_definition);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(317);
                ((Function_definitionContext) _localctx).r = return_type();
                setState(318);
                ((Function_definitionContext) _localctx).ID = match(ID);
                setState(319);
                match(T__2);
                setState(320);
                ((Function_definitionContext) _localctx).p = parameter_list();
                setState(321);
                match(T__3);
                setState(322);
                ((Function_definitionContext) _localctx).s = statements();
                ((Function_definitionContext) _localctx).ast = new FuncDefinition(((Function_definitionContext) _localctx).ID.getLine(), ((Function_definitionContext) _localctx).ID.getCharPositionInLine() + 1, (((Function_definitionContext) _localctx).ID != null ? ((Function_definitionContext) _localctx).ID.getText() : null), ((Function_definitionContext) _localctx).r.ast, ((Function_definitionContext) _localctx).p.ast, ((Function_definitionContext) _localctx).s.ast);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Parameter_listContext parameter_list() throws RecognitionException {
        Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_parameter_list);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(342);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11))) != 0)) {
                    {
                        setState(340);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case T__9:
                            case T__10:
                            case T__11: {
                                {
                                    setState(325);
                                    ((Parameter_listContext) _localctx).t = primative();
                                    setState(326);
                                    ((Parameter_listContext) _localctx).id1 = match(ID);
                                    _localctx.ast.add(new VarDefinition(((Parameter_listContext) _localctx).id1.getLine(), ((Parameter_listContext) _localctx).id1.getCharPositionInLine() + 1, (((Parameter_listContext) _localctx).id1 != null ? ((Parameter_listContext) _localctx).id1.getText() : null), ((Parameter_listContext) _localctx).t.ast));
                                    setState(330);
                                    _errHandler.sync(this);
                                    switch (_input.LA(1)) {
                                        case T__3:
                                        case T__6:
                                        case T__9:
                                        case T__10:
                                        case T__11: {
                                        }
                                        break;
                                        case T__4: {
                                            setState(329);
                                            match(T__4);
                                        }
                                        break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                }
                            }
                            break;
                            case T__6: {
                                {
                                    setState(332);
                                    match(T__6);
                                    setState(333);
                                    ((Parameter_listContext) _localctx).td = match(ID);
                                    setState(334);
                                    ((Parameter_listContext) _localctx).id2 = match(ID);
                                    _localctx.ast.add(new VarDefinition(((Parameter_listContext) _localctx).id2.getLine(), ((Parameter_listContext) _localctx).id2.getCharPositionInLine() + 1, (((Parameter_listContext) _localctx).id2 != null ? ((Parameter_listContext) _localctx).id2.getText() : null), TypedefDefinition.getTypedefType((((Parameter_listContext) _localctx).td != null ? ((Parameter_listContext) _localctx).td.getText() : null))));
                                    setState(338);
                                    _errHandler.sync(this);
                                    switch (_input.LA(1)) {
                                        case T__3:
                                        case T__6:
                                        case T__9:
                                        case T__10:
                                        case T__11: {
                                        }
                                        break;
                                        case T__4: {
                                            setState(337);
                                            match(T__4);
                                        }
                                        break;
                                        default:
                                            throw new NoViableAltException(this);
                                    }
                                }
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    setState(344);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Return_typeContext return_type() throws RecognitionException {
        Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_return_type);
        try {
            setState(350);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case T__9:
                case T__10:
                case T__11:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(345);
                    ((Return_typeContext) _localctx).p = primative();
                    ((Return_typeContext) _localctx).ast = ((Return_typeContext) _localctx).p.ast;
                }
                break;
                case T__0:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(348);
                    match(T__0);
                    ((Return_typeContext) _localctx).ast = VoidType.getInstance();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Typedef_definitionContext typedef_definition() throws RecognitionException {
        Typedef_definitionContext _localctx = new Typedef_definitionContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_typedef_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(352);
                match(T__37);
                setState(409);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 36, _ctx)) {
                    case 1: {
                        setState(353);
                        ((Typedef_definitionContext) _localctx).t = type(0);
                        setState(377);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case ID: {
                                setState(354);
                                ((Typedef_definitionContext) _localctx).id1 = match(ID);
                                _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).id1.getLine(), ((Typedef_definitionContext) _localctx).id1.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id1 != null ? ((Typedef_definitionContext) _localctx).id1.getText() : null), ((Typedef_definitionContext) _localctx).t.ast));
                                setState(361);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == T__4) {
                                    {
                                        {
                                            setState(356);
                                            match(T__4);
                                            setState(357);
                                            ((Typedef_definitionContext) _localctx).id2 = match(ID);
                                            _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).id2.getLine(), ((Typedef_definitionContext) _localctx).id2.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id2 != null ? ((Typedef_definitionContext) _localctx).id2.getText() : null), ((Typedef_definitionContext) _localctx).t.ast));
                                        }
                                    }
                                    setState(363);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                                setState(364);
                                match(T__5);
                            }
                            break;
                            case T__7: {
                                {
                                    setState(369);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    do {
                                        {
                                            {
                                                setState(365);
                                                match(T__7);
                                                setState(366);
                                                ((Typedef_definitionContext) _localctx).c = match(INT_CONSTANT);
                                                setState(367);
                                                match(T__8);
                                                _localctx.indexes.add(LexerHelper.lexemeToInt((((Typedef_definitionContext) _localctx).c != null ? ((Typedef_definitionContext) _localctx).c.getText() : null)));
                                            }
                                        }
                                        setState(371);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                    } while (_la == T__7);
                                    setState(373);
                                    ((Typedef_definitionContext) _localctx).id5 = match(ID);
                                    _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).id5.getLine(), ((Typedef_definitionContext) _localctx).id5.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id5 != null ? ((Typedef_definitionContext) _localctx).id5.getText() : null), ArrayType.createArray(((Typedef_definitionContext) _localctx).t.ast, _localctx.indexes)));
                                }
                                setState(376);
                                match(T__5);
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    break;
                    case 2: {
                        setState(379);
                        match(T__6);
                        setState(380);
                        ((Typedef_definitionContext) _localctx).td = match(ID);
                        setState(404);
                        _errHandler.sync(this);
                        switch (_input.LA(1)) {
                            case ID: {
                                setState(381);
                                ((Typedef_definitionContext) _localctx).id3 = match(ID);
                                _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).id3.getLine(), ((Typedef_definitionContext) _localctx).id3.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id3 != null ? ((Typedef_definitionContext) _localctx).id3.getText() : null), TypedefDefinition.getTypedefType((((Typedef_definitionContext) _localctx).td != null ? ((Typedef_definitionContext) _localctx).td.getText() : null))));
                                setState(388);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == T__4) {
                                    {
                                        {
                                            setState(383);
                                            match(T__4);
                                            setState(384);
                                            ((Typedef_definitionContext) _localctx).id4 = match(ID);
                                            _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).id4.getLine(), ((Typedef_definitionContext) _localctx).id4.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id4 != null ? ((Typedef_definitionContext) _localctx).id4.getText() : null), TypedefDefinition.getTypedefType((((Typedef_definitionContext) _localctx).td != null ? ((Typedef_definitionContext) _localctx).td.getText() : null))));
                                        }
                                    }
                                    setState(390);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                                setState(391);
                                match(T__5);
                            }
                            break;
                            case T__7: {
                                {
                                    setState(396);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    do {
                                        {
                                            {
                                                setState(392);
                                                match(T__7);
                                                setState(393);
                                                ((Typedef_definitionContext) _localctx).c = match(INT_CONSTANT);
                                                setState(394);
                                                match(T__8);
                                                _localctx.indexes.add(LexerHelper.lexemeToInt((((Typedef_definitionContext) _localctx).c != null ? ((Typedef_definitionContext) _localctx).c.getText() : null)));
                                            }
                                        }
                                        setState(398);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                    } while (_la == T__7);
                                    setState(400);
                                    ((Typedef_definitionContext) _localctx).id6 = match(ID);
                                    _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).id6.getLine(), ((Typedef_definitionContext) _localctx).id6.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id6 != null ? ((Typedef_definitionContext) _localctx).id6.getText() : null), ArrayType.createArray(TypedefDefinition.getTypedefType((((Typedef_definitionContext) _localctx).td != null ? ((Typedef_definitionContext) _localctx).td.getText() : null)), _localctx.indexes)));
                                }
                                setState(403);
                                match(T__5);
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                    }
                    break;
                    case 3: {
                        setState(406);
                        ((Typedef_definitionContext) _localctx).sd = struct_definition();
                        _localctx.ast.add(new TypedefDefinition(((Typedef_definitionContext) _localctx).sd.ast));
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final Struct_definitionContext struct_definition() throws RecognitionException {
        Struct_definitionContext _localctx = new Struct_definitionContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_struct_definition);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(411);
                ((Struct_definitionContext) _localctx).t = type(0);
                setState(412);
                match(T__13);
                setState(416);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(413);
                            ((Struct_definitionContext) _localctx).vd = variable_definition();
                            _localctx.variableDefs.addAll(((Struct_definitionContext) _localctx).vd.ast);
                        }
                    }
                    setState(418);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12))) != 0));
                setState(420);
                match(T__14);
                setState(421);
                ((Struct_definitionContext) _localctx).id = match(ID);
                setState(422);
                match(T__5);
                ((Struct_definitionContext) _localctx).ast = new StructDefinition(((Struct_definitionContext) _localctx).id.getLine(), ((Struct_definitionContext) _localctx).id.getCharPositionInLine() + 1, (((Struct_definitionContext) _localctx).id != null ? ((Struct_definitionContext) _localctx).id.getText() : null), ((Struct_definitionContext) _localctx).t.ast, _localctx.variableDefs);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 5:
                return type_sempred((TypeContext) _localctx, predIndex);
            case 9:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean type_sempred(TypeContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 1:
                return precpred(_ctx, 13);
            case 2:
                return precpred(_ctx, 5);
            case 3:
                return precpred(_ctx, 4);
            case 4:
                return precpred(_ctx, 3);
            case 5:
                return precpred(_ctx, 2);
            case 6:
                return precpred(_ctx, 14);
        }
        return true;
    }

    public static class ProgramContext extends ParserRuleContext {
        public Program ast;
        public DefinitionsContext definitions;
        public Token m;
        public StatementsContext statements;

        public ProgramContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public DefinitionsContext definitions() {
            return getRuleContext(DefinitionsContext.class, 0);
        }

        public StatementsContext statements() {
            return getRuleContext(StatementsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_program;
        }
    }

    public static class DefinitionsContext extends ParserRuleContext {
        public List<Definition> ast = new ArrayList<Definition>();
        public Typedef_definitionContext typedef_definition;
        public Variable_definitionContext variable_definition;
        public Function_definitionContext function_definition;

        public DefinitionsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<Typedef_definitionContext> typedef_definition() {
            return getRuleContexts(Typedef_definitionContext.class);
        }

        public Typedef_definitionContext typedef_definition(int i) {
            return getRuleContext(Typedef_definitionContext.class, i);
        }

        public List<Variable_definitionContext> variable_definition() {
            return getRuleContexts(Variable_definitionContext.class);
        }

        public Variable_definitionContext variable_definition(int i) {
            return getRuleContext(Variable_definitionContext.class, i);
        }

        public List<Function_definitionContext> function_definition() {
            return getRuleContexts(Function_definitionContext.class);
        }

        public Function_definitionContext function_definition(int i) {
            return getRuleContext(Function_definitionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_definitions;
        }
    }

    public static class Variable_definitionContext extends ParserRuleContext {
        public ArrayList<Definition> ast = new ArrayList<Definition>();
        public TypeContext type;
        public Token id1;
        public Token id2;
        public Typedef_variable_definitionContext tvd;

        public Variable_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(CmmParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }

        public Typedef_variable_definitionContext typedef_variable_definition() {
            return getRuleContext(Typedef_variable_definitionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variable_definition;
        }
    }

    public static class Typedef_variable_definitionContext extends ParserRuleContext {
        public ArrayList<Definition> ast = new ArrayList<Definition>();
        public ArrayList<Integer> indexes = new ArrayList<>();
        public Token td;
        public Token id;
        public Token id2;
        public Token c;

        public Typedef_variable_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TerminalNode> ID() {
            return getTokens(CmmParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }

        public List<TerminalNode> INT_CONSTANT() {
            return getTokens(CmmParser.INT_CONSTANT);
        }

        public TerminalNode INT_CONSTANT(int i) {
            return getToken(CmmParser.INT_CONSTANT, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedef_variable_definition;
        }
    }

    public static class PrimativeContext extends ParserRuleContext {
        public Type ast;

        public PrimativeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_primative;
        }
    }

    public static class TypeContext extends ParserRuleContext {
        public Type ast;
        public ArrayList<Integer> indexes = new ArrayList<>();
        public TypeContext t;
        public PrimativeContext primative;
        public Token c;

        public TypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PrimativeContext primative() {
            return getRuleContext(PrimativeContext.class, 0);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<TerminalNode> INT_CONSTANT() {
            return getTokens(CmmParser.INT_CONSTANT);
        }

        public TerminalNode INT_CONSTANT(int i) {
            return getToken(CmmParser.INT_CONSTANT, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_type;
        }
    }

    public static class StatementsContext extends ParserRuleContext {
        public ArrayList<Statement> ast = new ArrayList<Statement>();
        public Variable_definitionContext v;
        public StatementContext s;

        public StatementsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<Variable_definitionContext> variable_definition() {
            return getRuleContexts(Variable_definitionContext.class);
        }

        public Variable_definitionContext variable_definition(int i) {
            return getRuleContext(Variable_definitionContext.class, i);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statements;
        }
    }

    public static class StatementContext extends ParserRuleContext {
        public ArrayList<Statement> ast = new ArrayList<Statement>();
        public ArrayList<Statement> stmts = new ArrayList<Statement>();
        public ExpressionContext e1;
        public ExpressionContext e2;
        public ExpressionContext c;
        public StatementsContext s1;
        public StatementContext s2;
        public Function_invocationContext fi;

        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<StatementsContext> statements() {
            return getRuleContexts(StatementsContext.class);
        }

        public StatementsContext statements(int i) {
            return getRuleContext(StatementsContext.class, i);
        }

        public List<StatementContext> statement() {
            return getRuleContexts(StatementContext.class);
        }

        public StatementContext statement(int i) {
            return getRuleContext(StatementContext.class, i);
        }

        public Function_invocationContext function_invocation() {
            return getRuleContext(Function_invocationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }
    }

    public static class Function_invocationContext extends ParserRuleContext {
        public Expression ast;
        public ArrayList<Expression> parameters = new ArrayList<Expression>();
        public Token id;
        public ExpressionContext e1;

        public Function_invocationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_invocation;
        }
    }

    public static class ExpressionContext extends ParserRuleContext {
        public Expression ast;
        public ArrayList<Expression> indexes = new ArrayList<Expression>();
        public ExpressionContext e1;
        public Token ID;
        public Function_invocationContext fi;
        public Token i;
        public Token r;
        public Token c;
        public PrimativeContext p;
        public ExpressionContext e2;
        public Token op;

        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public Function_invocationContext function_invocation() {
            return getRuleContext(Function_invocationContext.class, 0);
        }

        public TerminalNode INT_CONSTANT() {
            return getToken(CmmParser.INT_CONSTANT, 0);
        }

        public TerminalNode REAL_CONSTANT() {
            return getToken(CmmParser.REAL_CONSTANT, 0);
        }

        public TerminalNode CHAR_CONSTANT() {
            return getToken(CmmParser.CHAR_CONSTANT, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public PrimativeContext primative() {
            return getRuleContext(PrimativeContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }
    }

    public static class Function_definitionContext extends ParserRuleContext {
        public Definition ast;
        public Return_typeContext r;
        public Token ID;
        public Parameter_listContext p;
        public StatementsContext s;

        public Function_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public Return_typeContext return_type() {
            return getRuleContext(Return_typeContext.class, 0);
        }

        public Parameter_listContext parameter_list() {
            return getRuleContext(Parameter_listContext.class, 0);
        }

        public StatementsContext statements() {
            return getRuleContext(StatementsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_function_definition;
        }
    }

    public static class Parameter_listContext extends ParserRuleContext {
        public ArrayList<Definition> ast = new ArrayList<>();
        public PrimativeContext t;
        public Token id1;
        public Token td;
        public Token id2;

        public Parameter_listContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<PrimativeContext> primative() {
            return getRuleContexts(PrimativeContext.class);
        }

        public PrimativeContext primative(int i) {
            return getRuleContext(PrimativeContext.class, i);
        }

        public List<TerminalNode> ID() {
            return getTokens(CmmParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parameter_list;
        }
    }

    public static class Return_typeContext extends ParserRuleContext {
        public Type ast;
        public PrimativeContext p;

        public Return_typeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PrimativeContext primative() {
            return getRuleContext(PrimativeContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_return_type;
        }
    }

    public static class Typedef_definitionContext extends ParserRuleContext {
        public ArrayList<Definition> ast = new ArrayList<Definition>();
        public ArrayList<Integer> indexes = new ArrayList<>();
        public TypeContext t;
        public Token id1;
        public Token id2;
        public Token c;
        public Token id5;
        public Token td;
        public Token id3;
        public Token id4;
        public Token id6;
        public Struct_definitionContext sd;

        public Typedef_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public List<TerminalNode> ID() {
            return getTokens(CmmParser.ID);
        }

        public TerminalNode ID(int i) {
            return getToken(CmmParser.ID, i);
        }

        public Struct_definitionContext struct_definition() {
            return getRuleContext(Struct_definitionContext.class, 0);
        }

        public List<TerminalNode> INT_CONSTANT() {
            return getTokens(CmmParser.INT_CONSTANT);
        }

        public TerminalNode INT_CONSTANT(int i) {
            return getToken(CmmParser.INT_CONSTANT, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typedef_definition;
        }
    }

    public static class Struct_definitionContext extends ParserRuleContext {
        public StructDefinition ast;
        public ArrayList<Definition> variableDefs = new ArrayList<Definition>();
        public TypeContext t;
        public Variable_definitionContext vd;
        public Token id;

        public Struct_definitionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TypeContext type() {
            return getRuleContext(TypeContext.class, 0);
        }

        public TerminalNode ID() {
            return getToken(CmmParser.ID, 0);
        }

        public List<Variable_definitionContext> variable_definition() {
            return getRuleContexts(Variable_definitionContext.class);
        }

        public Variable_definitionContext variable_definition(int i) {
            return getRuleContext(Variable_definitionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_struct_definition;
        }
    }
}
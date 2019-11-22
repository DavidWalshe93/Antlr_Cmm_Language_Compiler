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
			T__31 = 32, T__32 = 33, T__33 = 34, T__34 = 35, T__35 = 36, T__36 = 37, WS = 38, COMMENT = 39,
			CHAR_CONSTANT = 40, INT_CONSTANT = 41, REAL_CONSTANT = 42, MAIN = 43, ID = 44;
	public static final int
			RULE_program = 0, RULE_definitions = 1, RULE_main = 2, RULE_variable_definition = 3,
			RULE_primative = 4, RULE_type = 5, RULE_function_block = 6, RULE_variable_definition_block = 7,
			RULE_block = 8, RULE_statement_block = 9, RULE_statement = 10, RULE_if_statement = 11,
			RULE_while_statement = 12, RULE_condition_block = 13, RULE_write_statement = 14,
			RULE_read_statement = 15, RULE_return_statement = 16, RULE_assignment_statement = 17,
			RULE_function_invocation = 18, RULE_argument_list = 19, RULE_expression = 20,
			RULE_function_definition = 21, RULE_parameter_list = 22, RULE_return_type = 23,
			RULE_type_definition = 24, RULE_typedef_definition = 25, RULE_struct_definition = 26;
	public static final String[] ruleNames = {
			"program", "definitions", "main", "variable_definition", "primative",
			"type", "function_block", "variable_definition_block", "block", "statement_block",
			"statement", "if_statement", "while_statement", "condition_block", "write_statement",
			"read_statement", "return_statement", "assignment_statement", "function_invocation",
			"argument_list", "expression", "function_definition", "parameter_list",
			"return_type", "type_definition", "typedef_definition", "struct_definition"
	};
	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	public static final String _serializedATN =
			"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3.\u0190\4\2\t\2\4" +
					"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t" +
					"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22" +
					"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31" +
					"\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3" +
					"\3\3\3\3\7\3E\n\3\f\3\16\3H\13\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3" +
					"\4\3\4\3\4\3\4\5\4W\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5_\n\5\f\5\16\5b\13" +
					"\5\5\5d\n\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6n\n\6\3\7\3\7\3\7\3\7\3" +
					"\7\3\7\3\7\5\7w\n\7\3\7\3\7\3\7\3\7\3\7\6\7~\n\7\r\7\16\7\177\3\7\7\7" +
					"\u0083\n\7\f\7\16\7\u0086\13\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t" +
					"\7\t\u0092\n\t\f\t\16\t\u0095\13\t\3\n\3\n\3\n\7\n\u009a\n\n\f\n\16\n" +
					"\u009d\13\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13\u00a7\n\13\3" +
					"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f" +
					"\3\f\3\f\3\f\3\f\5\f\u00bf\n\f\3\r\3\r\3\r\3\r\3\r\5\r\u00c6\n\r\3\r\3" +
					"\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3" +
					"\20\3\20\3\20\3\20\3\20\7\20\u00dc\n\20\f\20\16\20\u00df\13\20\3\20\3" +
					"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00ea\n\21\f\21\16\21\u00ed" +
					"\13\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23" +
					"\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\7\25\u0107\n\25" +
					"\f\25\16\25\u010a\13\25\5\25\u010c\n\25\3\25\3\25\3\26\3\26\3\26\3\26" +
					"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26" +
					"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26" +
					"\u012f\n\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26" +
					"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26" +
					"\3\26\3\26\3\26\3\26\7\26\u014f\n\26\f\26\16\26\u0152\13\26\3\27\3\27" +
					"\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\7\30" +
					"\u0163\n\30\f\30\16\30\u0166\13\30\5\30\u0168\n\30\3\30\3\30\3\31\3\31" +
					"\3\31\3\31\3\31\5\31\u0171\n\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\5\32" +
					"\u017a\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u0184\n\33\f" +
					"\33\16\33\u0187\13\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\2\4\f*\35" +
					"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\6\3\2\31" +
					"\33\4\2\30\30\34\34\3\2\35\"\3\2#$\2\u01a0\28\3\2\2\2\4F\3\2\2\2\6L\3" +
					"\2\2\2\bc\3\2\2\2\nm\3\2\2\2\fv\3\2\2\2\16\u0087\3\2\2\2\20\u0093\3\2" +
					"\2\2\22\u009b\3\2\2\2\24\u00a6\3\2\2\2\26\u00be\3\2\2\2\30\u00c0\3\2\2" +
					"\2\32\u00c9\3\2\2\2\34\u00cd\3\2\2\2\36\u00d4\3\2\2\2 \u00e2\3\2\2\2\"" +
					"\u00f0\3\2\2\2$\u00f5\3\2\2\2&\u00fb\3\2\2\2(\u00ff\3\2\2\2*\u012e\3\2" +
					"\2\2,\u0153\3\2\2\2.\u0159\3\2\2\2\60\u0170\3\2\2\2\62\u0172\3\2\2\2\64" +
					"\u017d\3\2\2\2\66\u0188\3\2\2\289\5\4\3\29:\b\2\1\2:\3\3\2\2\2;<\5\62" +
					"\32\2<=\b\3\1\2=E\3\2\2\2>?\5\b\5\2?@\b\3\1\2@E\3\2\2\2AB\5,\27\2BC\b" +
					"\3\1\2CE\3\2\2\2D;\3\2\2\2D>\3\2\2\2DA\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3" +
					"\2\2\2GI\3\2\2\2HF\3\2\2\2IJ\5\6\4\2JK\b\3\1\2K\5\3\2\2\2LM\7\3\2\2MN" +
					"\7-\2\2NO\7\4\2\2OV\7\5\2\2PQ\7\6\2\2QR\7\7\2\2RW\b\4\1\2ST\5\16\b\2T" +
					"U\b\4\1\2UW\3\2\2\2VP\3\2\2\2VS\3\2\2\2W\7\3\2\2\2XY\5\f\7\2YZ\7.\2\2" +
					"Z`\b\5\1\2[\\\7\b\2\2\\]\7.\2\2]_\b\5\1\2^[\3\2\2\2_b\3\2\2\2`^\3\2\2" +
					"\2`a\3\2\2\2ad\3\2\2\2b`\3\2\2\2cX\3\2\2\2cd\3\2\2\2de\3\2\2\2ef\7\t\2" +
					"\2f\t\3\2\2\2gh\7\n\2\2hn\b\6\1\2ij\7\13\2\2jn\b\6\1\2kl\7\f\2\2ln\b\6" +
					"\1\2mg\3\2\2\2mi\3\2\2\2mk\3\2\2\2n\13\3\2\2\2op\b\7\1\2pq\5\n\6\2qr\b" +
					"\7\1\2rw\3\2\2\2st\7\17\2\2tu\7.\2\2uw\b\7\1\2vo\3\2\2\2vs\3\2\2\2w\u0084" +
					"\3\2\2\2x}\f\4\2\2yz\7\r\2\2z{\7+\2\2{|\7\16\2\2|~\b\7\1\2}y\3\2\2\2~" +
					"\177\3\2\2\2\177}\3\2\2\2\177\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081" +
					"\u0083\b\7\1\2\u0082x\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2" +
					"\u0084\u0085\3\2\2\2\u0085\r\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7" +
					"\6\2\2\u0088\u0089\5\20\t\2\u0089\u008a\b\b\1\2\u008a\u008b\5\22\n\2\u008b" +
					"\u008c\b\b\1\2\u008c\u008d\7\7\2\2\u008d\17\3\2\2\2\u008e\u008f\5\b\5" +
					"\2\u008f\u0090\b\t\1\2\u0090\u0092\3\2\2\2\u0091\u008e\3\2\2\2\u0092\u0095" +
					"\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\21\3\2\2\2\u0095" +
					"\u0093\3\2\2\2\u0096\u0097\5\26\f\2\u0097\u0098\b\n\1\2\u0098\u009a\3" +
					"\2\2\2\u0099\u0096\3\2\2\2\u009a\u009d\3\2\2\2\u009b\u0099\3\2\2\2\u009b" +
					"\u009c\3\2\2\2\u009c\23\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u009f\7\6\2" +
					"\2\u009f\u00a0\5\22\n\2\u00a0\u00a1\7\7\2\2\u00a1\u00a2\b\13\1\2\u00a2" +
					"\u00a7\3\2\2\2\u00a3\u00a4\5\26\f\2\u00a4\u00a5\b\13\1\2\u00a5\u00a7\3" +
					"\2\2\2\u00a6\u009e\3\2\2\2\u00a6\u00a3\3\2\2\2\u00a7\25\3\2\2\2\u00a8" +
					"\u00a9\5\36\20\2\u00a9\u00aa\b\f\1\2\u00aa\u00bf\3\2\2\2\u00ab\u00ac\5" +
					" \21\2\u00ac\u00ad\b\f\1\2\u00ad\u00bf\3\2\2\2\u00ae\u00af\5\30\r\2\u00af" +
					"\u00b0\b\f\1\2\u00b0\u00bf\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2\u00b3\b" +
					"\f\1\2\u00b3\u00bf\3\2\2\2\u00b4\u00b5\5\"\22\2\u00b5\u00b6\b\f\1\2\u00b6" +
					"\u00bf\3\2\2\2\u00b7\u00b8\5$\23\2\u00b8\u00b9\b\f\1\2\u00b9\u00bf\3\2" +
					"\2\2\u00ba\u00bb\5&\24\2\u00bb\u00bc\7\t\2\2\u00bc\u00bd\b\f\1\2\u00bd" +
					"\u00bf\3\2\2\2\u00be\u00a8\3\2\2\2\u00be\u00ab\3\2\2\2\u00be\u00ae\3\2" +
					"\2\2\u00be\u00b1\3\2\2\2\u00be\u00b4\3\2\2\2\u00be\u00b7\3\2\2\2\u00be" +
					"\u00ba\3\2\2\2\u00bf\27\3\2\2\2\u00c0\u00c1\7\20\2\2\u00c1\u00c2\5\34" +
					"\17\2\u00c2\u00c5\b\r\1\2\u00c3\u00c4\7\21\2\2\u00c4\u00c6\5\24\13\2\u00c5" +
					"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c8\b\r" +
					"\1\2\u00c8\31\3\2\2\2\u00c9\u00ca\7\22\2\2\u00ca\u00cb\5\34\17\2\u00cb" +
					"\u00cc\b\16\1\2\u00cc\33\3\2\2\2\u00cd\u00ce\7\4\2\2\u00ce\u00cf\5*\26" +
					"\2\u00cf\u00d0\7\5\2\2\u00d0\u00d1\b\17\1\2\u00d1\u00d2\5\24\13\2\u00d2" +
					"\u00d3\b\17\1\2\u00d3\35\3\2\2\2\u00d4\u00d5\7\23\2\2\u00d5\u00d6\5*\26" +
					"\2\u00d6\u00dd\b\20\1\2\u00d7\u00d8\7\b\2\2\u00d8\u00d9\5*\26\2\u00d9" +
					"\u00da\b\20\1\2\u00da\u00dc\3\2\2\2\u00db\u00d7\3\2\2\2\u00dc\u00df\3" +
					"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2\2\2\u00df" +
					"\u00dd\3\2\2\2\u00e0\u00e1\7\t\2\2\u00e1\37\3\2\2\2\u00e2\u00e3\7\24\2" +
					"\2\u00e3\u00e4\5*\26\2\u00e4\u00eb\b\21\1\2\u00e5\u00e6\7\b\2\2\u00e6" +
					"\u00e7\5*\26\2\u00e7\u00e8\b\21\1\2\u00e8\u00ea\3\2\2\2\u00e9\u00e5\3" +
					"\2\2\2\u00ea\u00ed\3\2\2\2\u00eb\u00e9\3\2\2\2\u00eb\u00ec\3\2\2\2\u00ec" +
					"\u00ee\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00ef\7\t\2\2\u00ef!\3\2\2\2" +
					"\u00f0\u00f1\7\25\2\2\u00f1\u00f2\5*\26\2\u00f2\u00f3\7\t\2\2\u00f3\u00f4" +
					"\b\22\1\2\u00f4#\3\2\2\2\u00f5\u00f6\5*\26\2\u00f6\u00f7\7\26\2\2\u00f7" +
					"\u00f8\5*\26\2\u00f8\u00f9\7\t\2\2\u00f9\u00fa\b\23\1\2\u00fa%\3\2\2\2" +
					"\u00fb\u00fc\7.\2\2\u00fc\u00fd\5(\25\2\u00fd\u00fe\b\24\1\2\u00fe\'\3" +
					"\2\2\2\u00ff\u010b\7\4\2\2\u0100\u0101\5*\26\2\u0101\u0108\b\25\1\2\u0102" +
					"\u0103\7\b\2\2\u0103\u0104\5*\26\2\u0104\u0105\b\25\1\2\u0105\u0107\3" +
					"\2\2\2\u0106\u0102\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108" +
					"\u0109\3\2\2\2\u0109\u010c\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u0100\3\2" +
					"\2\2\u010b\u010c\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010e\7\5\2\2\u010e" +
					")\3\2\2\2\u010f\u0110\b\26\1\2\u0110\u0111\7.\2\2\u0111\u012f\b\26\1\2" +
					"\u0112\u0113\5&\24\2\u0113\u0114\b\26\1\2\u0114\u012f\3\2\2\2\u0115\u0116" +
					"\7+\2\2\u0116\u012f\b\26\1\2\u0117\u0118\7,\2\2\u0118\u012f\b\26\1\2\u0119" +
					"\u011a\7*\2\2\u011a\u012f\b\26\1\2\u011b\u011c\7\4\2\2\u011c\u011d\5*" +
					"\26\2\u011d\u011e\7\5\2\2\u011e\u011f\b\26\1\2\u011f\u012f\3\2\2\2\u0120" +
					"\u0121\7\4\2\2\u0121\u0122\5\n\6\2\u0122\u0123\7\5\2\2\u0123\u0124\5*" +
					"\26\t\u0124\u0125\b\26\1\2\u0125\u012f\3\2\2\2\u0126\u0127\7\30\2\2\u0127" +
					"\u0128\5*\26\b\u0128\u0129\b\26\1\2\u0129\u012f\3\2\2\2\u012a\u012b\7" +
					"%\2\2\u012b\u012c\5*\26\3\u012c\u012d\b\26\1\2\u012d\u012f\3\2\2\2\u012e" +
					"\u010f\3\2\2\2\u012e\u0112\3\2\2\2\u012e\u0115\3\2\2\2\u012e\u0117\3\2" +
					"\2\2\u012e\u0119\3\2\2\2\u012e\u011b\3\2\2\2\u012e\u0120\3\2\2\2\u012e" +
					"\u0126\3\2\2\2\u012e\u012a\3\2\2\2\u012f\u0150\3\2\2\2\u0130\u0131\f\7" +
					"\2\2\u0131\u0132\t\2\2\2\u0132\u0133\5*\26\b\u0133\u0134\b\26\1\2\u0134" +
					"\u014f\3\2\2\2\u0135\u0136\f\6\2\2\u0136\u0137\t\3\2\2\u0137\u0138\5*" +
					"\26\7\u0138\u0139\b\26\1\2\u0139\u014f\3\2\2\2\u013a\u013b\f\5\2\2\u013b" +
					"\u013c\t\4\2\2\u013c\u013d\5*\26\6\u013d\u013e\b\26\1\2\u013e\u014f\3" +
					"\2\2\2\u013f\u0140\f\4\2\2\u0140\u0141\t\5\2\2\u0141\u0142\5*\26\5\u0142" +
					"\u0143\b\26\1\2\u0143\u014f\3\2\2\2\u0144\u0145\f\20\2\2\u0145\u0146\7" +
					"\r\2\2\u0146\u0147\5*\26\2\u0147\u0148\7\16\2\2\u0148\u0149\b\26\1\2\u0149" +
					"\u014f\3\2\2\2\u014a\u014b\f\17\2\2\u014b\u014c\7\27\2\2\u014c\u014d\7" +
					".\2\2\u014d\u014f\b\26\1\2\u014e\u0130\3\2\2\2\u014e\u0135\3\2\2\2\u014e" +
					"\u013a\3\2\2\2\u014e\u013f\3\2\2\2\u014e\u0144\3\2\2\2\u014e\u014a\3\2" +
					"\2\2\u014f\u0152\3\2\2\2\u0150\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151" +
					"+\3\2\2\2\u0152\u0150\3\2\2\2\u0153\u0154\5\60\31\2\u0154\u0155\7.\2\2" +
					"\u0155\u0156\5.\30\2\u0156\u0157\5\16\b\2\u0157\u0158\b\27\1\2\u0158-" +
					"\3\2\2\2\u0159\u0167\7\4\2\2\u015a\u015b\5\f\7\2\u015b\u015c\7.\2\2\u015c" +
					"\u0164\b\30\1\2\u015d\u015e\7\b\2\2\u015e\u015f\5\f\7\2\u015f\u0160\7" +
					".\2\2\u0160\u0161\b\30\1\2\u0161\u0163\3\2\2\2\u0162\u015d\3\2\2\2\u0163" +
					"\u0166\3\2\2\2\u0164\u0162\3\2\2\2\u0164\u0165\3\2\2\2\u0165\u0168\3\2" +
					"\2\2\u0166\u0164\3\2\2\2\u0167\u015a\3\2\2\2\u0167\u0168\3\2\2\2\u0168" +
					"\u0169\3\2\2\2\u0169\u016a\7\5\2\2\u016a/\3\2\2\2\u016b\u016c\5\n\6\2" +
					"\u016c\u016d\b\31\1\2\u016d\u0171\3\2\2\2\u016e\u016f\7\3\2\2\u016f\u0171" +
					"\b\31\1\2\u0170\u016b\3\2\2\2\u0170\u016e\3\2\2\2\u0171\61\3\2\2\2\u0172" +
					"\u0179\7&\2\2\u0173\u0174\5\64\33\2\u0174\u0175\b\32\1\2\u0175\u017a\3" +
					"\2\2\2\u0176\u0177\5\66\34\2\u0177\u0178\b\32\1\2\u0178\u017a\3\2\2\2" +
					"\u0179\u0173\3\2\2\2\u0179\u0176\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c" +
					"\7\t\2\2\u017c\63\3\2\2\2\u017d\u017e\5\f\7\2\u017e\u017f\7.\2\2\u017f" +
					"\u0185\b\33\1\2\u0180\u0181\7\b\2\2\u0181\u0182\7.\2\2\u0182\u0184\b\33" +
					"\1\2\u0183\u0180\3\2\2\2\u0184\u0187\3\2\2\2\u0185\u0183\3\2\2\2\u0185" +
					"\u0186\3\2\2\2\u0186\65\3\2\2\2\u0187\u0185\3\2\2\2\u0188\u0189\7\'\2" +
					"\2\u0189\u018a\7\6\2\2\u018a\u018b\5\20\t\2\u018b\u018c\7\7\2\2\u018c" +
					"\u018d\7.\2\2\u018d\u018e\b\34\1\2\u018e\67\3\2\2\2\34DFV`cmv\177\u0084" +
					"\u0093\u009b\u00a6\u00be\u00c5\u00dd\u00eb\u0108\u010b\u012e\u014e\u0150" +
					"\u0164\u0167\u0170\u0179\u0185";
	public static final ATN _ATN =
			new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
			new PredictionContextCache();
	private static final String[] _LITERAL_NAMES = {
			null, "'void'", "'('", "')'", "'{'", "'}'", "','", "';'", "'int'", "'double'",
			"'char'", "'['", "']'", "'type'", "'if'", "'else'", "'while'", "'write'",
			"'read'", "'return'", "'='", "'.'", "'-'", "'*'", "'/'", "'%'", "'+'",
			"'>'", "'>='", "'<'", "'<='", "'!='", "'=='", "'&&'", "'||'", "'!'", "'typedef'",
			"'struct'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, null, null, null, null, null, null, null, null, null, null,
			null, null, "WS", "COMMENT", "CHAR_CONSTANT", "INT_CONSTANT", "REAL_CONSTANT",
			"MAIN", "ID"
	};
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

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	static {
		RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION);
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
				setState(54);
				((ProgramContext) _localctx).d = definitions();
				((ProgramContext) _localctx).ast = new Program((((ProgramContext) _localctx).d != null ? (((ProgramContext) _localctx).d.start) : null).getLine(), (((ProgramContext) _localctx).d != null ? (((ProgramContext) _localctx).d.start) : null).getCharPositionInLine() + 1, ((ProgramContext) _localctx).d.ast);
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
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						{
							setState(66);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 0, _ctx)) {
								case 1: {
									setState(57);
									((DefinitionsContext) _localctx).type_definition = type_definition();
									_localctx.ast.addAll(((DefinitionsContext) _localctx).type_definition.ast);
								}
								break;
								case 2: {
									setState(60);
									((DefinitionsContext) _localctx).variable_definition = variable_definition();
									_localctx.ast.addAll(((DefinitionsContext) _localctx).variable_definition.ast);
								}
								break;
								case 3: {
									setState(63);
									((DefinitionsContext) _localctx).function_definition = function_definition();
									_localctx.ast.add(((DefinitionsContext) _localctx).function_definition.ast);
								}
								break;
							}
						}
					}
					setState(70);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 1, _ctx);
				}
				setState(71);
				((DefinitionsContext) _localctx).main = main();
				_localctx.ast.add(((DefinitionsContext) _localctx).main.ast);
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

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(74);
				match(T__0);
				setState(75);
				((MainContext) _localctx).m = match(MAIN);
				setState(76);
				match(T__1);
				setState(77);
				match(T__2);
				setState(84);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 2, _ctx)) {
					case 1: {
						setState(78);
						match(T__3);
						setState(79);
						match(T__4);
						((MainContext) _localctx).ast = new FunctionDefinition(((MainContext) _localctx).m.getLine(), ((MainContext) _localctx).m.getCharPositionInLine() + 1, "main", VoidType.getInstance(), new ArrayList<Definition>(), new ArrayList<Statement>());
					}
					break;
					case 2: {
						setState(81);
						((MainContext) _localctx).fb = function_block();
						((MainContext) _localctx).ast = new FunctionDefinition(((MainContext) _localctx).m.getLine(), ((MainContext) _localctx).m.getCharPositionInLine() + 1, "main", VoidType.getInstance(), new ArrayList<Definition>(), ((MainContext) _localctx).fb.ast);
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

	public final Variable_definitionContext variable_definition() throws RecognitionException {
		Variable_definitionContext _localctx = new Variable_definitionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_variable_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(97);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12))) != 0)) {
					{
						setState(86);
						((Variable_definitionContext) _localctx).type = type(0);
						setState(87);
						((Variable_definitionContext) _localctx).id1 = match(ID);
						_localctx.ast.add(new VariableDefinition(((Variable_definitionContext) _localctx).id1.getLine(), ((Variable_definitionContext) _localctx).id1.getCharPositionInLine() + 1, (((Variable_definitionContext) _localctx).id1 != null ? ((Variable_definitionContext) _localctx).id1.getText() : null), ((Variable_definitionContext) _localctx).type.ast));
						setState(94);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__5) {
							{
								{
									setState(89);
									match(T__5);
									setState(90);
									((Variable_definitionContext) _localctx).id2 = match(ID);
									_localctx.ast.add(new VariableDefinition(((Variable_definitionContext) _localctx).id2.getLine(), ((Variable_definitionContext) _localctx).id2.getCharPositionInLine() + 1, (((Variable_definitionContext) _localctx).id2 != null ? ((Variable_definitionContext) _localctx).id2.getText() : null), ((Variable_definitionContext) _localctx).type.ast));
								}
							}
							setState(96);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
					}
				}

				setState(99);
				match(T__6);
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
			setState(107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__7:
					enterOuterAlt(_localctx, 1);
				{
					setState(101);
					match(T__7);
					((PrimativeContext) _localctx).ast = IntType.getInstance();
				}
				break;
				case T__8:
					enterOuterAlt(_localctx, 2);
				{
					setState(103);
					match(T__8);
					((PrimativeContext) _localctx).ast = RealType.getInstance();
				}
				break;
				case T__9:
					enterOuterAlt(_localctx, 3);
				{
					setState(105);
					match(T__9);
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
				setState(116);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case T__7:
					case T__8:
					case T__9: {
						setState(110);
						((TypeContext) _localctx).primative = primative();
						((TypeContext) _localctx).ast = ((TypeContext) _localctx).primative.ast;
					}
					break;
					case T__12: {
						setState(113);
						match(T__12);
						setState(114);
						((TypeContext) _localctx).id = match(ID);
						((TypeContext) _localctx).ast = new UserDefinedType(((TypeContext) _localctx).id.getLine(), ((TypeContext) _localctx).id.getCharPositionInLine() + 1, (((TypeContext) _localctx).id != null ? ((TypeContext) _localctx).id.getText() : null));
					}
					break;
					default:
						throw new NoViableAltException(this);
				}
				_ctx.stop = _input.LT(-1);
				setState(130);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
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
								setState(118);
								if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
								setState(123);
								_errHandler.sync(this);
								_alt = 1;
								do {
									switch (_alt) {
										case 1: {
											{
												setState(119);
												match(T__10);
												setState(120);
												((TypeContext) _localctx).c = match(INT_CONSTANT);
												setState(121);
												match(T__11);
												_localctx.indexes.add(LexerHelper.lexemeToInt((((TypeContext) _localctx).c != null ? ((TypeContext) _localctx).c.getText() : null)));
											}
										}
										break;
										default:
											throw new NoViableAltException(this);
									}
									setState(125);
									_errHandler.sync(this);
									_alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
								} while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
								((TypeContext) _localctx).ast = ArrayType.createArray(((TypeContext) _localctx).t.ast, _localctx.indexes);
							}
						}
					}
					setState(132);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 8, _ctx);
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

	public final Function_blockContext function_block() throws RecognitionException {
		Function_blockContext _localctx = new Function_blockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(133);
				match(T__3);
				setState(134);
				((Function_blockContext) _localctx).v = variable_definition_block();
				_localctx.ast.addAll(((Function_blockContext) _localctx).v.ast);
				setState(136);
				((Function_blockContext) _localctx).b = block();
				_localctx.ast.addAll(((Function_blockContext) _localctx).b.ast);
				setState(138);
				match(T__4);
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

	public final Variable_definition_blockContext variable_definition_block() throws RecognitionException {
		Variable_definition_blockContext _localctx = new Variable_definition_blockContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variable_definition_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12))) != 0)) {
					{
						{
							setState(140);
							((Variable_definition_blockContext) _localctx).v = variable_definition();
							for (Definition d : ((Variable_definition_blockContext) _localctx).v.ast) {
								_localctx.ast.add((Statement) d);
							}
						}
					}
					setState(147);
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

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__13) | (1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18) | (1L << T__21) | (1L << T__34) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID))) != 0)) {
					{
						{
							setState(148);
							((BlockContext) _localctx).s = statement();
							_localctx.ast.addAll(((BlockContext) _localctx).s.ast);
						}
					}
					setState(155);
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

	public final Statement_blockContext statement_block() throws RecognitionException {
		Statement_blockContext _localctx = new Statement_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement_block);
		try {
			setState(164);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__3:
					enterOuterAlt(_localctx, 1);
				{
					setState(156);
					match(T__3);
					setState(157);
					((Statement_blockContext) _localctx).b = block();
					setState(158);
					match(T__4);
					_localctx.ast.addAll(((Statement_blockContext) _localctx).b.ast);
				}
				break;
				case T__1:
				case T__13:
				case T__15:
				case T__16:
				case T__17:
				case T__18:
				case T__21:
				case T__34:
				case CHAR_CONSTANT:
				case INT_CONSTANT:
				case REAL_CONSTANT:
				case ID:
					enterOuterAlt(_localctx, 2);
				{
					setState(161);
					((Statement_blockContext) _localctx).s = statement();
					_localctx.ast.addAll(((Statement_blockContext) _localctx).s.ast);
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

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_statement);
		try {
			setState(188);
			_errHandler.sync(this);
			switch (getInterpreter().adaptivePredict(_input, 12, _ctx)) {
				case 1:
					enterOuterAlt(_localctx, 1);
				{
					setState(166);
					((StatementContext) _localctx).ws = write_statement();
					_localctx.ast.addAll(((StatementContext) _localctx).ws.ast);
				}
				break;
				case 2:
					enterOuterAlt(_localctx, 2);
				{
					setState(169);
					((StatementContext) _localctx).rs = read_statement();
					_localctx.ast.addAll(((StatementContext) _localctx).rs.ast);
				}
				break;
				case 3:
					enterOuterAlt(_localctx, 3);
				{
					setState(172);
					((StatementContext) _localctx).ifs = if_statement();
					_localctx.ast.addAll(((StatementContext) _localctx).ifs.ast);
				}
				break;
				case 4:
					enterOuterAlt(_localctx, 4);
				{
					setState(175);
					((StatementContext) _localctx).whs = while_statement();
					_localctx.ast.add(((StatementContext) _localctx).whs.ast);
				}
				break;
				case 5:
					enterOuterAlt(_localctx, 5);
				{
					setState(178);
					((StatementContext) _localctx).res = return_statement();
					_localctx.ast.add(((StatementContext) _localctx).res.ast);
				}
				break;
				case 6:
					enterOuterAlt(_localctx, 6);
				{
					setState(181);
					((StatementContext) _localctx).as = assignment_statement();
					_localctx.ast.add(((StatementContext) _localctx).as.ast);
				}
				break;
				case 7:
					enterOuterAlt(_localctx, 7);
				{
					setState(184);
					((StatementContext) _localctx).fi = function_invocation();
					setState(185);
					match(T__6);
					_localctx.ast.add((Statement) ((StatementContext) _localctx).fi.ast);
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

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(190);
				match(T__13);
				setState(191);
				((If_statementContext) _localctx).cb1 = condition_block();
				_localctx.ast.add(new If((((If_statementContext) _localctx).cb1 != null ? (((If_statementContext) _localctx).cb1.start) : null).getLine(), (((If_statementContext) _localctx).cb1 != null ? (((If_statementContext) _localctx).cb1.start) : null).getCharPositionInLine() + 1, ((If_statementContext) _localctx).cb1.exp, ((If_statementContext) _localctx).cb1.stmts));
				setState(195);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
					case 1: {
						setState(193);
						match(T__14);
						setState(194);
						((If_statementContext) _localctx).sb = statement_block();
					}
					break;
				}
				_localctx.ast.add(new Else((((If_statementContext) _localctx).sb != null ? (((If_statementContext) _localctx).sb.start) : null).getLine(), (((If_statementContext) _localctx).sb != null ? (((If_statementContext) _localctx).sb.start) : null).getCharPositionInLine() + 1, ((If_statementContext) _localctx).sb.ast));
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

	public final While_statementContext while_statement() throws RecognitionException {
		While_statementContext _localctx = new While_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_while_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(199);
				match(T__15);
				setState(200);
				((While_statementContext) _localctx).cb = condition_block();
				((While_statementContext) _localctx).ast = new While((((While_statementContext) _localctx).cb != null ? (((While_statementContext) _localctx).cb.start) : null).getLine(), (((While_statementContext) _localctx).cb != null ? (((While_statementContext) _localctx).cb.start) : null).getCharPositionInLine() + 1, ((While_statementContext) _localctx).cb.exp, ((While_statementContext) _localctx).cb.stmts);
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

	public final Condition_blockContext condition_block() throws RecognitionException {
		Condition_blockContext _localctx = new Condition_blockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(203);
				match(T__1);
				setState(204);
				((Condition_blockContext) _localctx).e = expression(0);
				setState(205);
				match(T__2);
				((Condition_blockContext) _localctx).exp = ((Condition_blockContext) _localctx).e.ast;
				setState(207);
				((Condition_blockContext) _localctx).sb = statement_block();
				_localctx.stmts.addAll(((Condition_blockContext) _localctx).sb.ast);
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

	public final Write_statementContext write_statement() throws RecognitionException {
		Write_statementContext _localctx = new Write_statementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_write_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(210);
				match(T__16);
				setState(211);
				((Write_statementContext) _localctx).e1 = expression(0);
				_localctx.ast.add(new Write((((Write_statementContext) _localctx).e1 != null ? (((Write_statementContext) _localctx).e1.start) : null).getLine(), (((Write_statementContext) _localctx).e1 != null ? (((Write_statementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((Write_statementContext) _localctx).e1.ast));
				setState(219);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__5) {
					{
						{
							setState(213);
							match(T__5);
							setState(214);
							((Write_statementContext) _localctx).e2 = expression(0);
							_localctx.ast.add(new Write((((Write_statementContext) _localctx).e2 != null ? (((Write_statementContext) _localctx).e2.start) : null).getLine(), (((Write_statementContext) _localctx).e2 != null ? (((Write_statementContext) _localctx).e2.start) : null).getCharPositionInLine() + 1, ((Write_statementContext) _localctx).e2.ast));
						}
					}
					setState(221);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(222);
				match(T__6);
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

	public final Read_statementContext read_statement() throws RecognitionException {
		Read_statementContext _localctx = new Read_statementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_read_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(224);
				match(T__17);
				setState(225);
				((Read_statementContext) _localctx).e1 = expression(0);
				_localctx.ast.add(new Read((((Read_statementContext) _localctx).e1 != null ? (((Read_statementContext) _localctx).e1.start) : null).getLine(), (((Read_statementContext) _localctx).e1 != null ? (((Read_statementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((Read_statementContext) _localctx).e1.ast));
				setState(233);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__5) {
					{
						{
							setState(227);
							match(T__5);
							setState(228);
							((Read_statementContext) _localctx).e2 = expression(0);
							_localctx.ast.add(new Read((((Read_statementContext) _localctx).e2 != null ? (((Read_statementContext) _localctx).e2.start) : null).getLine(), (((Read_statementContext) _localctx).e2 != null ? (((Read_statementContext) _localctx).e2.start) : null).getCharPositionInLine() + 1, ((Read_statementContext) _localctx).e2.ast));
						}
					}
					setState(235);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(236);
				match(T__6);
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

	public final Return_statementContext return_statement() throws RecognitionException {
		Return_statementContext _localctx = new Return_statementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_return_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(238);
				match(T__18);
				setState(239);
				((Return_statementContext) _localctx).e1 = expression(0);
				setState(240);
				match(T__6);
				((Return_statementContext) _localctx).ast = new Return((((Return_statementContext) _localctx).e1 != null ? (((Return_statementContext) _localctx).e1.start) : null).getLine(), (((Return_statementContext) _localctx).e1 != null ? (((Return_statementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((Return_statementContext) _localctx).e1.ast);
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

	public final Assignment_statementContext assignment_statement() throws RecognitionException {
		Assignment_statementContext _localctx = new Assignment_statementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_assignment_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(243);
				((Assignment_statementContext) _localctx).e1 = expression(0);
				setState(244);
				match(T__19);
				setState(245);
				((Assignment_statementContext) _localctx).e2 = expression(0);
				setState(246);
				match(T__6);
				((Assignment_statementContext) _localctx).ast = new Assignment((((Assignment_statementContext) _localctx).e1 != null ? (((Assignment_statementContext) _localctx).e1.start) : null).getLine(), (((Assignment_statementContext) _localctx).e1 != null ? (((Assignment_statementContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((Assignment_statementContext) _localctx).e1.ast, ((Assignment_statementContext) _localctx).e2.ast);
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
		enterRule(_localctx, 36, RULE_function_invocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(249);
				((Function_invocationContext) _localctx).id = match(ID);
				setState(250);
				((Function_invocationContext) _localctx).args = argument_list();
				((Function_invocationContext) _localctx).ast = new FunctionExpression(((Function_invocationContext) _localctx).id.getLine(), ((Function_invocationContext) _localctx).id.getCharPositionInLine() + 1,
						new Variable(((Function_invocationContext) _localctx).id.getLine(), ((Function_invocationContext) _localctx).id.getCharPositionInLine() + 1, (((Function_invocationContext) _localctx).id != null ? ((Function_invocationContext) _localctx).id.getText() : null)), ((Function_invocationContext) _localctx).args.args);
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

	public final Argument_listContext argument_list() throws RecognitionException {
		Argument_listContext _localctx = new Argument_listContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argument_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(253);
				match(T__1);
				setState(265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__21) | (1L << T__34) | (1L << CHAR_CONSTANT) | (1L << INT_CONSTANT) | (1L << REAL_CONSTANT) | (1L << ID))) != 0)) {
					{
						setState(254);
						((Argument_listContext) _localctx).e1 = expression(0);
						_localctx.args.add(((Argument_listContext) _localctx).e1.ast);
						setState(262);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__5) {
							{
								{
									setState(256);
									match(T__5);
									setState(257);
									((Argument_listContext) _localctx).e2 = expression(0);
									_localctx.args.add(((Argument_listContext) _localctx).e2.ast);
								}
							}
							setState(264);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
					}
				}

				setState(267);
				match(T__2);
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
		int _startState = 40;
		enterRecursionRule(_localctx, 40, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
				setState(300);
				_errHandler.sync(this);
				switch (getInterpreter().adaptivePredict(_input, 18, _ctx)) {
					case 1: {
						setState(270);
						((ExpressionContext) _localctx).ID = match(ID);
						((ExpressionContext) _localctx).ast = new Variable(((ExpressionContext) _localctx).ID.getLine(), ((ExpressionContext) _localctx).ID.getCharPositionInLine() + 1, (((ExpressionContext) _localctx).ID != null ? ((ExpressionContext) _localctx).ID.getText() : null));
					}
					break;
					case 2: {
						setState(272);
						((ExpressionContext) _localctx).fi = function_invocation();
						((ExpressionContext) _localctx).ast = ((ExpressionContext) _localctx).fi.ast;
					}
					break;
					case 3: {
						setState(275);
						((ExpressionContext) _localctx).i = match(INT_CONSTANT);
						((ExpressionContext) _localctx).ast = new IntLiteral(((ExpressionContext) _localctx).i.getLine(), ((ExpressionContext) _localctx).i.getCharPositionInLine() + 1, LexerHelper.lexemeToInt((((ExpressionContext) _localctx).i != null ? ((ExpressionContext) _localctx).i.getText() : null)));
					}
					break;
					case 4: {
						setState(277);
						((ExpressionContext) _localctx).r = match(REAL_CONSTANT);
						((ExpressionContext) _localctx).ast = new RealLiteral(((ExpressionContext) _localctx).r.getLine(), ((ExpressionContext) _localctx).r.getCharPositionInLine() + 1, LexerHelper.lexemeToReal((((ExpressionContext) _localctx).r != null ? ((ExpressionContext) _localctx).r.getText() : null)));
					}
					break;
					case 5: {
						setState(279);
						((ExpressionContext) _localctx).c = match(CHAR_CONSTANT);
						((ExpressionContext) _localctx).ast = new CharLiteral(((ExpressionContext) _localctx).c.getLine(), ((ExpressionContext) _localctx).c.getCharPositionInLine() + 1, LexerHelper.lexemeToChar((((ExpressionContext) _localctx).c != null ? ((ExpressionContext) _localctx).c.getText() : null)));
					}
					break;
					case 6: {
						setState(281);
						match(T__1);
						setState(282);
						((ExpressionContext) _localctx).e1 = expression(0);
						setState(283);
						match(T__2);
						((ExpressionContext) _localctx).ast = ((ExpressionContext) _localctx).e1.ast;
					}
					break;
					case 7: {
						setState(286);
						match(T__1);
						setState(287);
						((ExpressionContext) _localctx).p = primative();
						setState(288);
						match(T__2);
						setState(289);
						((ExpressionContext) _localctx).e1 = expression(7);
						((ExpressionContext) _localctx).ast = new Cast((((ExpressionContext) _localctx).p != null ? (((ExpressionContext) _localctx).p.start) : null).getLine(), (((ExpressionContext) _localctx).p != null ? (((ExpressionContext) _localctx).p.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).p.ast, ((ExpressionContext) _localctx).e1.ast);
					}
					break;
					case 8: {
						setState(292);
						match(T__21);
						setState(293);
						((ExpressionContext) _localctx).e1 = expression(6);
						((ExpressionContext) _localctx).ast = new UnaryMinus((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast);
					}
					break;
					case 9: {
						setState(296);
						match(T__34);
						setState(297);
						((ExpressionContext) _localctx).e1 = expression(1);
						((ExpressionContext) _localctx).ast = new Not((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast);
					}
					break;
				}
				_ctx.stop = _input.LT(-1);
				setState(334);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
				while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
					if (_alt == 1) {
						if (_parseListeners != null) triggerExitRuleEvent();
						_prevctx = _localctx;
						{
							setState(332);
							_errHandler.sync(this);
							switch (getInterpreter().adaptivePredict(_input, 19, _ctx)) {
								case 1: {
									_localctx = new ExpressionContext(_parentctx, _parentState);
									_localctx.e1 = _prevctx;
									_localctx.e1 = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(302);
									if (!(precpred(_ctx, 5)))
										throw new FailedPredicateException(this, "precpred(_ctx, 5)");
									setState(303);
									((ExpressionContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__22) | (1L << T__23) | (1L << T__24))) != 0))) {
										((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(304);
									((ExpressionContext) _localctx).e2 = expression(6);
									((ExpressionContext) _localctx).ast = new Arithmetic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
								}
								break;
								case 2: {
									_localctx = new ExpressionContext(_parentctx, _parentState);
									_localctx.e1 = _prevctx;
									_localctx.e1 = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(307);
									if (!(precpred(_ctx, 4)))
										throw new FailedPredicateException(this, "precpred(_ctx, 4)");
									setState(308);
									((ExpressionContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == T__21 || _la == T__25)) {
										((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(309);
									((ExpressionContext) _localctx).e2 = expression(5);
									((ExpressionContext) _localctx).ast = new Arithmetic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
								}
								break;
								case 3: {
									_localctx = new ExpressionContext(_parentctx, _parentState);
									_localctx.e1 = _prevctx;
									_localctx.e1 = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(312);
									if (!(precpred(_ctx, 3)))
										throw new FailedPredicateException(this, "precpred(_ctx, 3)");
									setState(313);
									((ExpressionContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__26) | (1L << T__27) | (1L << T__28) | (1L << T__29) | (1L << T__30) | (1L << T__31))) != 0))) {
										((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(314);
									((ExpressionContext) _localctx).e2 = expression(4);
									((ExpressionContext) _localctx).ast = new Comparison((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
								}
								break;
								case 4: {
									_localctx = new ExpressionContext(_parentctx, _parentState);
									_localctx.e1 = _prevctx;
									_localctx.e1 = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(317);
									if (!(precpred(_ctx, 2)))
										throw new FailedPredicateException(this, "precpred(_ctx, 2)");
									setState(318);
									((ExpressionContext) _localctx).op = _input.LT(1);
									_la = _input.LA(1);
									if (!(_la == T__32 || _la == T__33)) {
										((ExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
									} else {
										if (_input.LA(1) == Token.EOF) matchedEOF = true;
										_errHandler.reportMatch(this);
										consume();
									}
									setState(319);
									((ExpressionContext) _localctx).e2 = expression(3);
									((ExpressionContext) _localctx).ast = new Logic((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).op != null ? ((ExpressionContext) _localctx).op.getText() : null), ((ExpressionContext) _localctx).e2.ast);
								}
								break;
								case 5: {
									_localctx = new ExpressionContext(_parentctx, _parentState);
									_localctx.e1 = _prevctx;
									_localctx.e1 = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(322);
									if (!(precpred(_ctx, 14)))
										throw new FailedPredicateException(this, "precpred(_ctx, 14)");
									setState(323);
									match(T__10);
									setState(324);
									((ExpressionContext) _localctx).e2 = expression(0);
									setState(325);
									match(T__11);
									((ExpressionContext) _localctx).ast = new Indexing((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, ((ExpressionContext) _localctx).e2.ast);
								}
								break;
								case 6: {
									_localctx = new ExpressionContext(_parentctx, _parentState);
									_localctx.e1 = _prevctx;
									_localctx.e1 = _prevctx;
									pushNewRecursionContext(_localctx, _startState, RULE_expression);
									setState(328);
									if (!(precpred(_ctx, 13)))
										throw new FailedPredicateException(this, "precpred(_ctx, 13)");
									setState(329);
									match(T__20);
									setState(330);
									((ExpressionContext) _localctx).id = match(ID);
									((ExpressionContext) _localctx).ast = new Dot((((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getLine(), (((ExpressionContext) _localctx).e1 != null ? (((ExpressionContext) _localctx).e1.start) : null).getCharPositionInLine() + 1, ((ExpressionContext) _localctx).e1.ast, (((ExpressionContext) _localctx).id != null ? ((ExpressionContext) _localctx).id.getText() : null));
								}
								break;
							}
						}
					}
					setState(336);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input, 20, _ctx);
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
		enterRule(_localctx, 42, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(337);
				((Function_definitionContext) _localctx).r = return_type();
				setState(338);
				((Function_definitionContext) _localctx).ID = match(ID);
				setState(339);
				((Function_definitionContext) _localctx).p = parameter_list();
				setState(340);
				((Function_definitionContext) _localctx).s = function_block();
				((Function_definitionContext) _localctx).ast = new FunctionDefinition(((Function_definitionContext) _localctx).ID.getLine(), ((Function_definitionContext) _localctx).ID.getCharPositionInLine() + 1, (((Function_definitionContext) _localctx).ID != null ? ((Function_definitionContext) _localctx).ID.getText() : null), ((Function_definitionContext) _localctx).r.ast, ((Function_definitionContext) _localctx).p.params, ((Function_definitionContext) _localctx).s.ast);
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
		enterRule(_localctx, 44, RULE_parameter_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(343);
				match(T__1);
				setState(357);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__12))) != 0)) {
					{
						setState(344);
						((Parameter_listContext) _localctx).t1 = type(0);
						setState(345);
						((Parameter_listContext) _localctx).id1 = match(ID);
						_localctx.params.add(new VariableDefinition(((Parameter_listContext) _localctx).id1.getLine(), ((Parameter_listContext) _localctx).id1.getCharPositionInLine() + 1, (((Parameter_listContext) _localctx).id1 != null ? ((Parameter_listContext) _localctx).id1.getText() : null), ((Parameter_listContext) _localctx).t1.ast));
						setState(354);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la == T__5) {
							{
								{
									setState(347);
									match(T__5);
									setState(348);
									((Parameter_listContext) _localctx).t2 = type(0);
									setState(349);
									((Parameter_listContext) _localctx).id2 = match(ID);
									_localctx.params.add(new VariableDefinition(((Parameter_listContext) _localctx).id1.getLine(), ((Parameter_listContext) _localctx).id1.getCharPositionInLine() + 1, (((Parameter_listContext) _localctx).id2 != null ? ((Parameter_listContext) _localctx).id2.getText() : null), ((Parameter_listContext) _localctx).t2.ast));
								}
							}
							setState(356);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
					}
				}

				setState(359);
				match(T__2);
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
		enterRule(_localctx, 46, RULE_return_type);
		try {
			setState(366);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
				case T__7:
				case T__8:
				case T__9:
					enterOuterAlt(_localctx, 1);
				{
					setState(361);
					((Return_typeContext) _localctx).p = primative();
					((Return_typeContext) _localctx).ast = ((Return_typeContext) _localctx).p.ast;
				}
				break;
				case T__0:
					enterOuterAlt(_localctx, 2);
				{
					setState(364);
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

	public final Type_definitionContext type_definition() throws RecognitionException {
		Type_definitionContext _localctx = new Type_definitionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_type_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(368);
				match(T__35);
				setState(375);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
					case T__7:
					case T__8:
					case T__9:
					case T__12: {
						setState(369);
						((Type_definitionContext) _localctx).td = typedef_definition();
						_localctx.ast.addAll(((Type_definitionContext) _localctx).td.ast);
					}
					break;
					case T__36: {
						setState(372);
						((Type_definitionContext) _localctx).sd = struct_definition();
						_localctx.ast.add(((Type_definitionContext) _localctx).sd.ast);
					}
					break;
					default:
						throw new NoViableAltException(this);
				}
				setState(377);
				match(T__6);
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
		enterRule(_localctx, 50, RULE_typedef_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(379);
				((Typedef_definitionContext) _localctx).t = type(0);
				setState(380);
				((Typedef_definitionContext) _localctx).id1 = match(ID);
				_localctx.ast.add(new TypeDefinition(((Typedef_definitionContext) _localctx).id1.getLine(), ((Typedef_definitionContext) _localctx).id1.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id1 != null ? ((Typedef_definitionContext) _localctx).id1.getText() : null), ((Typedef_definitionContext) _localctx).t.ast));
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la == T__5) {
					{
						{
							setState(382);
							match(T__5);
							setState(383);
							((Typedef_definitionContext) _localctx).id2 = match(ID);
							_localctx.ast.add(new TypeDefinition(((Typedef_definitionContext) _localctx).id2.getLine(), ((Typedef_definitionContext) _localctx).id2.getCharPositionInLine() + 1, (((Typedef_definitionContext) _localctx).id2 != null ? ((Typedef_definitionContext) _localctx).id2.getText() : null), ((Typedef_definitionContext) _localctx).t.ast));
						}
					}
					setState(389);
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

	public final Struct_definitionContext struct_definition() throws RecognitionException {
		Struct_definitionContext _localctx = new Struct_definitionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_struct_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
				setState(390);
				match(T__36);
				setState(391);
				match(T__3);
				setState(392);
				((Struct_definitionContext) _localctx).vdb = variable_definition_block();
				setState(393);
				match(T__4);
				setState(394);
				((Struct_definitionContext) _localctx).id = match(ID);
				((Struct_definitionContext) _localctx).ast = new StructDefinition(((Struct_definitionContext) _localctx).id.getLine(), ((Struct_definitionContext) _localctx).id.getCharPositionInLine() + 1, (((Struct_definitionContext) _localctx).id != null ? ((Struct_definitionContext) _localctx).id.getText() : null), ((Struct_definitionContext) _localctx).vdb.ast);
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
			case 20:
				return expression_sempred((ExpressionContext) _localctx, predIndex);
		}
		return true;
	}

	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
			case 0:
				return precpred(_ctx, 2);
		}
		return true;
	}

	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
			case 1:
				return precpred(_ctx, 5);
			case 2:
				return precpred(_ctx, 4);
			case 3:
				return precpred(_ctx, 3);
			case 4:
				return precpred(_ctx, 2);
			case 5:
				return precpred(_ctx, 14);
			case 6:
				return precpred(_ctx, 13);
		}
		return true;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Program ast;
		public DefinitionsContext d;
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public DefinitionsContext definitions() {
			return getRuleContext(DefinitionsContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_program;
		}
	}

	public static class DefinitionsContext extends ParserRuleContext {
		public List<Definition> ast = new ArrayList<Definition>();
		public Type_definitionContext type_definition;
		public Variable_definitionContext variable_definition;
		public Function_definitionContext function_definition;
		public MainContext main;
		public DefinitionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public MainContext main() {
			return getRuleContext(MainContext.class, 0);
		}

		public List<Type_definitionContext> type_definition() {
			return getRuleContexts(Type_definitionContext.class);
		}

		public Type_definitionContext type_definition(int i) {
			return getRuleContext(Type_definitionContext.class, i);
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

	public static class MainContext extends ParserRuleContext {
		public Definition ast;
		public Token m;
		public Function_blockContext fb;

		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode MAIN() {
			return getToken(CmmParser.MAIN, 0);
		}

		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_main;
		}
	}

	public static class Variable_definitionContext extends ParserRuleContext {
		public ArrayList<Definition> ast = new ArrayList<Definition>();
		public TypeContext type;
		public Token id1;
		public Token id2;
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

		@Override
		public int getRuleIndex() {
			return RULE_variable_definition;
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
		public Token id;
		public Token c;
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public PrimativeContext primative() {
			return getRuleContext(PrimativeContext.class, 0);
		}

		public TerminalNode ID() {
			return getToken(CmmParser.ID, 0);
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

	public static class Function_blockContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public Variable_definition_blockContext v;
		public BlockContext b;
		public Function_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public Variable_definition_blockContext variable_definition_block() {
			return getRuleContext(Variable_definition_blockContext.class, 0);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_function_block;
		}
	}

	public static class Variable_definition_blockContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public Variable_definitionContext v;
		public Variable_definition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<Variable_definitionContext> variable_definition() {
			return getRuleContexts(Variable_definitionContext.class);
		}

		public Variable_definitionContext variable_definition(int i) {
			return getRuleContext(Variable_definitionContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_variable_definition_block;
		}
	}

	public static class BlockContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public StatementContext s;
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}

		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_block;
		}
	}

	public static class Statement_blockContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public BlockContext b;
		public StatementContext s;
		public Statement_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public BlockContext block() {
			return getRuleContext(BlockContext.class, 0);
		}

		public StatementContext statement() {
			return getRuleContext(StatementContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_statement_block;
		}
	}

	public static class StatementContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public Write_statementContext ws;
		public Read_statementContext rs;
		public If_statementContext ifs;
		public While_statementContext whs;
		public Return_statementContext res;
		public Assignment_statementContext as;
		public Function_invocationContext fi;
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public Write_statementContext write_statement() {
			return getRuleContext(Write_statementContext.class, 0);
		}

		public Read_statementContext read_statement() {
			return getRuleContext(Read_statementContext.class, 0);
		}

		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class, 0);
		}

		public While_statementContext while_statement() {
			return getRuleContext(While_statementContext.class, 0);
		}

		public Return_statementContext return_statement() {
			return getRuleContext(Return_statementContext.class, 0);
		}

		public Assignment_statementContext assignment_statement() {
			return getRuleContext(Assignment_statementContext.class, 0);
		}

		public Function_invocationContext function_invocation() {
			return getRuleContext(Function_invocationContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_statement;
		}
	}

	public static class If_statementContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public Condition_blockContext cb1;
		public Statement_blockContext sb;
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class, 0);
		}

		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_if_statement;
		}
	}

	public static class While_statementContext extends ParserRuleContext {
		public Statement ast;
		public Condition_blockContext cb;
		public While_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public Condition_blockContext condition_block() {
			return getRuleContext(Condition_blockContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_while_statement;
		}
	}

	public static class Condition_blockContext extends ParserRuleContext {
		public Expression exp;
		public ArrayList<Statement> stmts = new ArrayList<Statement>();
		public ExpressionContext e;
		public Statement_blockContext sb;
		public Condition_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		public Statement_blockContext statement_block() {
			return getRuleContext(Statement_blockContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_condition_block;
		}
	}

	public static class Write_statementContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Write_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_write_statement;
		}
	}

	public static class Read_statementContext extends ParserRuleContext {
		public ArrayList<Statement> ast = new ArrayList<Statement>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Read_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_read_statement;
		}
	}

	public static class Return_statementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public Return_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_return_statement;
		}
	}

	public static class Assignment_statementContext extends ParserRuleContext {
		public Statement ast;
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Assignment_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_assignment_statement;
		}
	}

	public static class Function_invocationContext extends ParserRuleContext {
		public Expression ast;
		public Token id;
		public Argument_listContext args;
		public Function_invocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public TerminalNode ID() {
			return getToken(CmmParser.ID, 0);
		}

		public Argument_listContext argument_list() {
			return getRuleContext(Argument_listContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_function_invocation;
		}
	}

	public static class Argument_listContext extends ParserRuleContext {
		public ArrayList<Expression> args = new ArrayList<Expression>();
		public ExpressionContext e1;
		public ExpressionContext e2;
		public Argument_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}

		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class, i);
		}

		@Override
		public int getRuleIndex() {
			return RULE_argument_list;
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
		public Token op;
		public ExpressionContext e2;
		public Token id;
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
		public Function_blockContext s;
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

		public Function_blockContext function_block() {
			return getRuleContext(Function_blockContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_function_definition;
		}
	}

	public static class Parameter_listContext extends ParserRuleContext {
		public ArrayList<Definition> params = new ArrayList<Definition>();
		public TypeContext t1;
		public Token id1;
		public TypeContext t2;
		public Token id2;
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}

		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class, i);
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

	public static class Type_definitionContext extends ParserRuleContext {
		public ArrayList<Definition> ast = new ArrayList<Definition>();
		public Typedef_definitionContext td;
		public Struct_definitionContext sd;

		public Type_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public Typedef_definitionContext typedef_definition() {
			return getRuleContext(Typedef_definitionContext.class, 0);
		}

		public Struct_definitionContext struct_definition() {
			return getRuleContext(Struct_definitionContext.class, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_type_definition;
		}
	}

	public static class Typedef_definitionContext extends ParserRuleContext {
		public ArrayList<Definition> ast = new ArrayList<Definition>();
		public TypeContext t;
		public Token id1;
		public Token id2;

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

		@Override
		public int getRuleIndex() {
			return RULE_typedef_definition;
		}
	}

	public static class Struct_definitionContext extends ParserRuleContext {
		public StructDefinition ast;
		public Variable_definition_blockContext vdb;
		public Token id;
		public Struct_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}

		public Variable_definition_blockContext variable_definition_block() {
			return getRuleContext(Variable_definition_blockContext.class, 0);
		}

		public TerminalNode ID() {
			return getToken(CmmParser.ID, 0);
		}

		@Override
		public int getRuleIndex() {
			return RULE_struct_definition;
		}
	}
}
grammar CmmLexerRules;

/********************* MISC *********************/
WS  : [ \t\r\n]+ -> skip
    ;

COMMENT
    : ( '//' .*? ('\n'|'\r'|EOF)
    | '/*' .*? '*/' ) -> skip
    ;
/********************* CHAR TYPE *********************/
CHAR_CONSTANT
    :  '\'' ('\\t' | '\\n' | INT_CONSTANT | '\\' INT_CONSTANT+ | .) '\''
    ;
/********************* INT TYPE *********************/
fragment
DIGIT
    : [0-9]
    ;

INT_CONSTANT
    : '0'
    | [1-9] DIGIT*
    ;
/********************* REAL TYPE *********************/
fragment
SCIENCE_NOTATION
    : ('E' | 'e') ('-' | '+' |  ) DIGIT+
    ;

REAL_CONSTANT
    : DIGIT* '.' DIGIT+ SCIENCE_NOTATION    // possible integer-part, required ".", required fractional, required science notaiton
    | DIGIT+ '.' DIGIT* SCIENCE_NOTATION    // required integer-part, required ".", possible fractional, required science notaiton
    | DIGIT+ SCIENCE_NOTATION               // required integer-part, required science notataion
    | DIGIT* '.' DIGIT+
    | DIGIT+ '.' DIGIT*
    ;
/********************* IDENTIFIER / VARIABLE NAMES *********************/
fragment
LETTER
    : [a-zA-Z]
    ;

MAIN: 'm' 'a' 'i' 'n'
    ;

ID  : (LETTER | '_') (LETTER | DIGIT | '_')*
    ;
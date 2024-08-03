grammar MIDL;


MODULE: 'module';
STRUCT: 'struct';
BOOLEAN: 'boolean';
SHORT: 'short';
LONG: 'long';
UNSIGNED: 'unsigned';
INT8: 'int8';
INT16: 'int16';
INT32: 'int32';
INT64: 'int64';
UINT8: 'uint8';
UINT16: 'uint16';
UINT32: 'uint32';
UINT64: 'uint64';
CHAR: 'char';
STRING: 'string';
FLOAT: 'float';
DOUBLE: 'double';
TRUE: 'true';
FALSE: 'false';

LCURLY: '{';
RCURLY: '}';
LBRACK: '[';
RBRACK: ']';
SEMI: ';';
COMMA: ',';
PLUS: '+';
MINUS: '-';
SLASH: '/';
STAR: '*';
PERCENT: '%';
RSHIFT: '>>';
LSHIFT: '<<';
EQUAL: '=';
AMP: '&';
BAR: '|';
TILDE: '~';
CARET: '^';
COLON: ':';
DCOLON: '::';

fragment LETTER: [a-zA-Z];
fragment DIGIT: [0-9];
fragment UNDERLINE: '_';

ID: LETTER (UNDERLINE? (LETTER | DIGIT))*;

fragment INTEGER_TYPE_SUFFIX: [lL];
INTEGER: ('0' | [1-9] DIGIT*) INTEGER_TYPE_SUFFIX?;

fragment EXPONENT: [eE] [+\-]? DIGIT+;
fragment FLOAT_TYPE_SUFFIX: [fFdD];

FLOATING_PT:
    DIGIT+ '.' DIGIT* EXPONENT? FLOAT_TYPE_SUFFIX?
    | '.' DIGIT+ EXPONENT? FLOAT_TYPE_SUFFIX?
    | DIGIT+ EXPONENT FLOAT_TYPE_SUFFIX?
    | DIGIT+ EXPONENT? FLOAT_TYPE_SUFFIX
    ;

fragment ESCAPE_SEQUENCE: '\\' [btnfr"\\'];
CHAR_LITERAL: '\'' (ESCAPE_SEQUENCE | ~[\\']) '\'';

STRING_LITERAL: '"' (ESCAPE_SEQUENCE | ~[\\"])* '"';

WS: [ \t\r\n]+ -> skip;

specification: definition+;

definition: type_decl SEMI | module_decl SEMI;

module_decl: MODULE ID LCURLY definition* RCURLY;

type_decl: struct_type | STRUCT ID;

struct_type: STRUCT ID LCURLY member_list RCURLY;

member_list: (type_spec declarators SEMI)*;

type_spec: scoped_name | base_type_spec | struct_type;

scoped_name: (DCOLON)? ID (DCOLON ID)*;

base_type_spec:
    floating_pt_type | integer_type | CHAR | STRING | BOOLEAN;

floating_pt_type:
    FLOAT | DOUBLE | LONG DOUBLE;

integer_type:
    signed_int | unsigned_int;

signed_int:
    SHORT | INT16 |
    LONG INT32 |
    LONG LONG INT64 |
    INT8;

unsigned_int:
    UNSIGNED SHORT | UINT16 |
    UNSIGNED LONG | UINT32 |
    UNSIGNED LONG LONG | UINT64 |
    UINT8;

declarators: declarator (COMMA declarator)*;

declarator: simple_declarator | array_declarator;

simple_declarator: ID (EQUAL or_expr)?;

array_declarator: ID LBRACK or_expr RBRACK (EQUAL exp_list)?;

exp_list: LBRACK or_expr (COMMA or_expr)* RBRACK;

or_expr: xor_expr (BAR xor_expr)*;

xor_expr: and_expr (CARET and_expr)*;

and_expr: shift_expr (AMP shift_expr)*;

shift_expr: add_expr ((RSHIFT | LSHIFT) add_expr)*;

add_expr: mult_expr ((PLUS | MINUS) mult_expr)*;

mult_expr: unary_expr ((STAR | SLASH | PERCENT) unary_expr)*;

unary_expr: (MINUS | PLUS | TILDE)? literal;

literal: INTEGER | FLOATING_PT | CHAR_LITERAL | STRING_LITERAL | BOOLEAN;

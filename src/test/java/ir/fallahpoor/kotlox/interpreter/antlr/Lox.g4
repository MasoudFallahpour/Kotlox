grammar Lox;

program
    : declaration* EOF ;

declaration
    : varDecl
    | statement ;

varDecl
    : 'var' IDENTIFIER ('=' expression)? ';' ;

statement
    : exprStmt | printStmt ;

exprStmt
    : expression ';' ;

printStmt
    : 'print' expression ';' ;

expression
    : assignment ;

assignment
    : IDENTIFIER assign='=' assignment
    | equality (op+=',' equality)* ;

equality
    : comparison (op+=('!=' | '==') comparison)* ;

comparison
    : term (op+=( '>' | '>=' | '<' | '<=') term)* ;

term
    : factor (op+=('-' | '+') factor)* ;

factor
    : unary (op+=( '/' | '*') unary)* ;

unary
    : op+=('!' | '-') unary
    | primary ;

primary
    : NUMBER
    | STRING
    | IDENTIFIER
    | 'true'
    | 'false'
    | 'nil'
    | '(' expression ')' ;

NUMBER: [0-9]+ ('.' [0-9]+)? ;
STRING: '"' (~('"'))* '"' ;
IDENTIFIER: [a-zA-Z_][0-9a-zA-Z_]* ;
WS : [ \t\r\n]+ -> skip ;

OP_BANG: '!';
OP_PLUS: '+';
OP_MINUS: '-';
OP_STAR: '*';
OP_SLASH: '/';
OP_EQUAL: '==';
OP_INEQUAL: '!=';
OP_GREATER: '>';
OP_LESS: '<';
OP_GREATER_EQUAL: '>=';
OP_LESS_EQUAL: '<=';

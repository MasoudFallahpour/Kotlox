grammar Lox;

program
    : declaration* EOF ;

declaration
    : varDecl
    | statement ;

varDecl
    : 'var' IDENTIFIER ('=' expression)? ';' ;

statement
    : exprStmt
    | forStmt
    | ifStmt
    | printStmt
    | whileStmt
    | block ;

exprStmt
    : expression ';' ;

forStmt
    : 'for' '(' (varDecl | exprStmt | ';') condition=expression? ';' increment=expression? ')' body=statement ;

ifStmt
    : 'if' '(' expression ')' thenBranch=statement ('else' elseBranch=statement)? ;

printStmt
    : 'print' expression ';' ;

whileStmt
    : 'while' '(' condition=expression ')' body=statement ;

block
    : '{' declaration* '}' ;

expression
    : assignment ;

assignment
    : IDENTIFIER assign='=' assignment
    | logicOr (op+=',' logicOr)* ;

logicOr
    : logicAnd (or+='or' logicAnd)* ;

logicAnd
    : equality (and+='and' equality)* ;

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

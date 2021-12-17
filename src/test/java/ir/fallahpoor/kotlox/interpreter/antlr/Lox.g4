grammar Lox;

program
    : declaration* EOF ;

declaration
    : funcDecl
    | varDecl
    | statement ;

funcDecl
    : 'fun' function ;

function
    : IDENTIFIER '(' parameters? ')' block ;

parameters
    : IDENTIFIER (comma+=',' IDENTIFIER)* ;

varDecl
    : 'var' IDENTIFIER ('=' expression)? ';' ;

statement
    : ifStmt
    | forStmt
    | whileStmt
    | breakStmt
    | block
    | printStmt
    | exprStmt
    | returnStmt;

ifStmt
    : 'if' '(' expression ')' thenBranch=statement ('else' elseBranch=statement)? ;

forStmt
    : 'for' '(' (varDecl | exprStmt | ';') condition=expression? ';' increment=expression? ')' body=statement ;

whileStmt
    : 'while' '(' condition=expression ')' body=statement ;

breakStmt
    : 'break' ';' ;

block
    : '{' declaration* '}' ;

printStmt
    : 'print' expression ';' ;

exprStmt
    : expression ';' ;

returnStmt
    : ret='return' expression? ';' ;

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
    | call ;

call
    : primary (leftParen+='(' arguments? rightParen+=')')* ;

arguments
    : expression (comma+=',' expression)* ;

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

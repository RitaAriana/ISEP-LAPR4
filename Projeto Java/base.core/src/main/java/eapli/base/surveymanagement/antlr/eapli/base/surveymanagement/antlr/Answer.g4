grammar Answer;

start: type ;

type: FREE_TEXT ESPACO frase
 | NUMERIC ESPACO NUMERO+
 | SINGLE_CHOICE ESPACO opcao
 | MULTIPLE_CHOICE ESPACO (opcao)+
 | SINGLE_CHOICE1 ESPACO (opcao|(frase NEWLINE))
 | MULTIPLE_CHOICE1 ESPACO (opcao)+ (frase NEWLINE)?
 | SORTING_OPTIONS ESPACO (opcao)+
 | SCALING_OPTIONS ESPACO (opcao)+
 ;

frase : ( PALAVRA | NUMERO )+ (VIRGULA? ESPACO (PALAVRA| NUMERO )+)*;

opcao: alfanumerico NEWLINE;

alfanumerico: PALAVRA | NUMERO;

FREE_TEXT: 'Free-Text';
NUMERIC: 'Numeric';
SINGLE_CHOICE:'Single-Choice';
SINGLE_CHOICE1: 'Single-Choice with input value';
MULTIPLE_CHOICE:'Multiple-Choice';
MULTIPLE_CHOICE1: 'Multiple-Choice with input value';
SORTING_OPTIONS:'Sorting Options';
SCALING_OPTIONS:'Scaling Options';

NUMERO: [0-9];
PALAVRA: [a-zA-Z]+;
VIRGULA: ',';
ESPACO: ' '|'\t';
NEWLINE : [\r\n] ;
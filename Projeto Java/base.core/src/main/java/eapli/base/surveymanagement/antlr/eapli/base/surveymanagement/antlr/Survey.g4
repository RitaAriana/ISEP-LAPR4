grammar Survey;

start: questionario;

questionario: regraIdQuestionario ESPACO regraTitulo NEWLINE (regraMensagem)? (NEWLINE seccao)+ NEWLINE NEWLINE regraMensagem;

regraIdQuestionario: alfanumerico+ HIFEN alfanumerico+;

regraTitulo: frase;

regraMensagem: (frase pontucao NEWLINE)+ ;

seccao: regraId NEWLINE regraTitulo NEWLINE regraMensagem? 'Section Obligatoriness: ' obrigatoriedade (NEWLINE 'Repeatability: ' repetibilidade)? NEWLINE pergunta+;

alfanumerico: PALAVRA | NUMERO;

frase : ( PALAVRA | NUMERO )+ (VIRGULA? ESPACO (PALAVRA| NUMERO )+)*;

pontucao: PONTO_FINAL | PONTO_INTERROGACAO | RETICENCIAS | PONTO_EXCLAMACAO;

regraId: NUMERO+;

obrigatoriedade: MANDATORY | OPTIONAL | CONDITION_DEPENDENT DOIS_PONTOS ESPACO 'Section: ' regraId 'Question: ' regraId;

repetibilidade : NUMERO+ ;

pergunta: regraId NEWLINE regraPergunta PARENTESIS_ESQUERDO obrigatoriedade PARENTESIS_DIREITO  (NEWLINE regraMensagem)? NEWLINE 'Type: ' type NEWLINE;

regraPergunta: frase PONTO_INTERROGACAO NEWLINE;

type: FREE_TEXT NEWLINE NEWLINE INFO_FREE_TEXT
 | NUMERIC (ESPACO PARENTESIS_ESQUERDO DECIMALS_ALLOWED PARENTESIS_DIREITO)? NEWLINE NEWLINE INFO_NUMERIC
 | SINGLE_CHOICE NEWLINE (opcao)+ NEWLINE INFO_SINGLE_CHOICE
 | MULTIPLE_CHOICE NEWLINE (opcao)+ NEWLINE INFO_MULTIPLE_CHOICE
 | SINGLE_CHOICE1 NEWLINE (opcao)+ NEWLINE INFO_CHOICE1
 | MULTIPLE_CHOICE1 NEWLINE (opcao)+ NEWLINE INFO_CHOICE1
 | SORTING_OPTIONS NEWLINE (opcao)+ NEWLINE INFO_SORTING_OPTIONS
 | SCALING_OPTIONS NEWLINE 'Scale: ' frase NEWLINE (opcao)+ NEWLINE INFO_SCALING_OPTIONS
 ;

opcao: regraId PARENTESIS_DIREITO frase (DOIS_PONTOS)? NEWLINE;


//------------------- TOKENS -------------------

MANDATORY: 'mandatory';
OPTIONAL: 'optional';
CONDITION_DEPENDENT: 'condition dependent';

FREE_TEXT: 'Free-Text';
NUMERIC: 'Numeric';
SINGLE_CHOICE:'Single-Choice';
SINGLE_CHOICE1: 'Single-Choice with input value';
MULTIPLE_CHOICE:'Multiple-Choice';
MULTIPLE_CHOICE1: 'Multiple-Choice with input value';
SORTING_OPTIONS:'Sorting Options';
SCALING_OPTIONS:'Scaling Options';

INFO_FREE_TEXT: 'Answer the question by typing some text.';
INFO_NUMERIC: 'Answer the question by entering a numeric value.';
INFO_SINGLE_CHOICE:'Answer the question by selecting one (and only one) of the options provided.';
INFO_CHOICE1: 'The last option, if selected, implies that you write a numeric value or free text.';
INFO_MULTIPLE_CHOICE:'Select more than one.';
INFO_SORTING_OPTIONS:'Sorting the options as desired and according to the instructions provided.';
INFO_SCALING_OPTIONS:'Select a scale value for each of the specified options.';

DECIMALS_ALLOWED: 'Decimal numbers are allowed!';

NUMERO: [0-9];
PALAVRA: [a-zA-Z]+;

HIFEN: '-';
ESPACO: ' '|'\t';
PONTO_FINAL: '.';
DOIS_PONTOS: ':';
RETICENCIAS: '...';
VIRGULA: ',';
PONTO_INTERROGACAO: '?';
PONTO_EXCLAMACAO: '!';
PARENTESIS_DIREITO: ')';
PARENTESIS_ESQUERDO: '(';
NEWLINE : [\r\n] ;

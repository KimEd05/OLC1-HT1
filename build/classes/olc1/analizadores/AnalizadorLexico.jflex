package olc1.analizadores;

import java_cup.runtime.Symbol;
import java.util.LinkedList;
import olc1.ht1.Token;
import olc1.ht1.TokenError;

%% 

%{
    public static LinkedList<Token> tablaSimbolos = new LinkedList<Token>();
    public static LinkedList<TokenError> tablaErrores = new LinkedList<TokenError>();
%}

/* Directivas */
%cupsym sym 
%class Scanner
%cup
%public
%full
%8bit
%unicode
%line
%column
%char
%ignorecase

/* Expresiones regulares */
blanco = [ |\t|\n|\f|\r]+
entero = [-]?[0-9]+
identificador = [A-Za-zÑñ]+["_"0-9A-Za-zÑñ]*

%%

/* Caracteres */
"("                 { tablaSimbolos.add(new Token(0, yytext(), yyline, yycolumn));
                      return new Symbol(sym.para, yyline, yycolumn, yytext()); }
")"                 { tablaSimbolos.add(new Token(1, yytext(), yyline, yycolumn));
                      return new Symbol(sym.parc, yyline, yycolumn, yytext()); }
","                 { tablaSimbolos.add(new Token(2, yytext(), yyline, yycolumn));
                      return new Symbol(sym.coma, yyline, yycolumn, yytext()); }
";"                 { tablaSimbolos.add(new Token(3, yytext(), yyline, yycolumn));
                      return new Symbol(sym.puntoycoma, yyline, yycolumn, yytext()); }

/* Palabras reservadas */ 
"extraer"           { tablaSimbolos.add(new Token(4, yytext(), yyline, yycolumn));
                      return new Symbol(sym.extraer, yyline, yycolumn, yytext()); }

/* Elementos léxicos */
{entero}            { tablaSimbolos.add(new Token(5, yytext(), yyline, yycolumn));
                      return new Symbol(sym.entero, yyline, yycolumn, yytext()); }
{identificador}     { tablaSimbolos.add(new Token(6, yytext(), yyline, yycolumn));
                      return new Symbol(sym.identificador, yyline, yycolumn, yytext()); }
{blanco}            { /*Ignore case*/ }

/* Errores */
.                   { tablaErrores.add(new TokenError(yytext(), yyline, yycolumn, "Léxico", "Elemento Léxico desconocido"));
                      System.err.println("Elemento léxico desconocido: " + yytext() + ", Línea: " + (yyline + 1) + ", Columna: " + (yycolumn + 1)); }

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.ht1;

/**
 *
 * @author Kimberly Elias
 */
public class Token {
    
    private int token;
    private String lexema;
    private int linea;
    private int columna;
    
    public Token(int token, String lexema, int linea, int columna){
        this.token = token;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }    
    
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
}

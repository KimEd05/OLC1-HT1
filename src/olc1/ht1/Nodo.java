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
public class Nodo {
    private String valorLista;
    private int contador;
    private int posicionInicial;
    private int cantidadPalabras;

    public Nodo(int posicionInicial) {
        this.valorLista = "";
        this.contador = 1;
        this.posicionInicial = posicionInicial;
        this.cantidadPalabras = 0;
        
        if(posicionInicial < 0){
            OLC1HT1.error = "Se espera un valor entero positivo para la posición inicial.";
        } else if(posicionInicial == 0){
            OLC1HT1.error = "La posición inicial mínima es 1.";
        }
    }

    public String getValorLista() {
        return valorLista;
    }

    public void setValorLista(String valorLista) {
        this.valorLista = valorLista;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getPosicionInicial() {
        return posicionInicial;
    }

    public void setPosicionInicial(int posicionInicial) {
        this.posicionInicial = posicionInicial;
    }

    public int getCantidadPalabras() {
        return cantidadPalabras;
    }

    public void setCantidadPalabras(int cantidadPalabras) {
        this.cantidadPalabras = cantidadPalabras;
    }

    public void agregarValor(String ident){
        if(this.contador == 2){
            OLC1HT1.error = "Se espera un valor entero para la cantidad de palabras.";
        } else if(this.contador >= (this.posicionInicial + 2) && this.contador <= (this.posicionInicial + this.cantidadPalabras + 1)){
            this.valorLista += " " + ident;
        }
    }
    
    public void agregarValor(int ent){
        if(this.contador == 2){
            if(ent < 0){
                OLC1HT1.error = "Se espera un valor entero positivo para la cantidad de palabras.";
            } else {
                this.cantidadPalabras = ent;
            }
        } else if(this.contador >= (this.posicionInicial + 2) && this.contador <= (this.posicionInicial + this.cantidadPalabras + 1)){
            this.valorLista += " " + ent;
        }
    }
    
    public void validarContenido(){
        if(this.cantidadPalabras > (this.contador - 1 - this.posicionInicial)){
            OLC1HT1.error = "La cantidad de palabras solicitada excede a la cantidad de palabras existentes.";
        }
    }
}

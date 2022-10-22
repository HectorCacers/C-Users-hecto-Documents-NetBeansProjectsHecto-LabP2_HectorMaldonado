/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labp2_hectormaldonado;

/**
 *
 * @author hecto
 */
public class Jugador {
    
  private String nombre;
  private char caracter;
  private int victorias=0;
  private int dinero=200;
  private int cola=60;
  private int acelerador=30;
  private int mina=45;
  private int ilumninador=45;
  private int detector=30;
  private int x;
  private int y;
  
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public char getCaracter() {
	return caracter;
}
public void setCaracter(char caracter) {
	this.caracter = caracter;
}
public int getVictorias() {
	return victorias;
}
public void setVictorias(int victorias) {
	this.victorias = victorias;
}
public int getDinero() {
	return dinero;
}
public void setDinero(int dinero) {
	this.dinero = dinero;
}
public int getCola() {
	return cola;
}
public void setCola(int cola) {
	this.cola = cola;
}
public int getAcelerador() {
	return acelerador;
}
public void setAcelerador(int acelerador) {
	this.acelerador = acelerador;
}
public int getMina() {
	return mina;
}
public void setMina(int mina) {
	this.mina = mina;
}
public int getIlumninador() {
	return ilumninador;
}
public void setIlumninador(int ilumninador) {
	this.ilumninador = ilumninador;
}
public int getDetector() {
	return detector;
}
public void setDetector(int detector) {
	this.detector = detector;
}
public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}
}



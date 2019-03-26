/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

/**
 *
 * @author VSOne
 */
public class Cuenta {
    private double balance;
    private int noCuenta;
       
    public Cuenta(int a){    
		balance = 0.0;
		noCuenta = a;
    }
    
    public void depositar(double suma){
	if (suma>0)
	    balance += suma;    
	else
	    System.err.println("No es posible depositar cantidad negativa.");    
    }
    
    public void retirar(double suma){
	if (suma > 0)
	    balance -= suma;    
	else
	    System.err.println("No es posible retirar cantidad negativa.");    
    }
    
    public double getBalance(){
		return balance;
    }
    
    public double getNoCuenta(){
		return noCuenta;
    }
    
    public String toString(){
		return "No. Cuenta: " + noCuenta + " - " + "Balance = " + balance;    
    }
    
    public final void imprimir(){
		System.out.println( toString() );    
    }
}

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
public class CuentaCorriente extends Cuenta{
    private double Sobregiro;
    private double SobregiroTotal;
    private String TipoCuenta = "Corriente";

    public CuentaCorriente(int NumeroCuenta) {
        super(NumeroCuenta);
    }

    public double getSobregiro(){
       return Sobregiro;
    }
    public void setSobregiro(int Sobregiro){
        this.Sobregiro = Sobregiro;
    }
    public double getSobregiroTotal(){
        return this.SobregiroTotal;
    }
    
    public boolean isSobregiro(){
        if (this.SobregiroTotal-this.Sobregiro != 0) {
            return true;
        }
        return false;
    }
    
    /**
     *
     * @param Retiro
     */
    @Override
    public void retirar(double Retiro){
        if(this.getBalance() == 0){
            RetirarSaldoSobregiro(Retiro);
        }
        else
            super.retirar(Retiro); 
    }
    
    public void RetirarSaldoSobregiro(double RetiroSobregiro){
        if((this.Sobregiro-RetiroSobregiro)>0)
        this.Sobregiro = this.Sobregiro - RetiroSobregiro;
        //ELSE
    }
}

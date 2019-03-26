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
public class Banco {
    private CuentaAhorro [] cuentasAhorro;
    private CuentaCorriente [] cuentasCorriente;
    private int maxCuentasAhorro;    
    private int maxCuentasCorriente;
    public static int countNumCuentaAhorro = 0;
    public static int countNumCuentaCorriente = 0;
    
    public Banco(int maxCuentasAhorro, int maxCuentasCorriente){
        this.maxCuentasAhorro = maxCuentasAhorro;
        this.maxCuentasCorriente = maxCuentasCorriente;

        this.cuentasAhorro = new CuentaAhorro[this.maxCuentasAhorro];
        this.cuentasCorriente = new CuentaCorriente[this.maxCuentasCorriente];
    }
    
    public void crearCuentaAhorro(int NumCuenta){
        if (this.countNumCuentaAhorro < maxCuentasAhorro) {
             cuentasAhorro[countNumCuentaAhorro] = new CuentaAhorro(NumCuenta);
             this.countNumCuentaAhorro ++;
        }
        //ELSE
    }
    public CuentaAhorro [] ListCuentasAhorro(){
        return this.cuentasAhorro;
    }
    
    public void crearCuentaCorriente(int NumCuenta){
        if (this.countNumCuentaCorriente < maxCuentasCorriente) {
             cuentasCorriente[countNumCuentaCorriente] = new CuentaCorriente(NumCuenta);
             this.countNumCuentaCorriente ++;
        }
        //ElSE
    }
    
    public CuentaCorriente [] ListCuentaCorriente()
    {
        return this.cuentasCorriente;
    }
    
    public void DepositarCuenta(int NumCuenta, double SaldoDeposito){

        Cuenta CuentaDeposito = SearchCuenta(NumCuenta);
        CuentaDeposito.depositar(SaldoDeposito);
        
    }
    
    public void RetirarCuenta(int NumCuenta, double SaldoRetirar){
        Cuenta CuentaRetiro = SearchCuenta(NumCuenta);
        CuentaRetiro.retirar(SaldoRetirar); 
        
    }
    
    public Cuenta SearchCuenta(int NumCuenta){
        CuentaAhorro SCuentaA = SearchCuentaAhorro(NumCuenta);
        CuentaCorriente SCuentaC = SearchCuentaCorriente(NumCuenta);
        
        if (SCuentaA != null) {
            return SCuentaA;
        }
        else if(SCuentaC != null){
            return SCuentaC;
        }
        else
        return null;
    }
    
    public CuentaAhorro SearchCuentaAhorro(int NumCuenta){
        for (int i = 0; i < this.maxCuentasAhorro; i++) {
            if(this.cuentasAhorro[i] != null)
                if (this.cuentasAhorro[i].getNoCuenta() == NumCuenta) {
                    return this.cuentasAhorro[i];
                }
        }
        return null;
    }
    
    public CuentaCorriente SearchCuentaCorriente(int NumCuenta){
        for (int i = 0; i < this.maxCuentasCorriente; i++) {
            if(this.cuentasCorriente[i] != null && 
                    this.cuentasCorriente[i].getNoCuenta() == NumCuenta)
            {
                return this.cuentasCorriente[i];
            }
        }
        return null;
    }
    
    public void EliminarCuenta(int NumCuenta){
        Cuenta DropCuenta = ValidationCuenta(NumCuenta);
    }
    
    public Cuenta ValidationCuenta(int NumCuenta){
        Cuenta DropCuenta = SearchCuenta(NumCuenta);
        
        
        return null;
    }
    
    public Cuenta getTipoCuenta(Cuenta DropCuenta){
        
        
        return null;
    }
    
    public boolean isEmptySaldo(Cuenta DropCuenta){
        if(DropCuenta.getBalance() == 0)
            return true;
        return false;
    }
    
    public boolean isEmptySobregiro(CuentaCorriente DropCuenta){
        
        if(DropCuenta.isSobregiro())
            return true;
        return false;
    }
    
}

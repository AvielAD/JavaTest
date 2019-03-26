/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
    
      public static void main(String[] args) throws IOException {
        //Menu para trabajar
        CuentaAhorro [] aux;
        CuentaCorriente [] aux2;
        
        Banco Bancomer = new Banco(5,5);
        
        aux = Bancomer.ListCuentasAhorro();
        aux2 = Bancomer.ListCuentaCorriente();
        int opcion = 0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do{
            int NumCuenta,NumCodigBanco,NumSucursal;
            double deposito = 0,retiro = 0;

            System.out.println("");
            System.out.println("");

            System.out.println("1.- Crear Cuenta Ahorro");            
            System.out.println("2.- Crear Cuenta Corriente");
            System.out.println("3.- Depositar");
            System.out.println("4.- Retirar");
            System.out.println("5.- Consultar Saldo");
            System.out.println("6.- Salir");
            System.out.print("Ingresa Opcion: ");
            opcion = Integer.parseInt(br.readLine());
            
        switch(opcion){
            case 1:
                System.out.print("Ingresar Numero de Cuenta: ");
                NumCuenta = Integer.parseInt(br.readLine());
                
                System.out.print("Ingresar Codigo del banco: ");
                NumCodigBanco = Integer.parseInt(br.readLine());

                System.out.print("Ingresar Codigo de Sucursal: ");
                NumSucursal = Integer.parseInt(br.readLine());
                
                Bancomer.crearCuentaAhorro(NumCuenta); 
                break;
            case 2:
                System.out.print("Ingresar Numero de Cuenta: ");
                NumCuenta = Integer.parseInt(br.readLine());
                
                System.out.print("Ingresar Codigo del banco: ");
                NumCodigBanco = Integer.parseInt(br.readLine());

                System.out.print("Ingresar Codigo de Sucursal: ");
                NumSucursal = Integer.parseInt(br.readLine());
                
                Bancomer.crearCuentaCorriente(NumCuenta); 
                
                break;
            case 3:

                System.out.print("Ingresa Numero de Cuenta para Depositar: ");
                NumCuenta = Integer.parseInt(br.readLine());

                System.out.print("Saldo a Depositar: ");
                deposito = Double.parseDouble(br.readLine());

                Bancomer.DepositarCuenta(NumCuenta, deposito);

                break;
            case 4:

                System.out.print("Ingresa Numero de Cuenta para Retirar: ");
                NumCuenta = Integer.parseInt(br.readLine());

                System.out.print("Saldo a Retirar: ");
                retiro = Double.parseDouble(br.readLine());

                Bancomer.RetirarCuenta(NumCuenta, retiro);
                
                break;
            case 5:
                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");

                for (int i = 0; i < 5; i++) {
                        if (aux[i]!= null) {
                            System.out.println("Cuenta: "+aux[i].getNoCuenta()+" Saldo: "+aux[i].getBalance());
                        }
                        if (aux2[i]!= null) {
                            System.out.println("Cuenta: "+aux2[i].getNoCuenta()+" Saldo: "+aux2[i].getBalance());
                        }
                        
                    }
                    
                break;
            default:
                opcion = -1;
                break;
        }
            
        
        }while(opcion!=-1);
        
        System.out.println("Fin");
        
        
    }
    
    
}

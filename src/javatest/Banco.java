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
        System.out.println("hola mundo");
        Cuenta CuentaRetiro = SearchCuenta(NumCuenta);
        if(CuentaRetiro!=null){
        CuentaRetiro.retirar(SaldoRetirar);}
        else
            System.out.println("no encontre la cuenta");
        
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
        else{
            System.out.println("no encontre nada");
            return null;}
    }
    
    public CuentaAhorro SearchCuentaAhorro(int NumCuenta){
       if (cuentasAhorro!=null){
        for (int i = 0; i < this.maxCuentasAhorro; i++) {
            if(this.cuentasAhorro[i] != null)
                if (this.cuentasAhorro[i].getNoCuenta() == NumCuenta) {
                    return this.cuentasAhorro[i];
                }
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
    public void Actualizar(){
        
        for (int i = 0; i < 5; i++) {
            if (cuentasCorriente[i]!= null) {
                  cuentasCorriente[i].isSobregiro();
                            
                        }
               if (cuentasAhorro[i]!= null) {
                   cuentasAhorro[i].AplicarInteres();
                            
                        }
                }
        
        
    
    
    }
    public static void main(String[] args) throws IOException {
        //Menu para trabajar
        CuentaAhorro [] aux;
        CuentaCorriente [] aux2;
        
        Banco Bancomer = new Banco(5,5);
        
        aux = Bancomer.ListCuentasAhorro();
        aux2 = Bancomer.ListCuentaCorriente();
        int opcion = 0, op=0;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        do{
            int NumCuenta;
            double deposito = 0,retiro = 0;

            System.out.println("");
            System.out.println("");

            System.out.println("1.- Crear Cuenta");            
            System.out.println("2.- Depositar");
            System.out.println("3.- Retirar");
            System.out.println("4.- Consultar Saldo");
            System.out.println("5.- Eliminar cuenta");
            System.out.println("6.- Actualizar");
            System.out.println("7.- Salir");
            System.out.print("Ingresa Opcion: ");
            opcion = Integer.parseInt(br.readLine());
            
        switch(opcion){
            
            case 1:
                
                System.out.println("1.-Crear Cuenta Ahorro");
                System.out.println("2.-Crear Cuenta Corriente");
                System.out.print("Ingresa Opcion: ");
                op= Integer.parseInt(br.readLine());
                
                switch (op){
                    case 1:
                        System.out.print("Ingrese numero de cuenta: ");
                        NumCuenta= Integer.parseInt(br.readLine());
                        Bancomer.crearCuentaAhorro(NumCuenta);
                        
                        break;
                    case 2:
                        System.out.println("Ingrese numero de cuenta");
                        NumCuenta= Integer.parseInt(br.readLine());
                        Bancomer.crearCuentaCorriente(NumCuenta);
                 
                        break;
                    default: 
                        break;
                }
                 break;
                 
            case 2:
                System.out.print("Ingresa Numero de Cuenta para Depositar: ");
                NumCuenta = Integer.parseInt(br.readLine());

                System.out.print("Saldo a Depositar: ");
                deposito = Double.parseDouble(br.readLine());

                Bancomer.DepositarCuenta(NumCuenta, deposito);
               
                
               
                
                
                
                break;
            case 3:

                System.out.print("Ingresa Numero de Cuenta para Retirar: ");
                NumCuenta = Integer.parseInt(br.readLine());

                System.out.print("Saldo a Retirar: ");
                retiro = Double.parseDouble(br.readLine());

                Bancomer.RetirarCuenta(NumCuenta, retiro);

                break;
            case 4:

                System.out.println("");
                System.out.println("");
                System.out.println("");
                System.out.println("");

                for (int i = 0; i < 5; i++) {
                        if (aux[i]!= null) {
                            System.out.println("Cuenta: "+aux[i].getNoCuenta()+" Saldo: "+aux[i].getBalance()+" Tipo: "+aux[i].getClass().getSimpleName());
                        }
                        if (aux2[i]!= null) {
                            System.out.println("Cuenta: "+aux2[i].getNoCuenta()+" Saldo: "+aux2[i].getBalance()+" Tipo: "+aux2[i].getClass().getSimpleName());
                        }
                }
                        
                
                break;
                
            case 5:
                
                    
                    
                break;
                
            case 6:
                
                System.out.println("Actualizar estado de cuentas");
                
                
                break;
            
            default:
                opcion = -1;
                break;
        }
            
        
        }while(opcion!=-1);
        
        System.out.println("Fin");
        
        
    }
    
    
}

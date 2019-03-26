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
public class JavaTest {

    /**
     * @param args the command line arguments
     */
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

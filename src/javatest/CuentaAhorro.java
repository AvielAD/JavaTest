package javatest;


public class CuentaAhorro extends Cuenta {
    
   private double interes=0.10;
   
    
    public CuentaAhorro(int NumeroCuenta) {
        super(NumeroCuenta);
        
    }
    public void AplicarInteres(){
        double InteresAux=this.getBalance()*interes;
        super.depositar(InteresAux);
        }
}
package javatest;


public class CuentaCorriente extends Cuenta{
    private double Sobregiro=1000;
    private boolean SobregiroTrue;
    

    public CuentaCorriente(int NumeroCuenta) {
        
        super(NumeroCuenta);
        
    }
    
    public void isSobregiro(){
        if (Sobregiro== 0) {
            SobregiroTrue=true;
        }
        else
        SobregiroTrue=false;
    }
    
    
    @Override
    public void retirar(double Retiro){
        double SaldoRetirar=this.getBalance()-Retiro;
        if (Retiro>0 && Retiro<this.getBalance()){
            this.retirar(Retiro);
        }
        else if(SaldoRetirar<0){
            this.retirar(Retiro+SaldoRetirar);
            Sobregiro=Sobregiro+SaldoRetirar;
        } 
    }
}

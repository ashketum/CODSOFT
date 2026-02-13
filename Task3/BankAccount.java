import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
   private BigDecimal balance;

   
  public BankAccount(double amt) {
    this.balance = new BigDecimal(Double.toString(amt)).setScale(2, RoundingMode.HALF_EVEN);
}



  public void deposit(double amt){
       if(amt <= 0) throw new IllegalArgumentException();

  BigDecimal deposit = new BigDecimal(Double.toString(amt)).setScale(2, RoundingMode.HALF_EVEN);
  balance = balance.add(deposit);
}

  public boolean withdraw(double amt){

    if(amt <= 0) throw new IllegalArgumentException();
    
    BigDecimal withdrawnAmt = new BigDecimal(Double.toString(amt)).setScale(2, RoundingMode.HALF_EVEN);

  if (balance.compareTo(withdrawnAmt) == -1){
        
         return false;
} else{
   balance = balance.subtract(withdrawnAmt);
      return true;
}
}

public double checkBalance(){
    return balance.doubleValue();
}

}
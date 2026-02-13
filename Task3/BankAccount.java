import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount {
   private BigDecimal balance;

   
  public BankAccount(double amt) {
    this.balance = new BigDecimal(Double.toString(amt)).setScale(2, RoundingMode.HALF_EVEN);
}



  public boolean depositAmount(double amt){
       if(amt <= 0) throw new Error("Amount is Invalid");

  BigDecimal deposit = new BigDecimal(Double.toString(amt)).setScale(2, RoundingMode.HALF_EVEN);
  balance = balance.add(deposit);
    System.out.println("INR " + amt + " is Deposited.");
  return true;
}

  public boolean withdrawAmount(double amt){

    if(amt <= 0) throw new Error("Amount is Invalid");
    
    BigDecimal withdrawnAmt = new BigDecimal(Double.toString(amt)).setScale(2, RoundingMode.HALF_EVEN);

  if (balance.compareTo(withdrawnAmt) == -1){
         System.out.println("Insufficient Bank Balance");  
         return false;
} else{
   balance = balance.subtract(withdrawnAmt);
    System.out.println("INR " + amt + " is withdrawn.");
  return true;
}
}

public double checkBalance(){
    return balance.doubleValue();
}

}
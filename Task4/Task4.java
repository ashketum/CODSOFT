package Task4;
import java.io.IOException;
import java.util.Scanner;

public class Task4 {
   

    public static void main(String[] args) throws IOException {

        GetResult r1 = new GetResult();


        System.out.println(r1.getCountryCode());

     Scanner sc = new Scanner(System.in);

     System.out.print("Enter Country Code of Base Country : ");
       String from = sc.nextLine().toUpperCase().trim();
       
     System.out.print("Enter Country Code of Target Country : ");
        String to = sc.nextLine().toUpperCase().trim();
       

     System.out.print("Enter The Amount : ");
        double amt = sc.nextInt();

        Double result = r1.getResult(from, to, amt);

        if(result != -1){
            
        System.out.println(amt + " " + from + " in " + to + " is : "+ result);
        
        } else{
            System.out.println("Wrong Input");
        }

    }
}
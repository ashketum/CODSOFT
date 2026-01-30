import java.util.Random;
import java.util.Scanner;

public class Task1{
    private static final int maxRounds = 5;
    private static final int maxTurn = 5;
    private static  int roundsTaken = 0;
     
public static boolean anotherRound(Scanner sc){
    System.out.println("Wants to play another Round you have (" + (maxRounds - roundsTaken) + ") rounds left");
    System.out.println("1. For  YES \n 2. For NO");
    System.out.print("Enter your choice(1 or 2): ");
    int userChoice = sc.nextInt();
    return (userChoice == 1);
}
    public static void main(String[] args) {
        
    boolean isRunning = true;
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    int tot_score = 0;

    while(isRunning && roundsTaken < maxRounds){
        int target = rand.nextInt(100) + 1;
        int tot_turn = 0;
        int score = 0;
        
        while(tot_turn < maxTurn){

        System.out.print((roundsTaken+1) + "." + (tot_turn+1) +". Guess the number(1,100):  ");

        int guessNum = sc.nextInt();

            if(guessNum == target){
              score += 5 - tot_turn;
              tot_score += score;
              System.out.println("Congratulations You guessed right number (" + target + ")");
              break;
            } else if(guessNum > target){
                tot_turn++;
            System.out.println("Too High");
            } else{
                 tot_turn++;
            System.out.println("Too Low");
            }
        }
        roundsTaken++;
        System.out.println("Round " + roundsTaken + " Ended");
        System.out.println(("Round " + roundsTaken + " score is: " + score + "/5"));
         isRunning = (roundsTaken < maxRounds && anotherRound(sc));
    }

  if(roundsTaken == maxRounds){
    System.out.println("You Attempted All " + maxRounds + " rounds, Game Ended");
  }else{
    System.out.println("Exited from Game");
  }
  Double win_percent = (( (double)(tot_score)/(5*roundsTaken))* 100);
  System.out.println("Winning Percentage is : " + win_percent);
    }
}
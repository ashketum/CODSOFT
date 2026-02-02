import java.util.Scanner;

public class Task2{    // Student Grade Calculator
    public static void main(String[] args){
 
    String[] subjects = {"Physics", "Chemistry", "Mathematics", "Biology", "Social Sciences"};

    System.out.println("List of Subjects");

    int n = subjects.length;

    for(int i=0;i<n;i++) 
        System.out.println((i+1) + ". " + subjects[i]);

    int tot_marks = 0;

    Scanner sc = new Scanner(System.in);

    for(int i=0;i<n;i++){
        System.out.print("Enter marks Out of 100 in " + subjects[i] + ": ");
        int marks = sc.nextInt();
        tot_marks += marks;
    }
    sc.close();

    double percentage = (double) tot_marks/n;
     char grade = ' ';

    if(percentage >= 80) grade = 'O';
    else if(percentage >= 75 && percentage < 80) grade = 'A';
    else if(percentage >= 70 && percentage < 75) grade = 'B';
    else if(percentage >= 60 && percentage < 70) grade = 'C';
    else if(percentage >= 50 && percentage < 60) grade = 'D';
    else if(percentage >= 45 && percentage < 50) grade = 'E';
    else if(percentage >= 40 && percentage < 45) grade = 'P';
    else grade = 'F';

    System.out.println("Total Marks is: " + tot_marks + "/" + (n*100));
    System.out.println("Average Percentage is: " + percentage + "%");
    System.out.println("Corresponding grade is: " + grade);


    }
}
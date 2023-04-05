import java.util.*;
public class Numbergame {
    static ArrayList<Integer> score = new ArrayList<Integer>();
    public void menu(ArrayList<Integer> scoreBoard) 
    {
        Numbergame methodChange = new Numbergame();
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================================================");
        System.out.println("What action would you like to do ?\n");       
        System.out.println("1) Play ");
        System.out.println("2) Score Board");
        System.out.println("3) Exit");
        System.out.println(" =========================================================================");
            System.out.print("Write Here...");
            int x= sc.nextInt();
            switch (x) {
                case 1:
                    System.out.print("\n"+"Enter Range ");
                    int Range = sc.nextInt();
                    Random random = new Random();
                    int R_Num = random.nextInt(Range) + 1;
                    methodChange.guessNumber(R_Num);
                    break;
                case 2:
                    methodChange.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(0);
                    break;
                default: methodChange.menu(score);
            }
                    
    }
    public void guessNumber(int R_Num) {
        Scanner input = new Scanner(System.in);
        int userGuess;
        int guess = 0;
        do {
            System.out.print("Enter your guessed number: ");
            userGuess = input.nextInt();
            guess++;
            if (userGuess > R_Num)
                System.out.println("Actual number is Lower than "+ userGuess);
            else if (userGuess < R_Num)
                System.out.println("Actual number is Higher than "+ userGuess);
        } while (R_Num != userGuess);
        if (guess == 1) 
            System.out.println("You answered number is right in " + guess + " try!");
        else 
            System.out.println("You answered number is right in " + guess + " tries!");
        score.add(guess);
        menu(score);
    }
    public void displayScoreBoard() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Score Board");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Your fastest games today out of all is: " +"\n");
        Collections.sort(score);
        for (Integer scores : score) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(score);
    }
    public static void main(String[] args) {
        System.out.println("Welcome In Number Guessing Game :) ");
        Numbergame methodChange = new Numbergame();
        methodChange.menu(score);
    }
}

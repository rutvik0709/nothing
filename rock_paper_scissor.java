import java.util.*;

public class rock_paper_scissor {
    public static void main(String[] args){
        int userscore=0;
        int computerscore=0;
        while (true) {
            System.out.println("Choose your choice: Rock, Paper, Scissors");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            choice = choice.toUpperCase();
            Random rand = new Random();
            String[] array1 = new String[] { "STONE", "PAPER", "SCISSORS" };
            String computer = array1[rand.nextInt(array1.length)];
            if ((choice == "ROCK") && (computer == "SCISSORS")) {
                userscore += 1;
            } else if ((choice == "PAPER") && (computer == "ROCK")) {
                userscore += 1;
            } else if ((choice == "SCISSORS") && (computer == "PAPER")) {
                userscore += 1;
            } else if (choice == computer) {
                continue;
            }else if ((choice == "Q")){
                break;
            }else {
                computerscore+=1;
            }
        
            if(userscore == 5){
                System.out.println("YOU WON");
                break;
            }if(computerscore == 5){
                System.out.println("COMPUTER WON");
                break;
            }
        }

    }
}

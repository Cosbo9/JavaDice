import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
    
        intro();
        diceAmount();
        confirm();
        System.out.println("post");
    }


    public static void intro() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");

        }
        System.out.println("\n\n\t\t\tWelcome to the Java Dice Sim!\n");
        for (int i = 0; i < 80; i++) {
            System.out.print("-");

        }
        System.out.println(" \n\nIn this sim you have the option of rolling a 6 sided die or a 20 sided die. \n\nBut first how many die would you like to roll?");
    }

    public static void diceAmount() {
        Scanner dieAmount = new Scanner(System.in);
        int amount = dieAmount.nextInt();
    
        System.out.println("You have chosen to roll " + amount + " dice");
        
    }

    public static void confirm() {
        Scanner confirm = new Scanner(System.in);

        System.out.println("Is this correct? 'y'/'n'");
        String conf = confirm.nextLine();

        switch (conf) {
            case "y":
                System.out.println("You have confirmed");
                break;
            case "Y":
                System.out.println("You have confirmed");
                break;
            case "n":
                System.out.println("You have denied \n\nGoodbye!");
            case "N":
                System.out.println("You have denied \n\nGoodbye!");
            default:
                System.out.println("invalid input");
                confirm(); 
                break;
        }
    }
}
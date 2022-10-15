import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Intro start = new Intro();
        DieHandler handler = new DieHandler();
        Confirmer conf = new Confirmer();

        start.intro();
        handler.diceAmount();
        conf.confirm();
        handler.diceType();
        conf.confirm();
        System.out.println("post");
    }


    
}

class Intro {

    public void intro() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");

        }
        System.out.println("\n\n\t\t\tWelcome to the Java Dice Sim!\n");
        for (int i = 0; i < 80; i++) {
            System.out.print("-");

        }
        System.out.println(" \n\nIn this sim you have the option of rolling a 6 sided die or a 20 sided die. \n\nBut first how many die would you like to roll?");
    }
}

class Confirmer extends Main {
    public void confirm() {
        Scanner confirm = new Scanner(System.in);

        System.out.println("Is this correct? 'y'/'n'");
        String conf = confirm.nextLine();

        switch (conf.toLowerCase()) {
            case "y":
                System.out.println("You have confirmed");
                break;
            case "n":
                System.out.println("You have denied \n\nGoodbye!");
                redo();
            default:
                System.out.println("invalid input");
                confirm(); 
                break;
        }
    }

    public void redo() {
        Main app = new Main();
        Scanner confirm = new Scanner(System.in);
        System.out.println("Would you like to restart program?\n'y'/'n'");
        String conf = confirm.nextLine();

        switch (conf.toLowerCase()) {
            case "y":
                System.out.println("You have confirmed");
                app.main(null);
                break;
            case "n":
                System.out.println("You have denied \n\nGoodbye!");
                System.exit(0);
            default:
                System.out.println("invalid input");
                redo(); 
                break;
        }
    }
}

class DieHandler {
    int dieAmount;
    String dieType;

    public void diceAmount() {
        Scanner dieAmount = new Scanner(System.in);
        int amount = dieAmount.nextInt();
    
        System.out.println("You have chosen to roll " + amount + " dice");
        
    }

    public void diceType() {
        System.out.println("Please type in which die you would like to roll: (select only 1 type)\n'd6'\n'd20'");
        Scanner dieType = new Scanner(System.in);
        String type = dieType.nextLine();

        switch (type.toLowerCase()) {
            case "d6":
                System.out.println("You have selected 'd6'");
                break;
            case "d20":
                System.out.println("You have selected 'd20'");
                break;
            default:
                System.out.println("Invalid selection");
                diceType();
                break;
        }
    }
}
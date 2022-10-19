import java.util.Scanner;

public class Main {
    int amount;
    String type;
    DieHandler handler = new DieHandler();
    
    public Main(){
    }
    public static void diceAmount() {
        // need to capture this input to send to the calculator component
        // Scanner dieAmount = new Scanner(System.in);
        // int amount = dieAmount.nextInt();
    
        // System.out.println("You have chosen to roll " + amount + " dice");
        
    }

    public static void diceType() {
        // need to capture this input to send to the calculator component
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

    
    public static void main(String[] args) {
        Intro start = new Intro();
        DieHandler handler = new DieHandler();
        Confirmer conf = new Confirmer();
        // Main setterObj = new Main();
        // String type = setterObj.type;
        // int amount = setterObj.amount;

        

        start.intro();
        
        Scanner dieAmount = new Scanner(System.in);
        int amount = dieAmount.nextInt();
    
        System.out.println("You have chosen to roll " + amount + " dice");
        // diceAmount();
        conf.confirm();
        System.out.println("Please type in which die you would like to roll: (select only 1 type)\n'd4'\n'd6'\n'd10'\n'd12'\n'd20'");
        Scanner dieType = new Scanner(System.in);
        String type = dieType.nextLine();

        switch (type.toLowerCase()) {
            case "d4":
                System.out.println("You have selected 'd4'");
                break;
            case "d6":
                System.out.println("You have selected 'd6'");
                break;
            case "d10":
                System.out.println("You have selected 'd10'");
                break;
            case "d12":
                System.out.println("You have selected 'd12'");
                break;
            case "d20":
                System.out.println("You have selected 'd20'");
                break;
            default:
                System.out.println("Invalid selection");
                diceType();
                break;
        }
        // diceType();
        conf.confirm();
        System.out.println("in main " + amount + " " + type);
        handler.calculator(amount, type);
        conf.redo();
    }

    


    
}

class Intro {
    // I think it makes UI prettier
    public void intro() {
        for (int i = 0; i < 80; i++) {
            System.out.print("-");

        }
        System.out.println("\n\n\t\t\tWelcome to the Java Dice Sim!\n");
        for (int i = 0; i < 80; i++) {
            System.out.print("-");

        }
        System.out.println(" \n\nIn this sim you have the option of rolling a die of your choice. \n\nBut first how many die would you like to roll?");
    }
}

// class that handles UI stuff
class Confirmer {
    // confirmation component
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

// class thats going to handle all die options
class DieHandler {
    int dieAmount;
    String dieType;
    // calculates die rolls
    public void calculator(Integer diceAmount, String dieType) {
        System.out.println("You have chosen to roll " + diceAmount + " " + dieType);
        int dieValue = 0;

        switch (dieType) {
            case "d4":
                dieValue = 4;
                break;
            case "d6":
                dieValue = 6;
                break;
            case "d10":
                dieValue = 10;
                break;
            case "d12":
                dieValue = 12;
                break;
            case "d20":
                dieValue = 20;
                break;
            default:
                break;
        }
        // loop that iterates however many times that user chooses
        for (int i = 0; i < diceAmount; i++) {
            // creates and prints random number between 1 and value of chosen die
            int random = (int) (dieValue * Math.random() + 1);
            System.out.println("You rolled: " + random);
        } 
    }
}
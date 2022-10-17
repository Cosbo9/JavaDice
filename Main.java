import java.util.Scanner;

public class Main {
    int amount;
    String type;
    DieHandler handler = new DieHandler();
    
    public Main(){
        // trying to inizalize the options chosen by user
        handler.setDieAmount(amount);
        handler.setDieType(type); 
    }
    public static void main(String[] args) {
        Intro start = new Intro();
        DieHandler handler = new DieHandler();
        Confirmer conf = new Confirmer();
        Main setterObj = new Main();
        String type = setterObj.type;
        int amount = setterObj.amount;

        start.intro();
        handler.diceAmount();
        // experiment trying to see if I can get the variable through this method
        handler.setDieAmount(amount);
        conf.confirm();
        handler.diceType();
        // experiment trying to see if I can get the variable through this method
        handler.setDieType(type); 
        conf.confirm();
        System.out.println("in main " + type + amount);
        handler.calculator(amount, type);
        System.out.println("post");
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
        System.out.println(" \n\nIn this sim you have the option of rolling a 6 sided die or a 20 sided die. \n\nBut first how many die would you like to roll?");
    }
}

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

class DieHandler {
    int dieAmount;
    String dieType;

    public void diceAmount() {
        // need to capture this input to send to the calculator component
        Scanner dieAmount = new Scanner(System.in);
        int amount = dieAmount.nextInt();
    
        System.out.println("You have chosen to roll " + amount + " dice");
        
    }

    public void diceType() {
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

    // calculates die rolls, still needs to actually put in the Random functions.
    // still trying to pass in variable info
    public int calculator(int diceAmount, String dieType) {
        int dieValue = 0;

        System.out.println("You have chosen to roll " + dieAmount + " " + dieType);

        switch (dieType) {
            case "d6":
                dieValue = 6;
                break;
            case "d20":
                dieValue = 20;
                break;
            default:
                break;
        }
        int total = dieAmount * dieValue;
        return total;
    }


    // getters and setters in the attempt to inizalize the options user selected
    public int getDieAmount() {
        return dieAmount;
    }
    public int setDieAmount(int amount) {
        return this.dieAmount = amount;
    }
    public String getDieType() {
        return dieType;
    }
    public String setDieType(String type) {
        return this.dieType = type;
    }
}
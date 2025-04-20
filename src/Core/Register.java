package Core;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Register {
    private final List<Denomination> denominations = Arrays.asList(
            //Import file names at the end of each denomination
            new Denomination ("Hundred Dollar Bill", 100.00, "bill", "images/100dollar.png"),
            new Denomination ("Fifty Dollar Bill", 50.00, "bill", "images/50dollar.png"),
            new Denomination ("Twenty Dollar Bill", 20.00, "bill", "images/20dollar.png"),
            new Denomination ("Ten Dollar Bill", 10.00, "bill", "images/10dollar.png"),
            new Denomination ("Five Dollar Bill", 5.00, "bill", "images/5dollar.png"),
            new Denomination ("One Dollar Bill", 1.00, "bill", "images/1dollar.png"),
            new Denomination("Quarter",0.25, "coin", "images/quarter.png"),
            new Denomination("Dime",0.10, "coin", "images/dime.png"),
            new Denomination("Nickel",0.05, "coin", "images/nickel.png"),
            new Denomination("Penny",0.01, "coin", "images/penny.png")
    );

    private ChangeCalculation strategy;

    public Register() {
        this.strategy = new GreedyChange();
    }

    public Register(ChangeCalculation strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ChangeCalculation strategy) {
        this.strategy = strategy;
    }

    public Purse makeChange(double amt) {
        return strategy.makeChange(amt, denominations);
    }
    public static void main(String[] args) {
        Register register = new Register();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount: ");
        String amount = scanner.nextLine();
        double amt = Double.parseDouble(amount);
        Purse purse = register.makeChange(amt);
        System.out.println("Change for $" + amt + ":\n" + purse);
    }
}

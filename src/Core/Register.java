package Core;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

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
    private final List<RegisterObserver> observers = new ArrayList<>();

    public Register() {
        this.strategy = new GreedyChange();
    }

    public Register(ChangeCalculation strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(ChangeCalculation strategy) {
        this.strategy = strategy;
    }

    public void addObserver(RegisterObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(RegisterObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers(Purse purse) {
        for (RegisterObserver observer : observers) {
            observer.update(purse);
        }
    }

    public Purse makeChange(double amt) {
        Purse purse = strategy.makeChange(amt, denominations);
        notifyObservers(purse);
        return purse;
    }
}

package Core;

import java.util.List;

public class GreedyChange implements ChangeCalculation {
    @Override
    public Purse makeChange(double amt, List<Denomination> denominations) {
        Purse purse = new Purse();
        int remaining = (int) Math.round(amt * 100);

        for (Denomination denomination : denominations) {
            int valueInPennies = (int) Math.round(denomination.amt() * 100);
            if (remaining >= valueInPennies) {
                int count = remaining / valueInPennies;
                purse.add(denomination, count);
                remaining -= count * valueInPennies;
            }
        }
        if (remaining > 0) {
            purse.add(denominations.get(denominations.size()-1), 1);
        }
        return purse;
    }
}
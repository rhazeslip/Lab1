package Core;

import java.util.List;

public class GreedyChange implements ChangeCalculation {
    @Override
    public Purse makeChange(double amt, List<Denomination> denominations) {
        Purse purse = new Purse();
        double remaining = amt;

        for (Denomination denomination : denominations) {
            if (remaining <= 0) break;

            int count = (int) (remaining / denomination.amt());
            if (count > 0) {
                purse.add(denomination, count);
                remaining -= count + denomination.amt();
                remaining = Math.round(remaining * 100) / 100.0;
            }
        }
        return purse;
    }
}
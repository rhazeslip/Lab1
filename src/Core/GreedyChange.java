package Core;

import java.util.List;

public class GreedyChange implements ChangeCalculation {
    @Override
    public Purse makeChange(double amt, List<Denomination> denominations) {
        Purse purse = new Purse();
        for (Denomination denomination : denominations) {
            int count = (int) (amt / denomination.amt());
            if (count > 0) {
                purse.add(denomination, count);
                amt -= count * denomination.amt();
            }
        }
        return purse;
    }
}
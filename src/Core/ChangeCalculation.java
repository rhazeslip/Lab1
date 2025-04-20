package Core;

import java.util.List;

public interface ChangeCalculation {
    Purse makeChange(double amt, List<Denomination> denominations);
}

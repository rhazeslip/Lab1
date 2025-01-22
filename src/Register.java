public class Register {
    private static final Denomination[] denominations = {
            //Import file names at the end of each denomination
            new Denomination ("Hundred Dollar Bill", 100.00, "bill", ""),
            new Denomination ("Fifty Dollar Bill", 50.00, "bill", ""),
            new Denomination ("Twenty Dollar Bill", 20.00, "bill", ""),
            new Denomination ("Ten Dollar Bill", 10.00, "bill", ""),
            new Denomination ("Five Dollar Bill", 5.00, "bill", ""),
            new Denomination ("One Dollar Bill", 1.00, "bill", ""),
            new Denomination("Quarter",0.25, "coin", ""),
            new Denomination("Dime",0.10, "coin", ""),
            new Denomination("Nickel",0.05, "coin", ""),
            new Denomination("Penny",0.01, "coin", "")
    };

    public Purse makeChange(double amt){
        Purse purse = new Purse ();
        for (Denomination denomination : denominations) {
            int count = (int) (amt / denomination.amt());
            if (count > 0) {
                purse.add(denomination, count);
                amt -= count * denomination.amt();
            }
        }
        return purse;
    }
    public static void main(String[] args) {
        Register register = new Register();
        double amt = 137.41;
        Purse purse = register.makeChange(amt);
        System.out.println("Change for $" + amt + ":\n" + purse);
    }
}

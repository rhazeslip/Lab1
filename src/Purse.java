import java.util.Map;
import java.util.HashMap;

public class Purse {
    private Map<Denomination, Integer> cash = new HashMap<>();

    public void add (Denomination type , int num){
        cash.put(type, cash.getOrDefault(type, 0) + num);

    }

    public double remove (Denomination type , int num){
        if (!cash.containsKey(type)) return 0;
        int current = cash.get(type);
        int toRemove = Math.min(num, current);
        cash.put(type, current-toRemove);
        return toRemove * type.amt();
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getKey().name()).append(": ").append(entry.getValue()).append("\n");
        }


        return sb.toString();
    }
}

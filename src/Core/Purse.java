package Core;

import java.util.Map;
import java.util.HashMap;

public class Purse {
    private Map<Denomination, Integer> cash = new HashMap<>();

    public void add (Denomination type , int num){
        cash.put(type, cash.getOrDefault(type, 0) + num);

    }

    public double remove (Denomination type , int num){
        if (cash.containsKey(type)) {
            int current = cash.get(type);
            if (current >= num) {
                cash.put(type, current - num);
                return num * type.amt();
            }
        }
        return 0.0;
    }

    public double getValue(){
        return cash.entrySet().stream().mapToDouble(entry -> entry.getKey().amt()
        * entry.getValue()).sum();
    }

    public Map<Denomination, Integer> getCash(){
        return cash;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
            sb.append(entry.getKey().name()).append(": ").append(entry.getValue()).append("\n");
        }


        return sb.toString();
    }
}

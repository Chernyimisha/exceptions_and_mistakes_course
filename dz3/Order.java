package exceptions_and_mistakes.dz3;


import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Integer, Integer> order = new HashMap<>();
    private int value;

    public int getSizeOrder(){
        return order.size();
    }

    public void clearOrder(){
        order.clear();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    public Order addOrder(int productId, int productQuantity) {
        order.put(productId, productQuantity);
        return this;
    }

    public Map<Integer, Integer> getOrder() {
        return order;
    }

    public int getQuantity(int id){
        return order.get(id);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Ваш заказ составил:\n");
        for (int key: order.keySet()) {
            result.append("id товара: "+key+", количество: "+order.get(key)+"\n");
        }
        result.append("На общую сумму: "+getValue() + " руб.");
        return result.toString();
    }

}

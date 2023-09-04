package exceptions_and_mistakes.dz3;

public class ShopManager {

    public static int purchaseProduct(Order order) {
        int totalPrice = 0;
        double price;

        for (int id: order.getOrder().keySet()) {
            price = ProductDatabase.getProduct(id).getPrice();
            totalPrice += order.getQuantity(id) * price;
        }
        return totalPrice;
    }


}

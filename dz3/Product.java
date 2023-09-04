package exceptions_and_mistakes.dz3;

public class Product {

    private int productId;
    private String name;
    private int availableQuantity;
    private int price;

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public Product(int productId, String name, int availableQuantity, int price) {
        this.productId = productId;
        this.name = name;
        this.availableQuantity = availableQuantity;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }


    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Артикул: %d, %s, доступно: %d шт., %d руб./шт.", productId,name, availableQuantity, price);
    }


}

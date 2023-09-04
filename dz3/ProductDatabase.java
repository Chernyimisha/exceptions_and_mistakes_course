package exceptions_and_mistakes.dz3;

import exceptions_and_mistakes.dz3.exceptions.DataEntryException;
import exceptions_and_mistakes.dz3.exceptions.ProductIdException;

import java.util.ArrayList;

public class ProductDatabase {
    //класс, реализующий возможность сохранения в базе данных информации о доступном товаре
    //и имеющий методы добавления товара в базу, поиска данных о товаре по артикулу и метод toString
    private static final ArrayList<Product> productArrayList = new ArrayList<>();

    public ProductDatabase addProduct(Product product) throws DataEntryException {
        for (Product prod : productArrayList) {
            if (prod.getProductId() == product.getProductId()) {
                throw new DataEntryException("Введен неуникальный productId");
            }
        }
        productArrayList.add(product);
        return this;
    }

    public static Product getProduct(int productId) {
        Product result = null;
        for (Product product : productArrayList) {
            if (product.getProductId() == productId) {
                result = product;
            }
        }
        return result;
    }

    public static Boolean containsProduct(int productId){
        for (Product product : productArrayList) {
            if (product.getProductId() == productId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Product item : productArrayList) {
            result.append(item);
            result.append("\n");
        }
        return result.toString();
    }
}
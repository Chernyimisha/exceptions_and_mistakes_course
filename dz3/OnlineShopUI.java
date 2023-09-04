package exceptions_and_mistakes.dz3;

import exceptions_and_mistakes.dz3.exceptions.AvailableQuantityException;
import exceptions_and_mistakes.dz3.exceptions.CommandEntryException;
import exceptions_and_mistakes.dz3.exceptions.ProductIdException;

import java.util.*;
public class OnlineShopUI {
    public static void main(String[] args) {

        ProductDatabase productDatabase = new ProductDatabase();
        Order order = new Order();
        productDatabase.addProduct(new Product(1, "Apple X", 15, 45000));
        productDatabase.addProduct(new Product(2, "Apple 11", 10, 60000));
        productDatabase.addProduct(new Product(3, "Apple 14Pro", 20, 120000));
        productDatabase.addProduct(new Product(4, "Samsung A9", 5, 40000));
        productDatabase.addProduct(new Product(5, "Samsung A13", 25, 100000));
        productDatabase.addProduct(new Product(6, "Nokia 8800", 20, 10000));


        System.out.println("----Добро пожаловать в наш магазин!----\n"+
                "Для ознакомления с ассортиментом введите - DATA\n"+
                "Для выбора товара в корзину введите - SELECT\n" +
                "Для оформления покупки введите - BUY\n" +
                "Для выхода из магазина введите - EXIT\n");

        Commands com;

        while (true) {
            String commands = prompt("Введите команду: ");
            try {
                com = Commands.findCommand(commands);

                if (com == Commands.EXIT) return;
                switch (com) {
                    case DATA:
                        dataAccess(productDatabase);
                        break;
                    case SELECT:
                        selectionProduct(order);
                        break;
                    case BUY:
                        if (order.getSizeOrder() != 0) buyProduct(order, productDatabase);
                        else System.out.println("Ваша корзина пуста, выберите товар\n");
                        break;
                }
            } catch (AvailableQuantityException e){
                System.out.println(e.getMessage());
                order.clearOrder();
            } catch (CommandEntryException e) {
                System.out.println(e.getMessage());
            } catch (ProductIdException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void buyProduct(Order order, ProductDatabase productDatabase) throws AvailableQuantityException{
        //метод обработки покупки товара, помещенного в заказ (order), включающий обработку сформированного заказа
        //в базе данных (уменьшаем количество доступного товара) и блок вызова ошибки AvailableQuantityException
        //в случае недостаточного остатка товара.
        int oldAvailableQuantity;
        int newAvailableQuantity;
        for (int id: order.getOrder().keySet()) {
            oldAvailableQuantity = productDatabase.getProduct(id).getAvailableQuantity();
            if(oldAvailableQuantity >= order.getQuantity(id)){
                newAvailableQuantity = oldAvailableQuantity - order.getQuantity(id);
                productDatabase.getProduct(id).setAvailableQuantity(newAvailableQuantity);
            } else {
                throw new AvailableQuantityException("Недостаточно товара с артикулом: "+id+". Доступно к заказу "+
                        oldAvailableQuantity+" шт."+" Сформируйте новый заказ.");
            }
        }
        System.out.printf("Поздравляем! Ваш заказ на сумму %d руб. оплачен.\n", ShopManager.purchaseProduct(order));
        order.clearOrder();
    }

    private static void selectionProduct(Order order) throws ProductIdException{
        Scanner in = new Scanner(System.in);
        int productId;
        int quantity;
        String continueInput;
        Commands com;
        while (true) {
            System.out.print("Введите артикул товара: ");
            productId = in.nextInt();
            if(!ProductDatabase.containsProduct(productId)){ //таким образом обработал случай ввода несуществующего артикула
                System.out.println("Товара с таким артикулом нет. Выберите другой.\n");
                continue;
            }
            System.out.print("Введите количество товара: ");
            quantity = in.nextInt();
            if (order.getOrder().containsKey(productId)) {
                quantity += order.getOrder().get(productId);
            }
            order.addOrder(productId, quantity);
            order.setValue(ShopManager.purchaseProduct(order));
            continueInput = prompt("Продолжить выбор? Введите yes/no: ");
            com = Commands.valueOf(continueInput.toUpperCase());
            if (com == Commands.NO) break;
        }
        System.out.println(order);
    }

    private static void dataAccess(ProductDatabase productDatabase) {
        System.out.println("----В магазине представлены:----");
        System.out.println(productDatabase);
    }

    private static String prompt(String message){
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }



}
package ru.job4j.pojo;

public class Shop {
    public Product[] delete(Product[] products) {
        for (int index = 0; index < products.length - 1; index++) {
            products[index] = products[index + 1];
        }
        products[products.length - 1] = null;
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        System.out.println("Удаляем значение из ячейки с индексом 1");
        products[1] = null;

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
        System.out.println();
        System.out.println("Проверяем работу метода delete. Смещение всего массива влево и назначение крайнему правому"
                + "элементу массива значения null.");

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            Shop move = new Shop();
            move.delete(products);

            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }

            System.out.println();
            System.out.println("Записываем в ячейку с индексом 1 значение с индексом 2. "
                    + "И удаляем значение из ячейки с индексом 2.");
            products[1] = products[2];
            products[2] = null;

            for (int i = 0; i < products.length; i++) {
                Product product = products[i];
                if (product != null) {
                    System.out.println(product.getName());
                } else {
                    System.out.println("null");
                }
            }
        }
    }


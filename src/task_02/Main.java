package task_02;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    static double targetPrice = 2.00;

    public static void main(String[] args) {

        System.out.println("Initial list of products:");
        formAnswer(productMap());

        System.out.println("\nSelected products with price <= " + targetPrice + ":");
        formAnswer(filterProducts(productMap()));
    }

    private static Map<String, Double> productMap() {
        Map<String, Double> products = new HashMap<>();
        products.put("Apple", 2.15);
        products.put("Orange", 1.50);
        products.put("Banana", 1.75);
        products.put("Grape", 2.80);
        products.put("Strawberry", 3.00);
        products.put("Watermelon", 2.20);

        return products;
    }

    private static Map<String, Double> filterProducts(Map<String, Double> products) {
        return products.entrySet().stream()
                .filter(entry -> entry.getValue() <= targetPrice)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private static void formAnswer(Map<String, Double> products) {
        products.forEach((name, price) -> System.out.println(name + " - " + price));
    }
}

package SetsAndMapsLections;

import java.util.*;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Map<String,Double>> shopInfo = new TreeMap<>();

        String input = scan.nextLine();

        while (!input.equals("Revision")){
            String [] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);

            shopInfo.putIfAbsent(shop,new LinkedHashMap<>());
            shopInfo.get(shop).putIfAbsent(product,0.0);
            shopInfo.get(shop).put(product,price);
            input = scan.nextLine();
        }

        shopInfo.forEach((key,value) ->{
            System.out.println(key + "->");
            value.forEach((product,price) ->{
                System.out.println(String.format("Product: %s, Price: %.1f",product,price));
            });
        });
    }
}

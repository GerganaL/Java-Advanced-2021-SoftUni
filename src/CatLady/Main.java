package CatLady;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Cat> cats = new LinkedHashMap<>();

        String input = scan.nextLine();

        while (!input.equals("End")){
            String [] information = input.split("\\s+");
            String breed = information[0];
            String name = information[1];
            String catDescription = information[2];
            switch (breed){
                case "Siamese":
                    cats.put(name,new Siamese(name,breed,Double.parseDouble(catDescription)));
                    break;
                case "StreetExtraordinaire":
                    cats.put(name,new StreetExtraordinaire(name,breed,Double.parseDouble(catDescription)));
                    break;
                case "Cymric":
                    cats.put(name,new Cymric(name,breed,Double.parseDouble(catDescription)));
                    break;
            }
            input = scan.nextLine();
        }
        String catToPrint = scan.nextLine();
        System.out.println(cats.get(catToPrint).toString());
    }
}

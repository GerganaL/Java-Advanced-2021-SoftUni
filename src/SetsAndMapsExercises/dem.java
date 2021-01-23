package SetsAndMapsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dem {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            Map<String, Map<String,Integer>> singersVenue = new LinkedHashMap<>();

            String input = scan.nextLine();

            String regex = "(([a-zA-Z]+\\s){1,3})@(([a-zA-Z]+\\s){1,3})(\\d+)\\s(\\d+)";
            Pattern pattern = Pattern.compile(regex);

            while (!input.equals("End")){
                Matcher matcher = pattern.matcher(input);
                if(matcher.find()){
                    String singer = matcher.group(1);
                    String venue = matcher.group(3);
                    venue = venue.substring(0,venue.length() -1);
                    System.out.println();

                    int ticketsPrice = Integer.parseInt(matcher.group(5));
                    int ticketsCount = Integer.parseInt(matcher.group(6));

                    int totalMoney = ticketsCount * ticketsPrice;

                    singersVenue.putIfAbsent(venue,new LinkedHashMap<>());
                    singersVenue.get(venue).putIfAbsent(singer,0);
                    singersVenue.get(venue).put(singer,singersVenue.get(venue).get(singer) + totalMoney);
                }

                input = scan.nextLine();
            }
            singersVenue.forEach((key, value) -> {
                System.out.println(key);
                singersVenue.get(key).entrySet().stream().sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                        .forEach(singer -> System.out.println("#  " + singer.getKey() + "-> " + singer.getValue()));
            });

        }
    }





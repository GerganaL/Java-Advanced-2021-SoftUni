package SetsAndMapsExercises;

import java.util.*;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        Map<String,TreeSet<String>> userIp = new TreeMap<>();
        TreeMap<String,Integer> userDuration = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scan.nextLine();
            String [] tokens = input.split("\\s+");

            String ip = tokens[0];
            String user = tokens[1];
            int duration = Integer.parseInt(tokens[2]);

            userIp.putIfAbsent(user,new TreeSet<>());
            userIp.get(user).add(ip);

            userDuration.putIfAbsent(user,0);
            userDuration.put(user,userDuration.get(user) + duration);
         }

        userDuration.forEach((k,v) ->{
            System.out.print(String.format("%s: %d ",k,v));
            System.out.println(userIp.get(k));
            });



    }
}

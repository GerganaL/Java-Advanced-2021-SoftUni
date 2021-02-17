package classroom;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agancy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<String> ids = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(ids::push);

        ArrayDeque<String> agents = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).forEach(agents::offer);


      String command = scan.nextLine();

      while (!command.equals("stop")){
          String [] tokens = command.split("-");
          String collection = tokens[1];
          switch (tokens[0]){
              case "add":
                  add(collection,ids,agents);
                  break;
              case "remove":
                  remove(collection,ids,agents);
                  break;
              case "sort":
                  ArrayDeque<String> sortStack = new ArrayDeque<>();
                  ids.stream().sorted(Comparator.naturalOrder())
                          .forEach(sortStack::push);


                  ids = sortStack;
                  break;
          }
          command = scan.nextLine();
      }

      while(!ids.isEmpty() && !agents.isEmpty()){
          if(!ids.isEmpty() && !agents.isEmpty()){
              System.out.println(agents.poll() + " takes ID number: " + ids.pop());
          }
          if(agents.isEmpty() && !ids.isEmpty()){
              System.out.println("No more agents left.");
              while (!ids.isEmpty()){
                  System.out.println("ID number: " + ids.pop());
              }
          }else if(!agents.isEmpty() && ids.isEmpty()){
              while (!agents.isEmpty()){
                  System.out.println(agents.poll() + " does not have an ID.");
              }
          }
      }


    }

    private static void remove(String collection, ArrayDeque<String> ids, ArrayDeque<String> agents) {
        String [] arr = collection.split("\\s+");
        if(collection.contains("ID")){
            System.out.println(ids.pop() + " has been removed.");
        }else {
            System.out.println(agents.removeLast() + " has left the queue.");
        }
    }

    private static void add(String collection, ArrayDeque<String> ids, ArrayDeque<String> agents) {
        String [] arr = collection.split("\\s+");
        if(collection.contains("ID")){
            String id = arr[1];
            ids.push(id);
        }else {
            agents.offer(arr[1]);
        }
    }
}

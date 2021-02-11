package christmasProblems;

import java.util.*;
import java.util.stream.Collectors;

public class SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayDeque<Integer> materials = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(materials::push);

        ArrayDeque<Integer> magicLevel = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(magicLevel::offer);

        Map<String, Integer> presents = new TreeMap<>();

        while (!materials.isEmpty() && !magicLevel.isEmpty()) {
            int material = materials.peek();
            int magic = magicLevel.peek();
            int sum = material * magic;
            if (material != 0 && magic != 0) {
                if (sum > 0) {
                    materials.pop();
                    magicLevel.poll();
                    switch (sum) {
                        case 400:
                            presents.put("Bicycle", presents.containsKey("Bicycle") ? presents.get("Bicycle") + 1 : 1);
                            break;
                        case 300:
                            presents.put("Teddy bear", presents.containsKey("Teddy bear") ? presents.get("Teddy bear") + 1 : 1);
                            break;
                        case 250:
                            presents.put("Wooden train", presents.containsKey("Wooden train") ? presents.get("Wooden train") + 1 : 1);
                            break;
                        case 150:
                            presents.put("Doll", presents.containsKey("Doll") ? presents.get("Doll") + 1 : 1);
                            break;
                        default:
                            materials.push(material + 15);
                    }
                } else {
                    materials.pop();
                    magicLevel.poll();
                    materials.push(material + magic);
                }
            } else {
                if (materials.peek() == 0) {
                    materials.pop();
                }
                if (magicLevel.peek() == 0) {
                    magicLevel.poll();
                }
            }
        }

        if (((presents.containsKey("Teddy bear") && presents.containsKey("Bicycle"))
                && (presents.get("Teddy bear") > 0 && presents.get("Bicycle") > 0))
                || ((presents.containsKey("Wooden train") && presents.containsKey("Doll"))
                && (presents.get("Wooden train") > 0 && presents.get("Doll") > 0))) {

            System.out.println("The presents are crafted! Merry Christmas!");
        }else {
            System.out.println("No presents this Christmas!");
        }

        if(!materials.isEmpty()){
            System.out.printf("Materials left: %s%n",materials.stream().map(String::valueOf).collect(Collectors.joining(", ")));

        }

        if(!magicLevel.isEmpty()){
            System.out.printf("Magic left: %s%n",magicLevel.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        presents.forEach((k,v) -> System.out.printf("%s: %d%n",k,v));
    }
}

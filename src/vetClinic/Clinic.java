package vetClinic;


import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private List<Pet> data;
    private int capacity;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public  boolean remove(String name){
        return  this.data.removeIf(pet -> pet.getName().equals(name));
        /*for (Pet pets : this.data) {
            if(pets.getName().equals(name)){
              return   this.data.remove(pets);
            }
        }
        return false;*/
    }

    public Pet getPet(String name, String owner){
       /* for (Pet pet : data) {
            if(pet.getName().equals(name)&& pet.getOwner().equals(owner)){
                return pet;
            }
        }
        return null;*/

        return data.stream().filter(e -> e.getName().equals(name) && e.getOwner().equals(owner)).findFirst().orElse(null);
    }

    public Pet getOldestPet() {

        return this.data.stream().min((p1, p2) -> Integer.compare(p2.getAge(), p1.getAge()))
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {

        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:");
        sb.append(System.lineSeparator());
        for (Pet pet : this.data) {
            sb.append(String.format("%s %s%n",pet.getName(),pet.getOwner()));
        }
        return sb.toString();

      /*  StringBuilder output = new StringBuilder("The clinic has the following patients:");
        output.append(System.lineSeparator());
        data.forEach(e -> output.append(e.getName()).append(" ").append(e.getOwner()).append(System.lineSeparator()));
        return output.toString();*/
    }

}

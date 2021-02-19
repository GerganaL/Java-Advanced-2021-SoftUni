package vetClinicRewritten;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Clinic {
    private  List<Pet> data;
    private int capacity;

    public Clinic(int capacity){
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add (Pet pet){
        if(data.size() < capacity){
            this.data.add(pet);
        }
    }

    public boolean remove (String name){
        return this.data.removeIf(p -> p.getName().equals(name));
    }

    public Pet getPet(String name, String owner){
        return this.data.stream().filter(p -> p.getName().equals(name) && p.getOwner().equals(owner))
                .findFirst().orElse(null);
    }

    public Pet getOldestPet(){
        return this.data.stream().min((p1,p2) -> Integer.compare(p2.getAge(),p1.getAge())).orElse(null);
    }

    public int getCount(){
        return  this.data.size();
    }

    //•	getStatistics() – returns a String in the following format:
    //o	"The clinic has the following patients:
    //{name} {owner}
    //{name} {owner}
    //   (…)"

    public String getStatistics(){
        StringBuilder sb = new StringBuilder("The clinic has the following patients:");
        for (Pet pet : data) {
            sb.append(System.lineSeparator());
            sb.append(pet.getName() + " " + pet.getOwner());
        }

        return sb.toString();
    }
}

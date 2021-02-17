package rabbits;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;
    private List<Rabbit> data;

    public Cage(String name, int capacity){
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setData(List<Rabbit> data) {
        this.data = data;
    }

    public void add(Rabbit rabbit){
        if(this.data.size() < getCapacity()){
            this.data.add(rabbit);
        }
    }

    public boolean removeRabbit(String name){
        return this.data.removeIf(r -> r.getName().equals(name));
    }

    public void  removeSpecies (String species){
        this.data=this.data.stream().filter(e->!e.getSpecies().equals(species)).collect(Collectors.toList());
    }

   /* public Rabbit sellRabbit(String name){
        Rabbit rabbitToReturn = null;
        for (Rabbit rabbit : this.data) {
            if(rabbit.getName().equals(name)){
                rabbit.setAvailable(false);
                rabbitToReturn = rabbit;
                break;
            }
        }

        return rabbitToReturn;
    }*/

    public Rabbit sellRabbit(String name){
        this.data.stream().filter(e->e.getName().equals(name)).findFirst().ifPresent(v->v.setAvailable(false));
        return this.data.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
    }


    public List<Rabbit> sellRabbitBySpecies (String species){
        List<Rabbit> notSold = new ArrayList<>();
        List<Rabbit> toReturn = new ArrayList<>();
        for (Rabbit rabbit : this.data) {

            if(rabbit.getSpecies().equals(species)){
                rabbit.setAvailable(false);
                toReturn.add(rabbit);
            }else{
                notSold.add(rabbit);
            }

        }
        this.data = notSold;
        return toReturn;
    }

    public int count(){
        return this.data.size();
    }


    public String report(){
        StringBuilder output=new StringBuilder("Rabbits available at ");
        output.append(getName()).append(":").append(System.lineSeparator());
        this.data.stream().filter(Rabbit::isAvailable).forEach(v->output.append(v).append(System.lineSeparator()));
        return output.toString();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

}

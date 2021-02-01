package SpeedRacing;
public class Car {
    String model;
    double fuelAmount;
    double fuelCostForKm;
    double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostForKm){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForKm = fuelCostForKm;
        this.distanceTravelled = 0;
    }

    public boolean drive(double distanceToDrive){
        double needFuel = distanceToDrive *this.fuelCostForKm;
        if(needFuel <= this.fuelAmount){
            this.distanceTravelled += distanceToDrive;
            this.fuelAmount -= needFuel;
            return true;
        }
        return false;
    }


    @Override
    public String toString() {
        return String.format("%s %.2f %.0f",this.model,this.fuelAmount,this.distanceTravelled);
    }
}

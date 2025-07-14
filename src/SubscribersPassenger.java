public class SubscribersPassenger extends Passenger {


    public SubscribersPassenger(String name, String ID) {
        super(name, ID);
    }

    @Override   //TODO: calculate trip cost based on reserved car
    public void reserveCar(Car car) {
        if(car.getMaxCapacity() == 0)
            throw new IllegalStateException("Car "+car.getCode()+" Has No Available Capacity... \nStopping.");

        super.setReservedCar(car);
        super.setTripCost(car.getFixedRoute().getPrice() - (car.getFixedRoute().getPrice() * 0.5));
        car.setMaxCapacity(car.getMaxCapacity()-1);
        }


    @Override   //TODO: Display Info
    public void displayInfo() {
        System.out.println("\n\nPassenger Name: " + super.getName());
        System.out.println("Passenger Id: " + super.getID());
        System.out.println("Passenger Car & Route:\n " + super.getReservedCar());
        System.out.println("Passenger Trip Cost: $" + super.getTripCost());
    }
}

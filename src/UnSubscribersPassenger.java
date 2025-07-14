public class UnSubscribersPassenger extends Passenger {
    private boolean coupon;

    public boolean getCoupon() {
        return coupon;
    }

    public void setHasCoupon(boolean hasCoupon) {
        this.coupon = hasCoupon;
    }

    public UnSubscribersPassenger(String name, String ID, boolean coupon) {
        super(name, ID);
        this.coupon = coupon;
    }

    @Override   //TODO: Calculate trip cost
    public void reserveCar(Car car) {
        if(car.getMaxCapacity() == 0)
            throw new IllegalStateException("Car "+car.getCode()+" Has No Available Capacity... \nStopping.");

        super.setReservedCar(car);
            if (getCoupon()) {
                super.setTripCost(car.getFixedRoute().getPrice() - (car.getFixedRoute().getPrice() * 0.1));
            } else {
                super.setTripCost(car.getFixedRoute().getPrice());
        }
            car.setMaxCapacity(car.getMaxCapacity()-1);
    }


    @Override
    public void displayInfo() {
        System.out.println("\nPassenger Name: " + super.getName());
        System.out.println("Passenger Id: " + super.getID());
        System.out.println("Passenger Car & Route:\n " + super.getReservedCar());
        System.out.println("Passenger Has A Coupon: " + this.getCoupon());
        System.out.println("Passenger Trip Cost: $" + super.getTripCost());
    }
}

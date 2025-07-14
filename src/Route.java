public class Route {
    private String pickupAddress;
    private String destinationAddress;
    private double price;



    public Route(String pickupAddress, String destinationAddress, double price) {
        this.pickupAddress = pickupAddress;
        this.destinationAddress = destinationAddress;
        this.price = price;
    }
    public String getPickupAddress() {
        return pickupAddress;
    }

    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Route[" +
                " pickupAddress: '" + pickupAddress + '\'' +
                ", destinationAddress: '" + destinationAddress + '\'' +
                ", price: $" + price +
                ']';
    }


}

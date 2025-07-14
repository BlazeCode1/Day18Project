public class Car {
    private String code;
    private Route fixedRoute;
    private int maxCapacity;

    public Car(String code, Route fixedRoute, int maxCapacity) {
        this.code = code;
        this.fixedRoute = fixedRoute;
        this.maxCapacity = maxCapacity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Route getFixedRoute() {
        return fixedRoute;
    }

    public void setFixedRoute(Route fixedRoute) {
        this.fixedRoute = fixedRoute;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    @Override
    public String toString() {
        return
                " [ Car code: '" + code + '\'' +
                ", fixedRoute: " + fixedRoute +
                ", maxCapacity: " + maxCapacity + " ]";
    }
}

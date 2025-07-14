import java.util.ArrayList;
import java.util.Scanner;

public class NewMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Route> routes = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        ArrayList<Passenger> passengers = new ArrayList<>();
        System.out.println("Welcome to the Car Pooling System");
        int mainPanelchoice = 0;
        int carPoolerChoice;
        int passengerChoice;
        String answer;
        while (mainPanelchoice!=3){
            System.out.println("1- Enter as Car Pooler");
            System.out.println("2- Enter as passenger");
            System.out.println("3- Exit");
            mainPanelchoice = sc.nextInt();

            switch (mainPanelchoice){
                case 1:
                    System.out.println("1- Add A Route.");
                    System.out.println("2- Add A Car.");
                    System.out.println("3- Display Cars.");
                    System.out.println("4- Display Routes.");
                    carPoolerChoice = sc.nextInt();

                    switch (carPoolerChoice){
                        case 1:
                            do {
                                sc.nextLine();
                                System.out.println("Pickup: ");
                                String pickup = sc.nextLine();
                                System.out.println("Destination:");
                                String destination = sc.nextLine();
                                System.out.println("Price:");
                                double price = sc.nextDouble();
                                sc.nextLine();
                                routes.add(new Route(pickup,destination,price));
                                System.out.println("Do you want to add another route? (yes/no)");
                                answer = sc.nextLine();
                            }while (answer.equalsIgnoreCase("yes"));
                            break;
                        case 2:
                            do {
                                sc.nextLine();
                                System.out.println("Car Code:");
                                String code = sc.nextLine();
                                System.out.println("Select route to assign car to:(Choose Index)");
                                for (int i = 0; i < routes.size(); i++) {
                                    System.out.println(i+" :"+routes.get(i));
                                }
                                int index = sc.nextInt();

                                System.out.println("Input Max Capacity:");
                                int capacity = sc.nextInt();

                                cars.add(new Car(code, routes.get(index), capacity));
                                sc.nextLine();
                                System.out.println("Do you want to continue adding cars?(yes/no)");
                                answer =sc.nextLine();
                            }while (answer.equalsIgnoreCase("yes"));
                            break;
                        case 3:
                            System.out.println("Cars Available");
                            for (Car c : cars){
                                System.out.println(c);
                            }
                            break;
                        case 4:
                            System.out.println("Routes Available");
                            for(Route r : routes){
                                System.out.println(r);
                            }


                    }
                    break;
                case 2:

                    do {
                        System.out.println("1- Rent A Trip");
                        System.out.println("2- Show Trip details and cost");
                        System.out.println("3- Exit.");

                        passengerChoice = sc.nextInt();

                        switch (passengerChoice){
                            case 1:
                                sc.nextLine();
                                System.out.println("Your Name:");
                                String name = sc.nextLine();
                                System.out.println("ID:");
                                String id = sc.nextLine();

                                if (!cars.isEmpty()) {
                                    System.out.println("Cars Available:(Choose index)");
                                    for (int i = 0; i < cars.size(); i++) {
                                        System.out.println(i +" : "+ cars.get(i));
                                    }
                                    int index = sc.nextInt();
                                    sc.nextLine();
                                    System.out.println("Are you a Subscriber? (yes/no)");
                                    String subscriber = sc.nextLine();
                                    if(subscriber.contains("yes")){
                                        passengers.add(new SubscribersPassenger(name,id));
                                    }else{
                                        System.out.println("Do you have a coupon? (yes/no)");
                                        String coupon = sc.nextLine();
                                        if (coupon.contains("yes")){
                                            passengers.add(new UnSubscribersPassenger(name,id,true));
                                        }else{
                                            passengers.add(new UnSubscribersPassenger(name,id,false));
                                        }
                                    }
                                    if(passengers.size() == 1){
                                        passengers.getFirst().reserveCar(cars.get(index));
                                    }else{
                                        passengers.getLast().reserveCar(cars.get(index));
                                    }
                                    break;
                                }else {
                                    System.out.println("No Cars Available.");
                                    break;
                                }



                            case 2:
                                sc.nextLine();
                                if(passengers.isEmpty()){
                                    System.out.println("There are no information available At This Time");
                                }else {
                                    System.out.println("Enter Passenger ID to look up Trips");
                                    String search = sc.nextLine();
                                    boolean flag = false;
                                    int indexAt = 0;

                                    for (int i = 0; i < passengers.size(); i++) {
                                        if(passengers.get(i).getID().equalsIgnoreCase(search)){
                                            flag = true;
                                            indexAt = i;
                                        }
                                    }
                                    if(flag){
                                        System.out.println("Trip found and here are the details:");
                                        passengers.get(indexAt).displayInfo();

                                    }else {
                                        System.out.println("Trip not found with ID:"+ search);
                                    }
                                }
                        }


                    }while (passengerChoice != 3);



            }
        }

    }
}

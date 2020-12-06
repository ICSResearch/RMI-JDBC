import javax.management.remote.rmi.RMIServer;
import java.rmi.*;
import java.util.Scanner;
import java.util.Vector;

public class RmiClient {
    public static void main(String[] args) {
        try{
            //Lookup.
            DBServerInterface ds = (DBServerInterface) Naming.lookup("ds");

            System.out.println("1.New car.\n" +
                    "2.New receipt.\n" +
                    "3.Query car via ID.\n" +
                    "4.Query car via brand.\n" +
                    "5.Query receipt via ID.\n" +
                    "6.Query receipt via name.\n" +
                    "7.Traverse cars.\n" +
                    "8.Traverse receipts.\n" +
                    "9.Exit.\n" +
                    "?");

            int flag = 0;
            while(flag != 9){
                Scanner sc = new Scanner(System.in);
                flag = sc.nextInt();

                switch (flag) {
                    //Insert car.
                    case 1 -> {
                        System.out.println("Please type in ID(int), Brand(String), Series(String), Color(String)" +
                                ", Year(int), Weight(int), Price(int).");
                        boolean jud = ds.insertCar(sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.nextInt(), sc.nextInt(),
                                sc.nextInt());
                        if (jud) {
                            System.out.println("Done!");
                        } else {
                            System.out.println("False!");
                        }
                    }
                    //Insert receipt.
                    case 2 -> {
                        System.out.println("Please type in ID(int), name(String).");
                        boolean jud = ds.insertReceipt(sc.nextInt(), sc.next());
                        if (jud) {
                            System.out.println("Done!");
                        } else {
                            System.out.println("False!");
                        }
                    }
                    //Query car via ID.
                    case 3 -> {
                        System.out.println("Please type in ID(int) of a car.");
                        Car car = ds.showCar_ID(sc.nextInt());
                        if(car != null){
                            System.out.printf("ID: %-10d Brand: %-10s Series: %-10s Color: %-6s " +
                                    "Year: %-6d Weight: %-10d Price: %-10d\n",
                                    car.getID(),
                                    car.getBrand(),
                                    car.getSeries(),
                                    car.getColor(),
                                    car.getYear(),
                                    car.getWeight(),
                                    car.getPrice());
                        }
                        else {
                            System.out.println("None!");
                        }
                    }
                    //Query cars via Brand.
                    case 4 -> {
                        System.out.println("Please type in Brand(String) of car.");
                        Vector<Car> cars = ds.showCar_Brand(sc.next());
                        if (cars != null){
                            for (Car car : cars) {
                                System.out.printf("ID: %-10d Brand: %-10s Series: %-10s Color: %-6s " +
                                                "Year: %-6d Weight: %-10d Price: %-10d\n",
                                        car.getID(),
                                        car.getBrand(),
                                        car.getSeries(),
                                        car.getColor(),
                                        car.getYear(),
                                        car.getWeight(),
                                        car.getPrice());
                            }
                        }
                        else {
                            System.out.println("None!");
                        }
                    }
                    //Query receipt via ID.
                    case 5 -> {
                        System.out.println("Please type in ID(int) of a receipt.");
                        Receipt receipt = ds.showReceipt_ID(sc.nextInt());
                        if (receipt != null){
                            System.out.printf("ID: %-10d Name: %-10s\n", receipt.getID(), receipt.getName());
                        }
                        else {
                            System.out.println("None!");
                        }
                    }
                    //Query receipts via Name.
                    case 6 -> {
                        System.out.println("Please type in Name(String) of receipt.");
                        Vector<Receipt> receipts = ds.showReceipt_Name(sc.next());
                        if (receipts != null){
                            for (Receipt receipt : receipts) {
                                System.out.printf("ID: %-10d Name: %-10s\n", receipt.getID(), receipt.getName());
                            }
                        }
                        else {
                            System.out.println("None!");
                        }
                    }
                    //Traverse cars.
                    case 7 -> {
                        Vector<Car> cars = ds.showCars();
                        for (Car car : cars) {
                            System.out.printf("ID: %-10d Brand: %-10s Series: %-10s Color: %-6s " +
                                            "Year: %-6d Weight: %-10d Price: %-10d\n",
                                    car.getID(),
                                    car.getBrand(),
                                    car.getSeries(),
                                    car.getColor(),
                                    car.getYear(),
                                    car.getWeight(),
                                    car.getPrice());
                        }
                    }
                    //Traverse receipts.
                    case 8 -> {
                        Vector<Receipt> receipts = ds.showReceipts();
                        for (Receipt receipt : receipts) {
                            System.out.printf("ID: %-10d Name: %-10s\n", receipt.getID(), receipt.getName());
                        }
                    }
                    //Exit.
                    case 9 -> System.out.println("Bye!");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.exit(0);
    }
}

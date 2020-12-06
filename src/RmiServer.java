import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;

public class RmiServer {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);

            DBServerInterface ds = new DBServer();
            Naming.rebind("ds", ds);
            System.out.println("RMI server is ready...");

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}


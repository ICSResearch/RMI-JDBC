import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

public interface DBServerInterface extends Remote{
    public boolean insertCar(int ID, String Brand, String Series, String Color, int Year, int Weight, int Price) throws RemoteException;
    public boolean insertReceipt(int ID, String Name) throws RemoteException;
    public Car showCar_ID(int ID) throws RemoteException;
    public Vector<Car> showCar_Brand(String Brand) throws RemoteException;
    public Receipt showReceipt_ID(int ID) throws RemoteException;
    public Vector<Receipt> showReceipt_Name(String Name) throws  RemoteException;
    public Vector<Car> showCars() throws RemoteException;
    public Vector<Receipt> showReceipts() throws  RemoteException;
}

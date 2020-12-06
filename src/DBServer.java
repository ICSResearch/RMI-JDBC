import java.rmi.server.*;
import java.rmi.*;
import java.util.Vector;

public class DBServer extends UnicastRemoteObject implements DBServerInterface {

    public DBServer() throws RemoteException{
        super();
    }

    @Override
    public boolean insertCar(int ID, String Brand, String Series, String Color, int Year, int Weight, int Price) throws RemoteException {
        return DBManager.insertCar(ID, Brand, Series, Color, Year, Weight, Price);
    }

    @Override
    public boolean insertReceipt(int ID, String Name) throws RemoteException {
        return DBManager.insertReceipt(ID, Name);
    }

    @Override
    public Car showCar_ID(int ID) throws RemoteException {
        return DBManager.showCar_ID(ID);
    }

    @Override
    public Vector<Car> showCar_Brand(String Brand) throws RemoteException {
        return DBManager.showCar_Brand(Brand);
    }

    @Override
    public Receipt showReceipt_ID(int ID) throws RemoteException {
        return DBManager.showReceipt_ID(ID);
    }

    @Override
    public Vector<Receipt> showReceipt_Name(String Name) throws RemoteException {
        return DBManager.showReceipt_Name(Name);
    }

    @Override
    public Vector<Car> showCars() throws RemoteException {
        return DBManager.showCars();
    }

    @Override
    public Vector<Receipt> showReceipts() throws RemoteException {
        return DBManager.showReceipts();
    }
}

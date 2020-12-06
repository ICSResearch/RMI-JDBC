import java.io.Serializable;

public class Receipt implements Serializable {
    private int ID;
    public String Name;

    public Receipt(){

    }

    public void setID(int a){
        this.ID = a;
    }
    public int getID(){
        return ID;
    }

    public void setName(String a){
        this.Name = a;
    }
    public String getName(){
        return Name;
    }
}
import java.io.Serializable;

public class Car implements Serializable {
    private int ID;
    public String Brand;
    public String Series;
    private String Color;
    public int Year;
    public int Weight;
    public int Price;

    public Car(){

    }

    public void setID(int a){
        this.ID = a;
    }
    public int getID(){
        return ID;
    }

    public void setBrand(String a){
        this.Brand = a;
    }
    public String getBrand(){
        return Brand;
    }

    public void setSeries(String a){
        this.Series = a;
    }
    public String getSeries(){
        return Series;
    }

    public void setColor(String a){
        this.Color = a;
    }
    public String getColor(){
        return Color;
    }

    public void setYear(int a){
        this.Year = a;
    }
    public int getYear(){
        return Year;
    }

    public void setWeight(int a){
        this.Weight = a;
    }
    public int getWeight(){
        return Weight;
    }

    public void setPrice(int a){
        this.Price = a;
    }
    public int getPrice(){
        return Price;
    }
}

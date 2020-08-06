package JavaBackend.buoi7.Target;

public class EnumerateCar {
    String name;
    String nameNSX;
    public EnumerateCar(){

    }
    public EnumerateCar(String name,String nameNSX){
        this.name=name;
        this.nameNSX=nameNSX;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameNSX() {
        return nameNSX;
    }

    public void setNameNSX(String nameNSX) {
        this.nameNSX = nameNSX;
    }
}

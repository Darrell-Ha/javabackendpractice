package JavaBackend.buoi2.database.models;

import java.util.HashMap;

public class Counters {
    private String maker;
    private int counter;
    public Counters(){

    }
    public Counters(String maker,int counter){
        this.maker=maker;
        this.counter=counter;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Counters{" +
                "maker='" + maker + '\'' +
                ", counter=" + counter +
                '}';
    }
}

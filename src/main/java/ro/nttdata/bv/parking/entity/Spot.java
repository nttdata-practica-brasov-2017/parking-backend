package ro.nttdata.bv.parking.entity;

/**
 * Created by Linda on 08.09.2017.
 */

public class Spot {

    private int number;
    private int floor;

    public int getNumber() {
        return number;
    }

    public int getFloor() {
        return floor;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Spot{" +
                "number=" + number +
                ", floor=" + floor +
                '}';
    }
}

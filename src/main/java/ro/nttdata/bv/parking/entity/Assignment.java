package ro.nttdata.bv.parking.entity;

/**
 * Created by Linda on 08.09.2017.
 */

public class Assignment {

    private String username;
    private int spotNumber;

    public String getUsername() {
        return username;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "username='" + username + '\'' +
                ", spotNumber=" + spotNumber +
                '}';
    }
}

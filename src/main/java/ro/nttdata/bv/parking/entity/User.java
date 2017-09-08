package ro.nttdata.bv.parking.entity;

/**
 * Created by Linda on 08.09.2017.
 */

public class User {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private boolean assignedSpot;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean isAssignedSpot() {
        return assignedSpot;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAssignedSpot(boolean assignedSpot) {
        this.assignedSpot = assignedSpot;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", assignedSpot=" + assignedSpot +
                '}';
    }
}
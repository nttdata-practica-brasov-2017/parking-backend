package ro.nttdata.bv.parking.entity;

import java.util.Date;

/**
 * Created by Linda on 08.09.2017.
 */

public class Vacancy {

    private String spotNumber;
    private Date date;
    private Date vacatedAt;
    private String booked_by;

    public String getSpotNumber() {
        return spotNumber;
    }

    public Date getDate() {
        return date;
    }

    public Date getVacatedAt() {
        return vacatedAt;
    }

    public String getBooked_by() {
        return booked_by;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setVacatedAt(Date vacatedAt) {
        this.vacatedAt = vacatedAt;
    }

    public void setBooked_by(String booked_by) {
        this.booked_by = booked_by;
    }

    @Override
    public String toString() {
        return "Vacancy{" +
                "spotNumber='" + spotNumber + '\'' +
                ", date=" + date +
                ", vacatedAt=" + vacatedAt +
                ", booked_by='" + booked_by + '\'' +
                '}';
    }
}

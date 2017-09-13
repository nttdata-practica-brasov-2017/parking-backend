package ro.nttdata.bv.parking.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Linda on 08.09.2017.
 */

@Entity
@Table(name="T_VACANCY")
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name="SPOT_ID")
    private Spot spot;

    @Column( name = "DATE")
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column( name = "VACATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vacatedAt;

    @ManyToOne
    @JoinColumn(name = "BOOKED_BY")
    private User bookedBy;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getVacatedAt() {
        return vacatedAt;
    }

    public void setVacatedAt(Date vacatedAt) {
        this.vacatedAt = vacatedAt;
    }

    public User getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(User bookedBy) {
        this.bookedBy = bookedBy;
    }
}

package ro.nttdata.bv.parking.entity;

import javax.persistence.*;

/**
 * Created by Linda on 08.09.2017.
 */

@Entity
@Table(name="T_ASSIGNMENT")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private User username;

    @Column
    private Spot spot;

    public User getUsername() {
        return username;
    }

    public void setUsername(User username) {
        this.username = username;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}

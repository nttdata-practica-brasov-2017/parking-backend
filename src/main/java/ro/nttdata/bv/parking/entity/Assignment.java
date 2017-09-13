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

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToOne
    @JoinColumn(name = "SPOT_ID")
    private Spot spot;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }
}

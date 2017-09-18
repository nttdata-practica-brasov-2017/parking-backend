package ro.nttdata.bv.parking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import ro.nttdata.bv.parking.boundary.Views;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Linda on 08.09.2017.
 */

@Entity
@Table(name = "T_USER")
public class User {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column
    private String username;

    @JsonView(Views.Internal.class)
    @NotNull
    @Column
    private String password;

    @JsonView(Views.Public.class)
    @Column
    private String firstName;

    @JsonView(Views.Public.class)
    @Column
    private String lastName;

    @JsonBackReference
    @OneToMany(mappedBy = "bookedBy")
    private List<Vacancy> bookings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
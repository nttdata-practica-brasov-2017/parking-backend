package ro.nttdata.bv.parking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import ro.nttdata.bv.parking.boundary.Views;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Linda on 08.09.2017.
 */

@Entity
@Table(name = "T_SPOT")
public class Spot {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonView(Views.Public.class)
    @NotNull
    @Column(name = "SPOT_NUMBER")
    private Integer number;

    @JsonView(Views.Public.class)
    @Column(name = "FLOOR")
    private Integer floor;

    @JsonBackReference
    @OneToMany(mappedBy = "spot")
    private List<Vacancy> vacancies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = this.id;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

}

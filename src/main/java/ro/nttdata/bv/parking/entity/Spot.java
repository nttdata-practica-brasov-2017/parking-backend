package ro.nttdata.bv.parking.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

/**
 *
 * Created by Linda on 08.09.2017.
 */

@Entity
@Table(name = "T_SPOT")
public class Spot {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Integer number;

    @Column
    private Integer floor;

    @JsonBackReference
    @OneToMany(mappedBy = "spot")
    private List<Vacancy> vacancies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Spot{" +
                "number=" + number +
                ", floor=" + floor +
                '}';
    }
}

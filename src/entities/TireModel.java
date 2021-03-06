package entities;
// Generated Dec 9, 2017 1:22:07 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import utils.IgnoreTable;

/**
 * TireModel generated by hbm2java
 */
@Entity
@Table(name = "tireModel",
        catalog = "tireControl"
)
public class TireModel implements java.io.Serializable {

    @IgnoreTable
    private Integer id;
    private String name;
    @IgnoreTable
    private Set<Tire> tires = new HashSet<Tire>(0);

    public TireModel() {
    }

    public TireModel(String name) {
        this.name = name;
    }

    public TireModel(String name, Set<Tire> tires) {
        this.name = name;
        this.tires = tires;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 200)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tireModel")
    public Set<Tire> getTires() {
        return this.tires;
    }

    public void setTires(Set<Tire> tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

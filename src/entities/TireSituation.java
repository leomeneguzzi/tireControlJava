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
 * TireSituation generated by hbm2java
 */
@Entity
@Table(name = "tireSituation",
        catalog = "tireControl"
)
public class TireSituation implements java.io.Serializable {

    @IgnoreTable
    private Integer id;
    private String name;
    private String description;
    @IgnoreTable
    private Set<Tire> tires = new HashSet<Tire>(0);

    public TireSituation() {
    }

    public TireSituation(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public TireSituation(String name, String description, Set<Tire> tires) {
        this.name = name;
        this.description = description;
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

    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tireSituation")
    public Set<Tire> getTires() {
        return this.tires;
    }

    public void setTires(Set<Tire> tires) {
        this.tires = tires;
    }

}
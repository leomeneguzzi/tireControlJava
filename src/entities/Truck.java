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
 * Truck generated by hbm2java
 */
@Entity
@Table(name = "truck",
        catalog = "tireControl"
)
public class Truck implements java.io.Serializable {

    @IgnoreTable
    private Integer id;
    private String plate;
    @IgnoreTable
    private Set<Mount> mounts = new HashSet<Mount>(0);

    public Truck() {
    }

    public Truck(String plate) {
        this.plate = plate;
    }

    public Truck(String plate, Set<Mount> mounts) {
        this.plate = plate;
        this.mounts = mounts;
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

    @Column(name = "plate", nullable = false, length = 50)
    public String getPlate() {
        return this.plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "truck")
    public Set<Mount> getMounts() {
        return this.mounts;
    }

    public void setMounts(Set<Mount> mounts) {
        this.mounts = mounts;
    }

}
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
 * BandType generated by hbm2java
 */
@Entity
@Table(name = "bandType",
        catalog = "tireControl"
)
public class BandType implements java.io.Serializable {

    @IgnoreTable
    private Integer id;
    private String name;
    @IgnoreTable
    private Set<Retread> retreads = new HashSet<Retread>(0);

    public BandType() {
    }

    public BandType(String name) {
        this.name = name;
    }

    public BandType(String name, Set<Retread> retreads) {
        this.name = name;
        this.retreads = retreads;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "bandType")
    public Set<Retread> getRetreads() {
        return this.retreads;
    }

    public void setRetreads(Set<Retread> retreads) {
        this.retreads = retreads;
    }

    @Override
    public String toString() {
        return this.name;
    }
    
    

}

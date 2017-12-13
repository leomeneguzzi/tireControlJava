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

/**
 * UnmountReason generated by hbm2java
 */
@Entity
@Table(name = "unmountReason",
         catalog = "tireControl"
)
public class UnmountReason implements java.io.Serializable {

    private Integer id;
    private String unmountReason;
    private String description;
    private Set<Unmount> unmounts = new HashSet<Unmount>(0);

    public UnmountReason() {
    }

    public UnmountReason(String unmountReason, String description) {
        this.unmountReason = unmountReason;
        this.description = description;
    }

    public UnmountReason(String unmountReason, String description, Set<Unmount> unmounts) {
        this.unmountReason = unmountReason;
        this.description = description;
        this.unmounts = unmounts;
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

    @Column(name = "unmountReason", nullable = false, length = 200)
    public String getUnmountReason() {
        return this.unmountReason;
    }

    public void setUnmountReason(String unmountReason) {
        this.unmountReason = unmountReason;
    }

    @Column(name = "description", nullable = false, length = 1000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "unmountReason")
    public Set<Unmount> getUnmounts() {
        return this.unmounts;
    }

    public void setUnmounts(Set<Unmount> unmounts) {
        this.unmounts = unmounts;
    }

}

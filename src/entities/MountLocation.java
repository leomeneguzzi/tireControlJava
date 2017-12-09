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
 * MountLocation generated by hbm2java
 */
@Entity
@Table(name="mountLocation"
    ,catalog="tireControl"
)
public class MountLocation  implements java.io.Serializable {


     private Integer id;
     private String mountLocation;
     private Set<Mount> mounts = new HashSet<Mount>(0);

    public MountLocation() {
    }

	
    public MountLocation(String mountLocation) {
        this.mountLocation = mountLocation;
    }
    public MountLocation(String mountLocation, Set<Mount> mounts) {
       this.mountLocation = mountLocation;
       this.mounts = mounts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    
    @Column(name="mountLocation", nullable=false, length=200)
    public String getMountLocation() {
        return this.mountLocation;
    }
    
    public void setMountLocation(String mountLocation) {
        this.mountLocation = mountLocation;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mountLocation")
    public Set<Mount> getMounts() {
        return this.mounts;
    }
    
    public void setMounts(Set<Mount> mounts) {
        this.mounts = mounts;
    }




}



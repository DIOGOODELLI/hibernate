package hipermvc.model;
// Generated 14/09/2019 15:20:42 by Hibernate Tools 4.3.1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Regions generated by hbm2java
 */
public class Regions  implements java.io.Serializable {


     private BigDecimal regionId;
     private String regionName;
     private Set countrieses = new HashSet(0);

    public Regions() {
    }

	
    public Regions(BigDecimal regionId) {
        this.regionId = regionId;
    }
    public Regions(BigDecimal regionId, String regionName, Set countrieses) {
       this.regionId = regionId;
       this.regionName = regionName;
       this.countrieses = countrieses;
    }
   
    public BigDecimal getRegionId() {
        return this.regionId;
    }
    
    public void setRegionId(BigDecimal regionId) {
        this.regionId = regionId;
    }
    public String getRegionName() {
        return this.regionName;
    }
    
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }
    public Set getCountrieses() {
        return this.countrieses;
    }
    
    public void setCountrieses(Set countrieses) {
        this.countrieses = countrieses;
    }
}



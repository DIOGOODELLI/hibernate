package hipermvc.model;
// Generated 17/09/2019 12:50:38 by Hibernate Tools 4.3.1


import java.math.BigDecimal;

/**
 * Notasitem generated by hbm2java
 */
public class Notasitem  implements java.io.Serializable {

     private NotasitemId id;
     private BigDecimal valortotalitem;
     private Notas Notas;

    public Notas getNotas() {
        return Notas;
    }

    public void setNotas(Notas Notas) {
        this.Notas = Notas;
    }

    public Notasitem(NotasitemId id, BigDecimal valortotalitem, Notas Notas) {
        this.id = id;
        this.valortotalitem = valortotalitem;
        this.Notas = Notas;
    }
     
     
        
    public Notasitem() {
    }

	
    public Notasitem(NotasitemId id) {
        this.id = id;
    }
    public Notasitem(NotasitemId id, BigDecimal valortotalitem) {
       this.id = id;
       this.valortotalitem = valortotalitem;
    }
   
    public NotasitemId getId() {
        return this.id;
    }
    
    public void setId(NotasitemId id) {
        this.id = id;
    }
    public BigDecimal getValortotalitem() {
        return this.valortotalitem;
    }
    
    public void setValortotalitem(BigDecimal valortotalitem) {
        this.valortotalitem = valortotalitem;
    }
}


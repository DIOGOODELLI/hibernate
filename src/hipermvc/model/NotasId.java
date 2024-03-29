package hipermvc.model;
// Generated 17/09/2019 12:50:38 by Hibernate Tools 4.3.1


/**
 * NotasId generated by hbm2java
 */
public class NotasId  implements java.io.Serializable {
    
    private long filial;
    private long sequencia;

    public NotasId() {
    }

    public NotasId(long filial, long sequencia) {
       this.filial = filial;
       this.sequencia = sequencia;
    }

    public NotasId(Long valueOf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    public long getFilial() {
        return this.filial;
    }
    
    public void setFilial(long filial) {
        this.filial = filial;
    }
    public long getSequencia() {
        return this.sequencia;
    }
    
    public void setSequencia(long sequencia) {
        this.sequencia = sequencia;
    }


     @Override
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NotasId) ) return false;
		 NotasId castOther = ( NotasId ) other; 
         
		 return (this.getFilial()==castOther.getFilial())
 && (this.getSequencia()==castOther.getSequencia());
   }
   
     @Override
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getFilial();
         result = 37 * result + (int) this.getSequencia();
         return result;
   }   


}



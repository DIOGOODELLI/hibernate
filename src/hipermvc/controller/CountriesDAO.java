/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipermvc.controller;

import hipermvc.model.Countries;
import hipermvc.model.Notas;
import hipermvc.model.NotasId;
import hipermvc.model.Notasitem;
import hipermvc.model.NotasitemId;
import hipermvc.model.Regions;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CountriesDAO 
{    
   static Session session = null;
   static Transaction tr = null;
   
   public static void Inserir (Countries c)
   {
       session.save(c);
   }
   
   public static void Update (Countries c)
   {
       session.update(c);
   }
    
   public static void Delete (Countries c)
   {
       session.delete(c);
   }
   
    public static List<Object[]> Lista()
    {          
        session = HibernateUtil.getSessionFactory().openSession();
        tr = session.beginTransaction();

        Regions reg = new Regions();
        reg.setRegionId(BigDecimal.valueOf(2));

         //Countries countries = new Countries("HU", reg, "HUEHUE", null);
         //Inserir (countries);
         //Update (countries);
         //Delete (countries)

        List<Object[]> lista = session.createQuery(
        "From hipermvc.model.Countries a,hipermvc.model.Regions b "
                  + "where a.regions = b.regionId").list();
        
            lista.forEach((Object[] result) -> {
            
            Countries cou = (Countries) result[0];
            Regions red = (Regions) result[1];
            
            System.out.println(red.getRegionName());
      
        });

            
        tr.commit();
        session.close();
       
        return lista;
    }

    
    
    public static void InserirChaveComposta()
    {
        /*
        String filial = "10";
        int sequencia = 1;
        int itemSequecia = 2;
        double valor  = 100.3;
        
        NotasId notaid = new NotasId(Long.valueOf(filial), sequencia);
        Notas notas = new Notas(notaid, BigDecimal.valueOf(valor));
            
        session.save(notas); 
        
       
        //comando com chave composta!
        String d = "select a.id.filial,b.valortotalitem from Notas a "
                + "join a.notasitens b where a.id.filial = 10";
      
        String e = "";
        
        //Object [] -> se tem mais de um
        List<int []> lista = session.createQuery(d)
        .list();
        
        */  
        
        String filial = "10";
        int sequencia = 1;
        int itemSequecia = 1;
        double valor  = 500.3;
        
     
        NotasitemId notaitemid = new NotasitemId(Long.valueOf(filial), Long.valueOf(sequencia), Long.valueOf(itemSequecia));
        Notasitem notasItem = new Notasitem(notaitemid, BigDecimal.valueOf(valor));
        
        session.save(notasItem);  

    }         
    
    
    
    public static void Lista2()
    {
        //join direto A

        //primeiro From vai o name da classe no model
        //depois disso vai os nomes do atributos no xml
        //fora isso a formação do comando é o mesmo
        
        String a = "From hipermvc.model.Countries a,hipermvc.model.Regions b "
                  + "where a.regions = b.regionId";
        
        // join simples e direto
        String b = "select con.countryName, reg.regionName from Countries con "
                + "left join con.regions reg";
        
        //Mais de um join 
        String c = "select b.departmentName from JobHistory a "
                + "join a.departments b "
                + "join a.employees c "
                + "join c.jobs d ";
        
        //SubSelect + Join
        String d = "select a.firstName from Employees a "
                + "join a.jobs b "
                + "where a.salary > "
                + "(select maxSalary from Jobs b where b.jobId = 'IT_PROG')";
        
        String e = "";
        
        
        //Object [] -> se tem mais de um
        List<String> lista = session.createQuery(e)
        .list();

        lista.forEach((String result) -> {
            System.out.println(result);
        });
    }
    
    
    
    public static void main(String[] args) {
        try{
            
           session = HibernateUtil.getSessionFactory().openSession();
           tr = session.beginTransaction();
            
            Regions reg = new Regions();
            reg.setRegionId(BigDecimal.valueOf(2));
            
            //Countries countries = new Countries("HU", reg, "HUEHUE", null);
            //Inserir (countries);
            //Update (countries);
            //Delete (countries)
            
            //Lista2();
            
            InserirChaveComposta();
            
            tr.commit();
            session.close();
        } 
        catch (HibernateException e){
            System.out.println(e);
        }
    }
}




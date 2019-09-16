/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hipermvc.controller;

import hipermvc.model.Countries;
import hipermvc.model.Regions;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


/*

SELECT
    a.end_date,
    b.department_name,
    c.last_name,
    d.job_title
FROM
    hr.job_history a
JOIN HR.departments b on a.department_id = b.department_id 
JOIN HR.employees c ON a.employee_id = c.employee_id
JOIN HR.jobs d on c.job_id = d.job_id
*/

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
        
        //List<Countries> list;
        //Query query = session.createQuery("From hipermvc.model.Countries a where COUNTRY_ID= :id ");
        //query.setParameter("id", "IT");
        //list = query.list();
        //list.forEach((cob) -> {
        //    System.out.println(cob.getCountryName());
       //});  
       
    
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

    
    
    
    public static void Lista2()
    { 
        List<Object[]> listaJoin1 = session.createQuery(
        "From hipermvc.model.Countries a,hipermvc.model.Regions b "
                  + "where a.regions = b.regionId").list();
        
        List<Object[]> listaJoin2 = session.createQuery(
        "select con.countryName, reg.regionName from Countries con "
                + "left join con.regions reg")
        .list();
        
        
        List<Object[]> lista = session.createQuery(
        "select con.countryName, reg.regionName from Countries con "
                + "left join con.regions reg")
        .list();
        
        
        lista.forEach((Object[] result) -> {
            System.out.println(result[1]);
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
            
            Lista2();
            
            tr.commit();
            session.close();
        } 
        catch (HibernateException e){
            System.out.println(e);
        }
    }
}




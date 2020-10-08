package io.github.jcmazsio.entities;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.*;

@Entity
public class Etudiant implements Serializable
{
    /**
     *
     */
    private static final long serialVersionUID = 7652338018693199472L;

    @Id
    private int id_etudiant;

    private String nom;
    private String prenom;
    private String telephone;
    private LocalDate date_naissance;

    @Override
    public String toString()
    {
       String x = "prenom : "+this.prenom+" nom : "+this.nom+" telephone : "+this.telephone+" date : "+this.date_naissance;
        return x;
    }
    private static final String persistenceUnitName="mabase-unit";
   private static EntityManagerFactory factory;

    public static void main( String[] args )
    {
        factory = Persistence.createEntityManagerFactory(persistenceUnitName);
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Etudiant et = new Etudiant();
        et.nom ="Toto";
        et.prenom="Jean";
        et.date_naissance = LocalDate.of(2002,07,14);
        et.telephone ="0596020458";
        em.persist(et);
        em.getTransaction().commit();

        List<Etudiant> le = em.createQuery("select e from Etudiant e",Etudiant.class).getResultList();
        for (Etudiant e : le )
        {
            System.out.println(e);
        }
        em.close();
    }
}

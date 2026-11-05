package ma.fstt.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import ma.fstt.dao.JPAUtil;
import ma.fstt.model.*;

@ManagedBean
@SessionScoped
public class ProduitBean implements Serializable {

    private Produit produit = new Produit();

    public void ajouter() {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        List<Vitrine> liste = em.createQuery(
            "SELECT v FROM Vitrine v", Vitrine.class).getResultList();

        Vitrine v;

        if (liste.isEmpty()) {
            v = new Vitrine();
            v.setTitre("Vitrine principale");
            em.persist(v);
        } else {
            v = liste.get(0);
        }

        produit.setVitrine(v);
        em.persist(produit);

        em.getTransaction().commit();
        em.close();

        produit = new Produit();
    }

    public void supprimer(Produit p) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Produit.class, p.getId()));
        em.getTransaction().commit();

        em.close();
    }

    public List<Produit> getListe() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Produit> liste = em.createQuery(
            "SELECT p FROM Produit p", Produit.class).getResultList();

        em.close();

        return liste;
    }

    public Produit getProduit() {
        return produit;
    }
}
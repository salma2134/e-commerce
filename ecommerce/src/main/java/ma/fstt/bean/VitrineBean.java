package ma.fstt.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;

import ma.fstt.dao.JPAUtil;
import ma.fstt.model.Produit;

@ManagedBean
@ViewScoped
public class VitrineBean implements Serializable {

    private List<Produit> produits;

    @PostConstruct
    public void init() {
        EntityManager em = JPAUtil.getEntityManager();

        produits = em.createQuery(
            "SELECT p FROM Produit p", Produit.class).getResultList();

        em.close();
    }

    public List<Produit> getProduits() {
        return produits;
    }
}
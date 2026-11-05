package ma.fstt.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import ma.fstt.dao.JPAUtil;
import ma.fstt.model.*;

@ManagedBean
@SessionScoped
public class PanierBean implements Serializable {

    @ManagedProperty("#{internauteBean}")
    private InternauteBean internauteBean;

    public Panier getPanier() {
        EntityManager em = JPAUtil.getEntityManager();

        Panier p = em.find(Panier.class,
            internauteBean.getConnecte().getPanier().getId());

        em.close();

        return p;
    }

    public void ajouter(Produit produit) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        Panier panier = em.find(Panier.class,
            internauteBean.getConnecte().getPanier().getId());

        Produit p = em.find(Produit.class, produit.getId());

        LignePanier ligne = null;

        for (LignePanier l : panier.getLignes()) {
            if (l.getProduit().getId().equals(p.getId())) {
                ligne = l;
                break;
            }
        }

        if (ligne == null) {
            ligne = new LignePanier();
            ligne.setProduit(p);
            ligne.setPanier(panier);
            ligne.setQuantite(1);
            panier.getLignes().add(ligne);
        } else {
            ligne.setQuantite(ligne.getQuantite() + 1);
        }

        em.getTransaction().commit();
        em.close();
    }

    public void retirer(LignePanier ligne) {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(LignePanier.class, ligne.getId()));
        em.getTransaction().commit();

        em.close();
    }

    public void setInternauteBean(InternauteBean internauteBean) {
        this.internauteBean = internauteBean;
    }
}
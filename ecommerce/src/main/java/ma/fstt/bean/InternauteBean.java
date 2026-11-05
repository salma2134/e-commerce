package ma.fstt.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.persistence.EntityManager;

import ma.fstt.dao.JPAUtil;
import ma.fstt.model.Internaute;
import ma.fstt.model.Panier;

@ManagedBean
@SessionScoped
public class InternauteBean implements Serializable {

    private Internaute internaute = new Internaute();
    private Internaute connecte;

    public String inscrire() {
        EntityManager em = JPAUtil.getEntityManager();

        em.getTransaction().begin();

        internaute.setPanier(new Panier());
        em.persist(internaute);

        em.getTransaction().commit();
        em.close();

        internaute = new Internaute();

        return "login?faces-redirect=true";
    }

    public String connecter() {
        EntityManager em = JPAUtil.getEntityManager();

        List<Internaute> liste = em.createQuery(
            "SELECT i FROM Internaute i WHERE i.email=:email AND i.motDePasse=:mdp",
            Internaute.class)
            .setParameter("email", internaute.getEmail())
            .setParameter("mdp", internaute.getMotDePasse())
            .getResultList();

        em.close();

        if (liste.isEmpty()) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Email ou mot de passe incorrect"));
            return null;
        }

        connecte = liste.get(0);

        return "vitrine?faces-redirect=true";
    }

    public String deconnecter() {
        FacesContext.getCurrentInstance()
                    .getExternalContext().invalidateSession();

        return "index?faces-redirect=true";
    }

    public Internaute getInternaute() {
        return internaute;
    }

    public Internaute getConnecte() {
        return connecte;
    }
}
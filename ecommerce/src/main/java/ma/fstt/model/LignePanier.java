package ma.fstt.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class LignePanier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantite;

    @ManyToOne
    private Produit produit;

    @ManyToOne
    private Panier panier;

    public LignePanier() {}

    public double getSousTotal() {
        return produit.getPrix() * quantite;
    }

    public Long getId() { return id; }
    public int getQuantite() { return quantite; }
    public Produit getProduit() { return produit; }

    public void setQuantite(int quantite) { this.quantite = quantite; }
    public void setProduit(Produit produit) { this.produit = produit; }
    public void setPanier(Panier panier) { this.panier = panier; }
}
package ma.fstt.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Produit implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String description;
    private double prix;
    private int stock;

    @ManyToOne
    private Categorie categorie;

    @ManyToOne
    private Vitrine vitrine;

    public Produit() {}

    public Long getId() { return id; }
    public String getNom() { return nom; }
    public String getDescription() { return description; }
    public double getPrix() { return prix; }
    public int getStock() { return stock; }

    public Categorie getCategorie() { return categorie; }
    public Vitrine getVitrine() { return vitrine; }

    public void setNom(String nom) { this.nom = nom; }
    public void setDescription(String description) { this.description = description; }
    public void setPrix(double prix) { this.prix = prix; }
    public void setStock(int stock) { this.stock = stock; }
    public void setCategorie(Categorie categorie) { this.categorie = categorie; }
    public void setVitrine(Vitrine vitrine) { this.vitrine = vitrine; }
}
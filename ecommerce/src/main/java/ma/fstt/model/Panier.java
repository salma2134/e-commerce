package ma.fstt.model;

import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

@Entity
public class Panier implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreation = new Date();

    @OneToMany(mappedBy = "panier", cascade = CascadeType.ALL,
               fetch = FetchType.EAGER)
    private List<LignePanier> lignes = new ArrayList<>();

    public Panier() {}

    public double getTotal() {
        double total = 0;

        for (LignePanier l : lignes) {
            total += l.getSousTotal();
        }

        return total;
    }

    public Long getId() { return id; }
    public Date getDateCreation() { return dateCreation; }
    public List<LignePanier> getLignes() { return lignes; }
}
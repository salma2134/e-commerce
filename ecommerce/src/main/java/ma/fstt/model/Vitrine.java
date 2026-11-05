package ma.fstt.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Vitrine implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titre;

    public Vitrine() {}

    public Long getId() { return id; }
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }
}
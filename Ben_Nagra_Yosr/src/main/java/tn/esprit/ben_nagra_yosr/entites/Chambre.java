package tn.esprit.ben_nagra_yosr.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter

@Entity
public class Chambre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idChambre;
    private Long numeroChambre ;
    @Enumerated(EnumType.STRING)
    private TypeChambre typeC ;

    @JsonIgnoreProperties ("chambres")
    @ManyToOne
    private Bloc blocchambre;
    @JsonIgnore
    @OneToMany
    private Set<Reservation> reservations;

}

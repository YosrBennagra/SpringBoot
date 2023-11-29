package tn.esprit.ben_nagra_yosr.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter

@Entity
public class Universite implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;
    @Column(unique = true) //tkhali nom unique
    private String nomUniversite;
    private String adresse;
    @JsonIgnore
    @OneToOne
    private Foyer foyer ;
}

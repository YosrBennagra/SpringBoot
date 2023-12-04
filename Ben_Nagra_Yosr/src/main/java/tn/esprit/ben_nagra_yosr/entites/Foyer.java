package tn.esprit.ben_nagra_yosr.entites;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;


@Getter
@Setter
@Entity

public class Foyer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;
    private String nomFoyer;
    private Long capaciteFoyer ;
    @JsonIgnore
    @OneToOne(mappedBy = "foyer")
    private Universite universite;

    @OneToMany(mappedBy = "foyer", fetch =FetchType.EAGER,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    @JsonIgnoreProperties ("foyer")
    private Set<Bloc> blocs;

}
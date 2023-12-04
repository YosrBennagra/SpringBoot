package tn.esprit.ben_nagra_yosr.entites;

import java.io.Serializable;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity

public class Bloc implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blocId;
    private String nomBloc;
    private Long capaciteBloc;

    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JsonIgnoreProperties ("blocs")
    private Foyer foyer;
    @JsonIgnore
    @OneToMany(mappedBy = "blocchambre", fetch =FetchType.EAGER,
            cascade ={CascadeType.PERSIST,CascadeType.REMOVE})
    private Set<Chambre> chambres;
}
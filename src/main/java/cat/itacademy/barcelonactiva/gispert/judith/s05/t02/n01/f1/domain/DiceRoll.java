package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "plays")
public class DiceRoll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDiceRoll;
    @Column(name = "dice1")
    private int dice1;
    @Column(name = "dice2")
    private int dice2;
    @ManyToOne
    @JoinColumn (name = "namePlayer")
    private Player player;

    public DiceRoll(){}
    public DiceRoll(Player player){
        this.player = player;
    }
}

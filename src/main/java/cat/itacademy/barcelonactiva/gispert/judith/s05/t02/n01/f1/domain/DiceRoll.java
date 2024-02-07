package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain;

import jakarta.persistence.*;

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

    public int getIdDiceRoll() {
        return idDiceRoll;
    }

    public int getDice1() {
        return dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public Player getPlayer() {
        return player;
    }

    public void setIdDiceRoll(int idDiceRoll) {
        this.idDiceRoll = idDiceRoll;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

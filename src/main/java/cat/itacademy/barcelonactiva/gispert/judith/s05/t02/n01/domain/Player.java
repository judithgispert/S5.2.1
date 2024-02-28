package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "players")
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;
    @Column(name = "name", length = 50)
    private String name;
    @Column(name = "date")
    private LocalDateTime registrationDate;

    @Column(name = "games won")
    private int gamesWon;
    @Column(name = "% won")
    private double percentageWon;
    @Column(name = "games lost")
    private int gamesLost;
    @Column(name = "% lost")
    private double percentageLost;
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DiceRoll> games;

    public Player(){
        this.registrationDate = LocalDateTime.now();
        games = new ArrayList<>();
    }
    public Player(String name){
        this.name = name;
        this.registrationDate = LocalDateTime.now();
        games = new ArrayList<>();
    }
}

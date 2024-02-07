package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "date", nullable = false)
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DiceRoll> games;

    public Player(){}
    public Player (String name){
        this.name = name;
        this.registrationDate = LocalDateTime.now();
        games = new ArrayList<>();
    }

    public int getIdPlayer() {return idPlayer;}
    public String getName() {return name;}
    public LocalDateTime getRegistrationDate() {return registrationDate;}
    public List<DiceRoll> getGames() {return games;}

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRegistrationDate(LocalDateTime registrationDate) {this.registrationDate = registrationDate;}
    public void setGames(List<DiceRoll> games) {
        this.games = games;
    }
}

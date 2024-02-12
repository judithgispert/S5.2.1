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
    private String password;
    @Column(name = "date", nullable = false)
    private LocalDateTime registrationDate;
    @Column(name = "games won")
    private int gamesWon;
    @Column(name = "% games won")
    private double percentageWon;
    @Column(name = "games lost")
    private int gamesLost;
    @Column(name = "% games lost")
    private double percentageLost;
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DiceRoll> games;

    public Player(){}
    public Player (String name, String password){
        this.name = name;
        this.password = password;
        this.registrationDate = LocalDateTime.now();
        games = new ArrayList<>();
    }

    public int getIdPlayer() {return idPlayer;}
    public String getName() {return name;}
    public String getPassword() {return password;}
    public LocalDateTime getRegistrationDate() {return registrationDate;}
    public List<DiceRoll> getGames() {return games;}
    public int getGamesWon() {
        return gamesWon;
    }
    public int getGamesLost() {
        return gamesLost;
    }
    public double getPercentageWon() {
        return percentageWon;
    }
    public double getPercentageLost() {
        return percentageLost;
    }

    public void setIdPlayer(int idPlayer) {
        this.idPlayer = idPlayer;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setRegistrationDate(LocalDateTime registrationDate) {this.registrationDate = registrationDate;}
    public void setGames(List<DiceRoll> games) {
        this.games = games;
    }
    public void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }
    public void setGamesLost(int gamesLost) {
        this.gamesLost = gamesLost;
    }
    public void setPercentageWon(double percentageWon) {
        this.percentageWon = percentageWon;
    }
    public void setPercentageLost(double percentageLost) {
        this.percentageLost = percentageLost;
    }
}

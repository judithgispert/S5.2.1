package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "players")
public class Player{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPlayer;
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Column(name = "date", nullable = false)
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
}

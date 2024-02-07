package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {
    private int idPlayer;
    private String name;
    private LocalDateTime registrationDate;
    private List<DiceRoll> games;

    public PlayerDTO(){}
    public PlayerDTO(String name){
        this.name = ""; //TODO method user not same name
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
    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
    public void setGames(List<DiceRoll> games) {
        this.games = games;
    }
}

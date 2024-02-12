package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {
    private int idPlayerDTO;
    private String nameDTO;
    private String passwordDTO;
    private LocalDateTime registrationDateDTO;
    private int gamesWonDTO;
    private double percentageWon;
    private int gamesLostDTO;
    private double percentageLost;
    private List<DiceRoll> gamesDTO;

    public PlayerDTO(){}
    public PlayerDTO(String nameDTO, String passwordDTO){
        this.nameDTO = nameDTO;
        this.passwordDTO = passwordDTO;
        this.registrationDateDTO = LocalDateTime.now();
        gamesDTO = new ArrayList<>();
    }

    public int getIdPlayerDTO() {return idPlayerDTO;}
    public String getNameDTO() {return nameDTO;}
    public String getPasswordDTO() {return passwordDTO;}
    public LocalDateTime getRegistrationDateDTO() {return registrationDateDTO;}
    public List<DiceRoll> getGamesDTO() {return gamesDTO;}
    public int getGamesWonDTO() {
        return gamesWonDTO;
    }
    public int getGamesLostDTO() {
        return gamesLostDTO;
    }
    public double getPercentageWon() {
        return percentageWon;
    }
    public double getPercentageLost() {
        return percentageLost;
    }

    public void setIdPlayerDTO(int idPlayerDTO) {
        this.idPlayerDTO = idPlayerDTO;
    }
    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }
    public void setPasswordDTO(String passwordDTO) {
        this.passwordDTO = passwordDTO;
    }
    public void setRegistrationDateDTO(LocalDateTime registrationDateDTO) {
        this.registrationDateDTO = registrationDateDTO;
    }
    public void setGamesDTO(List<DiceRoll> gamesDTO) {
        this.gamesDTO = gamesDTO;
    }
    public void setGamesWonDTO(int gamesWonDTO) {
        this.gamesWonDTO = gamesWonDTO;
    }
    public void setGamesLostDTO(int gamesLostDTO) {
        this.gamesLostDTO = gamesLostDTO;
    }
    public void setPercentageWon(double percentageWon) {
        this.percentageWon = percentageWon;
    }
    public void setPercentageLost(double percentageLost) {
        this.percentageLost = percentageLost;
    }
}

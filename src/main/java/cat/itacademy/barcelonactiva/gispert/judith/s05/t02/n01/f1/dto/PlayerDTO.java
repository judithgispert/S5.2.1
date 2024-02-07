package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PlayerDTO {
    private int idPlayerDTO;
    private String nameDTO;
    private LocalDateTime registrationDateDTO;
    private List<DiceRoll> gamesDTO;

    public PlayerDTO(){}
    public PlayerDTO(String nameDTO){
        this.nameDTO = ""; //TODO method user not same name
        this.registrationDateDTO = LocalDateTime.now();
        gamesDTO = new ArrayList<>();
    }

    public int getIdPlayerDTO() {return idPlayerDTO;}
    public String getNameDTO() {return nameDTO;}
    public LocalDateTime getRegistrationDateDTO() {return registrationDateDTO;}
    public List<DiceRoll> getGamesDTO() {return gamesDTO;}

    public void setIdPlayerDTO(int idPlayerDTO) {
        this.idPlayerDTO = idPlayerDTO;
    }
    public void setNameDTO(String nameDTO) {
        this.nameDTO = nameDTO;
    }
    public void setRegistrationDateDTO(LocalDateTime registrationDateDTO) {
        this.registrationDateDTO = registrationDateDTO;
    }
    public void setGamesDTO(List<DiceRoll> gamesDTO) {
        this.gamesDTO = gamesDTO;
    }
}

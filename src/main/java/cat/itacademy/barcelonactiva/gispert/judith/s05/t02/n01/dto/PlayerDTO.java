package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class PlayerDTO {
    private int idPlayerDTO;
    private String nameDTO;
    private LocalDateTime registrationDateDTO;
    private int gamesWonDTO;
    private double percentageWonDTO;
    private int gamesLostDTO;
    private double percentageLostDTO;
    private List<DiceRoll> gamesDTO;

    public PlayerDTO() {
        gamesDTO = new ArrayList<>();
    }

    public PlayerDTO(String nameDTO) {
        this.registrationDateDTO = LocalDateTime.now();
        this.nameDTO = nameDTO;
        gamesDTO = new ArrayList<>();
    }
}





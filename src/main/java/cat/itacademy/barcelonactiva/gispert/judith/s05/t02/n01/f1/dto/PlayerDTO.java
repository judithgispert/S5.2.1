package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;
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
    }
}





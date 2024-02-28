package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;

import java.util.List;

public interface IDiceRollService {
    DiceRollDTO addGame(Player player);
    List<DiceRollDTO> getGames(Player player);
    void deleteGames(Player player);
    DiceRoll dTOToDiceRoll(DiceRollDTO diceRollDTO, Player player);
    DiceRollDTO diceRollToDTO(DiceRoll diceRoll);
}

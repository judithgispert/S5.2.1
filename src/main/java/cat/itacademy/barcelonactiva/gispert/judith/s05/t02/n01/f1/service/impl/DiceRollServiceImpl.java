package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service.impl;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.repository.IDiceRollRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service.IDiceRollService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DiceRollServiceImpl implements IDiceRollService {
    @Autowired
    private IDiceRollRepository diceRollRepository;

    @Override
    public DiceRollDTO addGame(Player player) {
        DiceRollDTO diceRollDTO = new DiceRollDTO();
        DiceRoll diceRoll = dTOToDiceRoll(diceRollDTO, player);
        diceRollRepository.save(diceRoll);
        return diceRollDTO;
    }

    @Override
    public List<DiceRollDTO> getGames(Player player) {
        List<DiceRoll> gamesPlayer = player.getGames();
        return gamesPlayer.stream().map(DiceRollServiceImpl::diceRollToDTO).collect(Collectors.toList());
    }

    @Override
    public void deleteGames(Player player) {
        List<DiceRoll> games = player.getGames();
        games.forEach(games::remove);
    }

    private static DiceRoll dTOToDiceRoll(DiceRollDTO diceRollDTO, Player player){
        DiceRoll diceRoll = new DiceRoll(player);
        diceRoll.setIdDiceRoll(diceRollDTO.getIdDiceRoll());
        diceRoll.setDice1(diceRollDTO.getDice1());
        diceRoll.setDice2(diceRollDTO.getDice2());
        return diceRoll;
    }
    private static DiceRollDTO diceRollToDTO(DiceRoll diceRoll){
        DiceRollDTO diceRollDTO = new DiceRollDTO();
        diceRollDTO.setIdDiceRoll(diceRoll.getIdDiceRoll());
        diceRollDTO.setDice1(diceRoll.getDice1());
        diceRollDTO.setDice2(diceRoll.getDice2());
        diceRollDTO.setResultWin(diceRollDTO.winGame());
        return diceRollDTO;
    }
}

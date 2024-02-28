package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.repository.IDiceRollRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IDiceRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DiceRollServiceImpl implements IDiceRollService {
    @Autowired
    private IDiceRollRepository diceRollRepository;

    public DiceRollServiceImpl(IDiceRollRepository diceRollRepository) {
    }

    @Override
    public DiceRollDTO addGame(Player player) {
        DiceRollDTO diceRollDTO = new DiceRollDTO();
        DiceRoll diceRoll = dTOToDiceRoll(diceRollDTO, player);
        diceRollRepository.save(diceRoll);
        return diceRollDTO;
    }

    @Override
    public List<DiceRollDTO> getGames(Player player) {
        List<DiceRoll> gamesPlayer = diceRollRepository.findByPlayer(player);
        List<DiceRollDTO> gamesDTOPlayer = new ArrayList<>();
        gamesPlayer.stream().toList().forEach(l -> gamesDTOPlayer.add(diceRollToDTO(l)));
        return gamesDTOPlayer;
    }

    @Override
    public void deleteGames(Player player) {
        List<DiceRoll> games = diceRollRepository.findByPlayer(player);
        games.forEach(l -> diceRollRepository.delete(l));
    }

    @Override
    public DiceRoll dTOToDiceRoll(DiceRollDTO diceRollDTO, Player player){
        DiceRoll diceRoll = new DiceRoll(player);
        diceRoll.setIdDiceRoll(diceRollDTO.getIdDiceRoll());
        diceRoll.setDice1(diceRollDTO.getDice1());
        diceRoll.setDice2(diceRollDTO.getDice2());
        return diceRoll;
    }

    @Override
    public DiceRollDTO diceRollToDTO(DiceRoll diceRoll){
        DiceRollDTO diceRollDTO = new DiceRollDTO();
        diceRollDTO.setIdDiceRoll(diceRoll.getIdDiceRoll());
        diceRollDTO.setDice1(diceRoll.getDice1());
        diceRollDTO.setDice2(diceRoll.getDice2());
        diceRollDTO.setResultWin(diceRollDTO.winGame());
        return diceRollDTO;
    }
}

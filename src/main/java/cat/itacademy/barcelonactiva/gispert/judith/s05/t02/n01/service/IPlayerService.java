package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.User;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;

import java.util.List;

public interface IPlayerService {
    void addPlayer(PlayerDTO playerDTO);
    PlayerDTO getPlayerById(int id);
    List<Player> getPlayers();
    PlayerDTO updatePlayer(PlayerDTO newPlayerDTO, int id);
    void deletePlayer(int id);

    void updateResultGames(DiceRollDTO diceRollDTO, PlayerDTO playerDTO);
    DiceRollDTO play(int id);
    List<DiceRollDTO> getGames(int id);
    void deleteGames(int id);
    PlayerDTO restartPercentage(PlayerDTO playerDTO);
    List<PlayerDTO> getRanking();
    double getPercentageRanking();
    PlayerDTO getLoser();
    PlayerDTO getWinner();
}

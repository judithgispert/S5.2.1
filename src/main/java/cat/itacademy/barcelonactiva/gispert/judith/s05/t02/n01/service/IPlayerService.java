package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.User;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;

import java.util.List;

public interface IPlayerService {
    public void addPlayer(User user);
    public PlayerDTO getPlayerById(int id);
    public List<Player> getPlayers();
    public PlayerDTO updatePlayer(PlayerDTO newPlayerDTO, int id);
    public void deletePlayer(int id);

    public void updateResultGames(DiceRollDTO diceRollDTO, PlayerDTO playerDTO);
    public DiceRollDTO play(int id);
    List<DiceRollDTO> getGames(int id);
    void deleteGames(int id);
    PlayerDTO restartPercentage(PlayerDTO playerDTO);
    List<PlayerDTO> getRanking();
    public double getPercentageRanking();
    public PlayerDTO getLoser();
    public PlayerDTO getWinner();
}

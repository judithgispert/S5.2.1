package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.DiceRoll;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.PlayerDTO;

import java.util.List;

public interface IPlayerService {
    public void addPlayer(PlayerDTO playerDTO);
    public PlayerDTO getPlayerById(int id);
    public List<PlayerDTO> getPlayers();
    public PlayerDTO updatePlayer(PlayerDTO newPlayerDTO, int id);
    public void deletePlayer(int id);

    public void updateResultGames(DiceRollDTO diceRollDTO, Player player);
    public DiceRollDTO play(int id);
    List<DiceRollDTO> getGames(int id);
}

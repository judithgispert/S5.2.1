package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.PlayerDTO;

import java.util.List;

public interface IPlayerService {
    public void createPlayer(PlayerDTO playerDTO);
    public PlayerDTO getPlayerById(int id);
    public List<PlayerDTO> getPlayers();
    public PlayerDTO updatePlayer(PlayerDTO newPlayerDTO, int id);
    public void deletePlayer(int id);
}

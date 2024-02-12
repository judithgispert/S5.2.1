package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service.impl;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.exceptions.RepeatedValueException;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.repository.IPlayerRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.service.IPlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;
    private DiceRollServiceImpl diceRollService;

    @Override
    public void addPlayer(PlayerDTO playerDTO) {
        if(playerDTO.getNameDTO().isEmpty()||playerDTO.getNameDTO().isBlank()){
            playerDTO.setNameDTO("ANONYMOUS");
            Player player = playerDTOToPlayer(playerDTO);
            playerRepository.save(player);
        } else {
            Player player = playerDTOToPlayer(playerDTO);
            Optional<Player> playerName = playerRepository.findByName(player.getName());
            if (playerName.isPresent()){
                throw new RepeatedValueException("This name already exist.");
            } else {
                playerRepository.save(player);
            }
        }
    }

    @Override
    public PlayerDTO getPlayerById(int id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            return playerToPlayerDTO(player.get());
        } else {
            throw new PlayerNotFoundException("The id: " + id + ", doesn't correspond to any player.");
        }
    }

    @Override
    public List<PlayerDTO> getPlayers() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDTO> playersDTO = new ArrayList<>();
        for (Player player : players){
            playersDTO.add(playerToPlayerDTO(player));
        }
        return playersDTO;
    }

    @Override
    public PlayerDTO updatePlayer(PlayerDTO newPlayerDTO, int id) {
        Player newPlayer = playerDTOToPlayer(newPlayerDTO);
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            Player updatedPlayer = player.get();
            if(newPlayerDTO.getNameDTO().isEmpty()||newPlayerDTO.getNameDTO().isBlank()){
                updatedPlayer.setName("ANONYMOUS");
            } else {
                Optional<Player> playerName = playerRepository.findByName(newPlayer.getName());
                if (playerName.isPresent()){
                    throw new RepeatedValueException("This name already exist.");
                } else {
                    updatedPlayer.setName(newPlayer.getName());
                }
            }
            updatedPlayer.setPassword(newPlayer.getPassword());
            playerRepository.save(updatedPlayer);
            return playerToPlayerDTO(updatedPlayer);
        } else {
            throw new PlayerNotFoundException("The id: " + id + ", doesn't correspond to any player.");
        }
    }

    @Override
    public void deletePlayer(int id) {
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            playerRepository.deleteById(id);
        } else {
            throw new PlayerNotFoundException("The id: " + id + ", doesn't correspond to any player.");
        }
    }

    @Override
    public void updateResultGames(DiceRollDTO diceRollDTO, Player player){
        if(diceRollDTO.winGame()){
            player.setGamesWon(player.getGamesWon()+1);
            double resultPercentageWon = ((double) player.getGamesWon() / player.getGames().size())*100;
            player.setPercentageWon(resultPercentageWon);
            playerRepository.save(player);
        } else {
            player.setGamesLost(player.getGamesLost()+1);
            double resultPercentageLost = ((double) player.getGamesWon() / player.getGamesLost())*100;
            player.setPercentageLost(resultPercentageLost);
            playerRepository.save(player);
        }
    }

    @Override
    public DiceRollDTO play(int id){
        PlayerDTO playerDTO = getPlayerById(id);
        Player player = playerDTOToPlayer(playerDTO);
        DiceRollDTO diceRollDTO = diceRollService.addGame(player);
        updateResultGames(diceRollDTO, player);
        return diceRollDTO;
    }

    @Override
    public List<DiceRollDTO> getGames(int id) {
        PlayerDTO playerDTO = getPlayerById(id);
        Player player = playerDTOToPlayer(playerDTO);
        return diceRollService.getGames(player);
    }

    private static Player playerDTOToPlayer(PlayerDTO playerDTO){
        Player player = new Player();
        player.setIdPlayer(playerDTO.getIdPlayerDTO());
        player.setName(playerDTO.getNameDTO());
        player.setPassword(playerDTO.getPasswordDTO());
        player.setRegistrationDate(playerDTO.getRegistrationDateDTO());
        player.setGames(playerDTO.getGamesDTO());
        player.setGamesWon(playerDTO.getGamesWonDTO());
        player.setGamesLost(playerDTO.getGamesLostDTO());
        player.setPercentageWon(playerDTO.getPercentageWon());
        player.setPercentageLost(playerDTO.getPercentageLost());
        return player;
    }

    private static PlayerDTO playerToPlayerDTO(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setIdPlayerDTO(player.getIdPlayer());
        playerDTO.setNameDTO(player.getName());
        playerDTO.setPasswordDTO(player.getPassword());
        playerDTO.setRegistrationDateDTO(player.getRegistrationDate());
        playerDTO.setGamesDTO(player.getGames());
        playerDTO.setGamesWonDTO(player.getGamesWon());
        playerDTO.setGamesLostDTO(player.getGamesLost());
        playerDTO.setPercentageWon(player.getPercentageWon());
        playerDTO.setPercentageLost(player.getPercentageLost());
        return playerDTO;
    }
}

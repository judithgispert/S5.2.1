package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.User;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.DiceRollDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions.DiceRollNotFoundException;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.exceptions.RepeatedValueException;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.repository.IPlayerRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IDiceRollService;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IPlayerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements IPlayerService {
    @Autowired
    private IPlayerRepository playerRepository;
    @Autowired
    private DiceRollServiceImpl diceRollService;

    public PlayerServiceImpl(IPlayerRepository playerRepository, DiceRollServiceImpl diceRollService) {
        this.playerRepository = playerRepository;
        this.diceRollService = diceRollService;
    }

    public PlayerDTO createPlayer(String nameDTO){
        return new PlayerDTO(nameDTO);
    }
    @Override
    public void addPlayer(String nameDTO) {
        PlayerDTO playerDTO = createPlayer(nameDTO);
        Player player = playerDTOToPlayer(playerDTO);
        if(playerDTO.getNameDTO() == null||playerDTO.getNameDTO().isEmpty()||playerDTO.getNameDTO().isBlank()){
            playerDTO.setNameDTO("ANONYMOUS");
            playerRepository.save(player);
        } else {
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
    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    @Override
    public PlayerDTO updatePlayer(PlayerDTO newPlayerDTO, int id) {
        Player newPlayer = playerDTOToPlayer(newPlayerDTO);
        Optional<Player> player = playerRepository.findById(id);
        if(player.isPresent()){
            Player updatedPlayer = player.get();
            if(newPlayerDTO.getNameDTO() == null||newPlayerDTO.getNameDTO().isEmpty()||newPlayerDTO.getNameDTO().isBlank()){
                updatedPlayer.setName("ANONYMOUS");
            } else {
                Optional<Player> playerName = playerRepository.findByName(newPlayer.getName());
                if (playerName.isPresent()){
                    throw new RepeatedValueException("This name already exist.");
                } else {
                    updatedPlayer.setName(newPlayer.getName());
                }
            }
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
    public DiceRollDTO play(int id){
        Optional<Player> playerSearch = playerRepository.findById(id);
        if(playerSearch.isPresent()){
            Player player = playerSearch.get();
            DiceRollDTO diceRollDTO = diceRollService.addGame(player);
            updateResultGames(diceRollDTO, playerToPlayerDTO(player));
            return diceRollDTO;
        } else {
            throw new PlayerNotFoundException("The id: " + id + ", doesn't correspond to any player.");
        }
    }

    @Override
    public List<DiceRollDTO> getGames(int id) {
        Optional<Player> playerSearch = playerRepository.findById(id);
        if(playerSearch.isPresent()){
            Player player = playerSearch.get();
            return diceRollService.getGames(player);
        } else {
            throw new PlayerNotFoundException("The id: " + id + ", doesn't correspond to any player.");
        }
    }

    @Override
    public void deleteGames(int id){
        Optional<Player> playerSearch = playerRepository.findById(id);
        if(playerSearch.isPresent()){
            Player player = playerSearch.get();
            diceRollService.deleteGames(player);
            PlayerDTO playerDTO = restartPercentage(playerToPlayerDTO(player));
            playerRepository.save(playerDTOToPlayer(playerDTO));
        } else {
            throw new PlayerNotFoundException("The id: " + id + ", doesn't correspond to any player.");
        }
    }

    @Override
    public PlayerDTO restartPercentage(PlayerDTO playerDTO){
        playerDTO.setPercentageLostDTO(0);
        playerDTO.setPercentageWonDTO(0);
        playerDTO.setGamesLostDTO(0);
        playerDTO.setGamesWonDTO(0);
        return playerDTO;
    }

    @Override
    public void updateResultGames(DiceRollDTO diceRollDTO, PlayerDTO playerDTO){
        if(diceRollDTO.winGame()){
            playerDTO.setGamesWonDTO(playerDTO.getGamesWonDTO()+1);
            double resultPercentageWon = ((double) playerDTO.getGamesWonDTO() / playerDTO.getGamesDTO().size())*100;
            playerDTO.setPercentageWonDTO(resultPercentageWon);
            playerRepository.save(playerDTOToPlayer(playerDTO));
        } else {
            playerDTO.setGamesLostDTO(playerDTO.getGamesLostDTO()+1);
            double resultPercentageLost = (100 - playerDTO.getPercentageWonDTO());
            playerDTO.setPercentageLostDTO(resultPercentageLost);
            playerRepository.save(playerDTOToPlayer(playerDTO));
        }
    }

    @Override
    public List<PlayerDTO> getRanking(){
        List<Player> players = playerRepository.findAll();
        List<PlayerDTO> playersRanking = new ArrayList<>();
        players.stream().toList().forEach(l -> playersRanking.add(playerToPlayerDTO(l)));
        playersRanking.sort(Comparator.comparing(PlayerDTO::getPercentageWonDTO));
        if(playersRanking.isEmpty()){
            throw new DiceRollNotFoundException("No games played.");
        }
        return playersRanking;
    }

    @Override
    public double getPercentageRanking(){
        List <Player> players = playerRepository.findAll();
        List<PlayerDTO> playersDTO = new ArrayList<>();
        players.stream().toList().forEach(l -> playersDTO.add(playerToPlayerDTO(l)));
        return (playersDTO.stream().mapToDouble(PlayerDTO::getPercentageWonDTO).sum())/players.size();
    }

    @Override
    public PlayerDTO getLoser(){
        return getRanking().stream().toList().get(getRanking().size()-1);
    }

    @Override
    public PlayerDTO getWinner(){
        return getRanking().stream().toList().get(0);
    }

    private Player playerDTOToPlayer(PlayerDTO playerDTO){
        Player player = new Player();
        player.setIdPlayer(playerDTO.getIdPlayerDTO());
        player.setName(playerDTO.getNameDTO());
        player.setRegistrationDate(playerDTO.getRegistrationDateDTO());
        player.setGames(playerDTO.getGamesDTO());
        player.setGamesWon(playerDTO.getGamesWonDTO());
        player.setGamesLost(playerDTO.getGamesLostDTO());
        player.setPercentageWon(playerDTO.getPercentageWonDTO());
        player.setPercentageLost(playerDTO.getPercentageLostDTO());
        return player;
    }

    private PlayerDTO playerToPlayerDTO(Player player){
        PlayerDTO playerDTO = new PlayerDTO();
        playerDTO.setIdPlayerDTO(player.getIdPlayer());
        playerDTO.setNameDTO(player.getName());
        playerDTO.setRegistrationDateDTO(player.getRegistrationDate());
        playerDTO.setGamesDTO(player.getGames());
        playerDTO.setGamesWonDTO(player.getGamesWon());
        playerDTO.setGamesLostDTO(player.getGamesLost());
        playerDTO.setPercentageWonDTO(player.getPercentageWon());
        playerDTO.setPercentageLostDTO(player.getPercentageLost());
        return playerDTO;
    }
}

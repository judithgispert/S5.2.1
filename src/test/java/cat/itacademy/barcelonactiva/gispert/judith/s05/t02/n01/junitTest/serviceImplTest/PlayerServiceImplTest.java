package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.junitTest.serviceImplTest;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.repository.IPlayerRepository;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.IPlayerService;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl.DiceRollServiceImpl;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.service.impl.PlayerServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PlayerServiceImplTest {
    @Mock
    private DiceRollServiceImpl diceRollService;
    @Mock
    private IPlayerRepository playerRepository;

    @InjectMocks
    private IPlayerService playerService = new PlayerServiceImpl(playerRepository, diceRollService);

/*
    @DisplayName("Create player test")
    @Test

    @DisplayName("Add player test")
    @Test

    @DisplayName("Get players test")
    @Test

    @DisplayName("Update player test")
    @Test

    @DisplayName("Delete player test")
    @Test

    @DisplayName("Add game/play test")
    @Test

    @DisplayName("Get games test")
    @Test

    @DisplayName("Delete games test")
    @Test

    @DisplayName("Restart percentage test")
    @Test

    @DisplayName("Update results test")
    @Test

    @DisplayName("Get ranking test")
    @Test

    @DisplayName("Get percentage ranking test")
    @Test

    @DisplayName("Get loser test")
    @Test

    @DisplayName("Get winner test")
    @Test
*/
}

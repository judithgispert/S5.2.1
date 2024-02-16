package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.repositoryTest;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.domain.Player;
import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.f1.repository.IPlayerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
/*@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class IPlayerRepositoryTest {
    @Autowired
    private IPlayerRepository IPlayerRepository;

    @Test
    public void testCreatePlayer(){
        Player playerSaved = IPlayerRepository.save(new Player("Judith"));
        assertThat(playerSaved.getIdPlayer()).isGreaterThan(0);
        //If id > 0 = player is saved
    }
}*/

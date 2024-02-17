package cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.repository;

import cat.itacademy.barcelonactiva.gispert.judith.s05.t02.n01.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}

package iitu.kz.demo.repository;

import iitu.kz.demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByName(String name);
    List<User> findByNameAndAgeGreaterThanEqual(String name, int i);

    @Query(value = "select firstname from User firstname where firstname.firstname=:firstname")
    List<User> findByNameGreaterThan(@Param("firstname") String firstname, int i);
}

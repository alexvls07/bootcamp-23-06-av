package bootcamp2306_av.repositories;

import bootcamp2306_av.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.users WHERE email = ?")
    public User findByEmail(String email);


    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.users WHERE email = ?")
    public Optional<User> findOptionalByEmail(String email);

}

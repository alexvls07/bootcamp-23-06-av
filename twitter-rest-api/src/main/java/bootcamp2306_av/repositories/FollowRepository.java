package bootcamp2306_av.repositories;

import bootcamp2306_av.models.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowRepository extends JpaRepository<Follow, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.follow WHERE follow_id = ?")
    public Follow findByfollow_id(Long follow_id);
}

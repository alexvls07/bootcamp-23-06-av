package bootcamp2306_av.repositories;

import bootcamp2306_av.models.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RetweetRepository extends JpaRepository<Retweet, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.retweets WHERE retweet_id = ?")
    public Retweet findByretweet_id(Long retweet_id);

}

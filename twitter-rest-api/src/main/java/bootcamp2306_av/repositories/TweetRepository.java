package bootcamp2306_av.repositories;

import bootcamp2306_av.models.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.tweets WHERE tweet_id = ?")
    public Tweet findBytweet_id(Long tweet_id);

}
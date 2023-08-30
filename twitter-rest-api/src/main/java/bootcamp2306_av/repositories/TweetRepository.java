package bootcamp2306_av.repositories;

import bootcamp2306_av.models.entities.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.tweets WHERE tweet_id = ?")
    public Tweet findByTweetId(Long tweet_id);
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.tweets WHERE user_id = ?")
    public List<Tweet> findByUserId(Long tweet_id);
}
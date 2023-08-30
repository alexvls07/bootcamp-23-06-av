package bootcamp2306_av.services;

import bootcamp2306_av.models.entities.Tweet;
import bootcamp2306_av.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    @Autowired
    private TweetRepository tweetRepository;

    public List<Tweet> getAllTweets() {
        //
        //
        return tweetRepository.findAll();
    }

    public Tweet getTweetById(Long tweet_id) throws Exception {

        return tweetRepository.findById(tweet_id)
                .orElseThrow(() -> new Exception("Tweet not exists with id" + tweet_id));
    }

    public List<Tweet> getTweetsByUserId(Long userId) throws Exception {

        return tweetRepository.findByUserId(userId);
    }

    public Tweet createTweet(Tweet tweet) throws Exception {

        Tweet tweetInDB = tweetRepository.findByTweetId(tweet.getTweetId());

        if (tweetInDB != null) {
            throw new Exception("Tweet with id " + tweet.getTweetId() + " already exists");
        }
    return tweetRepository.save(tweet);
    }
    public Tweet updateTweet(Tweet tweet) throws Exception {

        Tweet tweetInDB = this.getTweetById(tweet.getTweetId());
        tweetInDB.setUserId(tweet.getTweetId());
        return tweetRepository.save(tweet);
    }
    public void deleteTweet(Long tweet_id) {
        tweetRepository.deleteById(tweet_id);
    }


}

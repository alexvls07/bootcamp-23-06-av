package bootcamp2306_av.controllers;

import bootcamp2306_av.models.Tweet;
import bootcamp2306_av.services.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {
    @Autowired
    private TweetService tweetService;

    @GetMapping("/tweet")
    public List<Tweet> getAll() {

        // run code to get the user from the database
        return tweetService.getAllTweets();
    }



    @GetMapping("/tweet/{tweet_id}")
    public Tweet getById(@PathVariable("tweet_id") Long id) throws Exception {
        return tweetService.getTweetById(id);
    }

    @PostMapping("/tweet")
    public Tweet createTweet(@RequestBody Tweet tweet) throws Exception {
        tweet = tweetService.createTweet(tweet);
        return tweet;
    }

    @PutMapping("/tweet/{tweet_id}")
    public Tweet updateTweet(@PathVariable Long tweet_id, @RequestBody Tweet tweet) throws Exception {

        if (!tweet_id.equals(tweet.getTweetId())) {
            throw new Exception("Id in path and id in body are not the same");
        }
        tweet = tweetService.updateTweet(tweet);

        return tweet;
    }

    @DeleteMapping("/tweet/{tweet_id}")
    public void deleteTweet(@PathVariable Long tweet_id) {

        tweetService.deleteTweet(tweet_id);

    }
}

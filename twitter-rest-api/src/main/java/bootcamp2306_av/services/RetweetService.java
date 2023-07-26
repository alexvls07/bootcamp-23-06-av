package bootcamp2306_av.services;

import bootcamp2306_av.models.Retweet;
import bootcamp2306_av.repositories.RetweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetweetService {
    @Autowired
    private RetweetRepository retweetRepository;

    public List<Retweet> getAllRetweets() {
        //
        //
        return retweetRepository.findAll();
    }

    public Retweet getRetweetById(Long retweet_id) throws Exception {

        return retweetRepository.findById(retweet_id)
                .orElseThrow(() -> new Exception("Retweet not exists with id" + retweet_id));
    }

    public Retweet createRetweet(Retweet retweet) throws Exception {

        Retweet tweetInDB = retweetRepository.findByretweet_id(retweet.getTweetId());

        if (tweetInDB != null) {
            throw new Exception("Retweet with id " + retweet.getRetweetId() + " already exists");
        }
        return retweetRepository.save(retweet);
    }
    public Retweet updateRetweet(Retweet retweet) throws Exception {

        Retweet retweetInDB = this.getRetweetById(retweet.getRetweetId());
        retweetInDB.setUserId(retweet.getRetweetId());
        return retweetRepository.save(retweet);
    }
    public void deleteRetweet(Long tweet_id) {
        retweetRepository.deleteById(tweet_id);
    }


}

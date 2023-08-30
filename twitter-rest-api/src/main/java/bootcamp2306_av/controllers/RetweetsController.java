package bootcamp2306_av.controllers;

import bootcamp2306_av.models.entities.Retweet;
import bootcamp2306_av.services.RetweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RetweetsController {
    @Autowired
    private RetweetService retweetService;

    @GetMapping("/retweet")
    public List<Retweet> getAll() {

        // run code to get the user from the database
        return retweetService.getAllRetweets();
    }



    @GetMapping("/retweet/{retweet_id}")
    public Retweet getById(@PathVariable("retweet_id") Long id) throws Exception {
        return retweetService.getRetweetById(id);
    }

    @PostMapping("/retweet")
    public Retweet createRetweet(@RequestBody Retweet retweet) throws Exception {
        retweet = retweetService.createRetweet(retweet);
        return retweet;
    }

    @PutMapping("/retweet/{retweet_id}")
    public Retweet updateRetweet(@PathVariable Long retweet_id, @RequestBody Retweet retweet) throws Exception {

        if (!retweet_id.equals(retweet.getRetweetId())) {
            throw new Exception("Id in path and id in body are not the same");
        }
        retweet = retweetService.updateRetweet(retweet);

        return retweet;
    }

    @DeleteMapping("/retweet/{retweet_id}")
    public void deleteRetweet(@PathVariable Long retweet_id) {

        retweetService.deleteRetweet(retweet_id);

    }
}
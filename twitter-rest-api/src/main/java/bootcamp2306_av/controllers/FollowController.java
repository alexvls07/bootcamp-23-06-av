package bootcamp2306_av.controllers;

import bootcamp2306_av.models.entities.Follow;
import bootcamp2306_av.services.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FollowController {


    @Autowired
    private FollowService followService;


    @GetMapping("/follow")
    public List<Follow> getAll() {

        // run code to get the user from the database
        return followService.getAllFollows();
    }

    @GetMapping("/follow/{follow_id}")
    public Follow getById(@PathVariable("follow_id") Long id) throws Exception {
        return followService.getFollowById(id);
    }

    @PostMapping("/follow")
    public Follow createFollow(@RequestBody Follow follow) throws Exception {
        follow = followService.createFollow(follow);
        return follow;
    }

   /* @PutMapping("/follow/{id}")
    public Follow updateFollow(@PathVariable Long id, @RequestBody Follow follow) throws Exception {

        if (!id.equals(follow.getFollowId())) {
            throw new Exception("Id in path and id in body are not the same");
        }
        follow = followService.updateFollow(follow);

        return follow;
    }
    */

    @DeleteMapping("/follow/{follow_id}")
    public void deleteFollow(@PathVariable Long follow_id) {

        followService.deleteFollow(follow_id);

    }
}



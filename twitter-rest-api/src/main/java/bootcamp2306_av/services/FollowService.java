package bootcamp2306_av.services;

import bootcamp2306_av.models.entities.Follow;
import bootcamp2306_av.repositories.FollowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowService {
    @Autowired
    private FollowRepository followRepository;

    public List<Follow> getAllFollows() {
        //
        //
        return followRepository.findAll();
    }

    public Follow getFollowById(Long id) throws Exception {

        return followRepository.findById(id)
                .orElseThrow(() -> new Exception("Follow not exists with id" + id));
    }

    public Follow createFollow(Follow follow) throws Exception {

        Follow followInDB = followRepository.findByfollow_id(follow.getFollowId());

        if (followInDB != null) {
            throw new Exception("Follower with id " + followInDB.getFollowId() +" already exists");
        }

        return followRepository.save(follow);
    }
   /* public Follow updateFollow(Follow follow) throws Exception {

        Follow followInDB = this.getFollowById(follow.getFollowId());
        followInDB.setTwId(follow.getTwId());
        followInDB.setFollowId(follow.getFollowId());

        return followRepository.save(follow);
    }
    */
    public void deleteFollow(Long id) {
        followRepository.deleteById(id);
    }
}

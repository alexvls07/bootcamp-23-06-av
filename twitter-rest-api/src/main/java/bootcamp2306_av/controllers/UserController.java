package bootcamp2306_av.controllers;

import bootcamp2306_av.exceptions.RestAppException;
import bootcamp2306_av.models.dtos.UserDetailsDTO;
import bootcamp2306_av.models.entities.Tweet;
import bootcamp2306_av.models.entities.User;
import bootcamp2306_av.services.TweetService;
import bootcamp2306_av.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);


    private UserService userService;

    private TweetService tweetService;

    @Autowired
    public UserController(UserService userService, TweetService tweetService) {
        this.tweetService = tweetService;
        this.userService = userService;
    }


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }


    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/user")
    public List<User> getAll() {

        // run code to get the user from the database
        return userService.getAllUsers();
    }

    /**
     * jhggfjfgf
     *
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/user/{id}")
    public User getById(@PathVariable Long id, Authentication authentication) throws Exception {
        return userService.getUserById(id);
    }
    @GetMapping("/user/{user_id}/tweets")
    public List<Tweet> getByUserId(@PathVariable("user_id") Long userId) throws Exception {
        return tweetService.getTweetsByUserId(userId);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) throws Exception {
        user = userService.createUser(user);
        return user;
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user, Authentication authentication) throws Exception {

        isTheSameUserOrAdmin(id.longValue(), authentication);

        if (!id.equals(user.getId())) {
            throw new RestAppException("USER_UPDATE_ERROR", "Id in path and id in body are not the same", HttpStatus.BAD_REQUEST);
        }
        user = userService.updateUser(user);

        return user;
    }

    @DeleteMapping("/user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

    }


    private boolean isTheSameUserOrAdmin(Long userId, Authentication authentication) throws RestAppException {
        User authUser = (User) ((UserDetailsDTO) authentication.getPrincipal()).getUser();
        if (!(userId.equals(authUser.getId())
//                authUser.getRole().equals("ADMIN")
        )) {
            throw new RestAppException("USER_NOT_AUTHORIZED", "User is not authorized to update this user", HttpStatus.UNAUTHORIZED);
        }

        return true;
    }

}

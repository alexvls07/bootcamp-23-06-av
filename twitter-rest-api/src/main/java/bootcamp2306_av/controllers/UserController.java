package bootcamp2306_av.controllers;

import bootcamp2306_av.exceptions.RestAppException;
import bootcamp2306_av.models.User;
import bootcamp2306_av.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/user")
    public List<User> getAll() {

        // run code to get the user from the database
        return userService.getAllUsers();
    }

    /**
     * jhggfjfgf
     * @param id
     * @return
     * @throws Exception
     */
    @GetMapping("/user/{id}")
    public User getById(@PathVariable("id") Long id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user) throws Exception {
        user = userService.createUser(user);
        return user;
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) throws Exception {

        if (!id.equals(user.getId())) {
            throw new RestAppException("USER_UPDATE_ERROR", "Id in path and id in body are not the same", HttpStatus.BAD_REQUEST);
        }
        user = userService.updateUser(user);

        return user;
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

    }
}

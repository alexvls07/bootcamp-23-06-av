package bootcamp2306_av.services;

import bootcamp2306_av.exceptions.RestAppException;
import bootcamp2306_av.models.dtos.UserDetailsDTO;
import bootcamp2306_av.models.entities.User;
import bootcamp2306_av.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


    private UserRepository userRepository;


    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        //
        //
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Exception {

        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not exists with id" + id));
    }

    public User getUserByEmail(String email) throws Exception {

        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RestAppException("USER_NOT_FOUND", "User not exists with email: " + email, HttpStatus.NOT_FOUND);
        }

        return user;

//        return userRepository.findOptionalByEmail(email)
//                .orElseThrow(() -> new RestAppException("USER_NOT_FOUND", "User not exists with email: " + email, HttpStatus.NOT_FOUND));

    }

    public User createUser(User user) throws Exception {

        User userInDB = userRepository.findByEmail(user.getEmail());

        if (userInDB != null) {
            throw new Exception("User with email " + user.getEmail() +" already exists");
        }

        return userRepository.save(user);
    }
    public User updateUser(User user) throws Exception {

        User userInDB = this.getUserById(user.getId());
        userInDB.setEmail(user.getEmail());
        userInDB.setName(user.getName());
        userInDB.setAge(user.getAge());
        userInDB.setPassword(user.getPassword());

        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userToBeLoggedIn = null;
        try {
            userToBeLoggedIn = this.getUserByEmail(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("User not found", e);
        }

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO(userToBeLoggedIn);

        return userDetailsDTO;
    }


}

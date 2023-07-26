package bootcamp2306_av.services;

import bootcamp2306_av.models.User;
import bootcamp2306_av.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        //
        //
        return userRepository.findAll();
    }

    public User getUserById(Long id) throws Exception {

        return userRepository.findById(id)
                .orElseThrow(() -> new Exception("User not exists with id" + id));
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
}

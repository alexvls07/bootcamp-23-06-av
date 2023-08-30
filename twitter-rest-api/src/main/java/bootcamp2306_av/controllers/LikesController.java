package bootcamp2306_av.controllers;

import bootcamp2306_av.models.entities.Likes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LikesController {
    @GetMapping("/likes")

    public List<Likes> getAll() {

        // run code to get the user from the database
        return null;
//        return CommentsService.getAllUsers();
    }
}
package bootcamp2306_av.controllers;

import bootcamp2306_av.models.Comment;
import bootcamp2306_av.services.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class CommentController {

    @Autowired
    private CommentsService commentsService;

    @GetMapping("/comments")

    public List<Comment> getAll() {

        // run code to get the user from the database
        return null;
//        return CommentsService.getAllComments();
    }

    @GetMapping("/comments/{comment_id}")
    public Comment getById(@PathVariable("comment_id") Long comment_id) throws Exception {
        return commentsService.getCommentById(comment_id);
    }

    @PostMapping("/comments")
    public Comment createComment(@RequestBody Comment comments) throws Exception {
        comments = commentsService.createComment(comments);
        return comments;
    }

    @PutMapping("/comments/{comment_id}")
    public Comment updateComment(@PathVariable Long comment_id, @RequestBody Comment comment) throws Exception {

        if (!comment_id.equals(comment.getCommentId())) {
            throw new Exception("Id in path and id in body are not the same");
        }
        comment = commentsService.updateComment(comment);

        return comment;
    }

    @DeleteMapping("/comments/{comment_id}")
    public void deleteComment(@PathVariable Long comment_id) {

        commentsService.deleteComment(comment_id);

    }
}



package bootcamp2306_av.services;

import bootcamp2306_av.models.Comment;
import bootcamp2306_av.repositories.CommentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentsService {

    @Autowired
    private CommentsRepository commentsRepository;

    public List<Comment> getAllComments() {
        //
        //
        return commentsRepository.findAll();
    }

    public Comment getCommentById(Long comment_id) throws Exception {

        return commentsRepository.findById(comment_id)
                .orElseThrow(() -> new Exception("Comment does not exists with id" + comment_id));
    }

    public Comment createComment(Comment comment) throws Exception {

        Comment commentInDB = commentsRepository.findByComment_id(comment.getCommentId());

        if (commentInDB != null) {
            throw new Exception("Comment with id " + comment.getCommentId() +" already exists");
        }

        return commentsRepository.save(comment);
    }
    public Comment updateComment(Comment comment) throws Exception {

        Comment commentInDB = this.getCommentById(comment.getCommentId());
        commentInDB.setUserId(comment.getTweetId());
        return commentsRepository.save(comment);
    }

    public void deleteComment(Long comment_id) {
        commentsRepository.deleteById(comment_id);
    }
}
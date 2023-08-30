package bootcamp2306_av.models.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "comments", schema = "bootcamp2306_av")
public class Comment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "comment_id", nullable = false, length = 255)
    private Long commentId;


    @Basic
    @Column(name = "comment_text", nullable = false)
    private String commentText;
    @Basic
    @Column(name = "tweet_id", nullable = false)
    private Long tweetId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId) && Objects.equals(commentText, comment.commentText) && Objects.equals(tweetId, comment.tweetId) && Objects.equals(userId, comment.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId, commentText, tweetId, userId);
    }
}

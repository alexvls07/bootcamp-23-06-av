package bootcamp2306_av.models.entities;

import jakarta.persistence.*;

@Entity
public class Likes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "like_id", nullable = false)
    private Long likeId;
    @Basic
    @Column(name = "tweet_id", nullable = false)
    private Long tweetId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    public Long getLikeId() {
        return likeId;
    }

    public void setLikeId(Long likeId) {
        this.likeId = likeId;
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

        Likes likes = (Likes) o;

        if (likeId != null ? !likeId.equals(likes.likeId) : likes.likeId != null) return false;
        if (tweetId != null ? !tweetId.equals(likes.tweetId) : likes.tweetId != null) return false;
        if (userId != null ? !userId.equals(likes.userId) : likes.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = likeId != null ? likeId.hashCode() : 0;
        result = 31 * result + (tweetId != null ? tweetId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}

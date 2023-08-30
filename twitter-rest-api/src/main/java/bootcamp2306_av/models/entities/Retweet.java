package bootcamp2306_av.models.entities;

import jakarta.persistence.*;

@Entity
@Table (name = "retweets", schema = "bootcamp2306_av")
public class Retweet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "retweet_id", nullable = false)
    private Long retweetId;
    @Basic
    @Column(name = "tweet_id", nullable = false)
    private Long tweetId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    public Long getRetweetId() {
        return retweetId;
    }

    public void setRetweetId(Long retweetId) {
        this.retweetId = retweetId;
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

        Retweet retweet = (Retweet) o;

        if (retweetId != null ? !retweetId.equals(retweet.retweetId) : retweet.retweetId != null) return false;
        if (tweetId != null ? !tweetId.equals(retweet.tweetId) : retweet.tweetId != null) return false;
        if (userId != null ? !userId.equals(retweet.userId) : retweet.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = retweetId != null ? retweetId.hashCode() : 0;
        result = 31 * result + (tweetId != null ? tweetId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}

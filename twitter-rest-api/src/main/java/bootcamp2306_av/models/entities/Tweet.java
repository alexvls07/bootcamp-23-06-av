package bootcamp2306_av.models.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tweets", schema = "bootcamp2306_av")
public class Tweet {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "tweet_id", nullable = false)
    private Long tweetId;
    @Basic
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Basic
    @Column(name = "text", nullable = false)
    private String text;

    public Long getTweetId() {
        return tweetId;
    }

    public void setTweetId(Long tweetId) {
        this.tweetId = tweetId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        Tweet tweet = (Tweet) o;
        return Objects.equals(tweetId, tweet.tweetId) && Objects.equals(userId, tweet.userId) && Objects.equals(text, tweet.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tweetId, userId, text);
    }
}

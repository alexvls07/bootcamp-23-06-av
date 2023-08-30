package bootcamp2306_av.models.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "follow", schema = "bootcamp2306_av")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "follow_id", nullable = false)
    private Long followId;

    @Basic
    @Column(name = "user_follower_id", nullable = false)
    private Long followerId;

    @Basic
    @Column(name = "user_followed_id", nullable = false)
    private Long followedId;

    public Long getFollowId() {
        return followId;
    }

    public void setFollowId(Long followId) {
        this.followId = followId;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

    public Long getFollowedId() {
        return followedId;
    }

    public void setFollowedId(Long followedId) {
        this.followedId = followedId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(followId, follow.followId) && Objects.equals(followerId, follow.followerId) && Objects.equals(followedId, follow.followedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(followId, followerId, followedId);
    }
}

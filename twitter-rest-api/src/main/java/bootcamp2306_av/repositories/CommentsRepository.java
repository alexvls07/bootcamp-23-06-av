package bootcamp2306_av.repositories;

import bootcamp2306_av.models.Comment;
import bootcamp2306_av.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comment, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM bootcamp2306_av.comments WHERE comment_id = ?")
    public Comment findByComment_id(Long comment_id);
}

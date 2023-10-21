package be.isl.books.business.comment;

import be.isl.books.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByComment(String comment);
    List<Comment> findByStars(int stars);
    List<Comment> findByHide(boolean hide);
}

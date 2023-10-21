package be.isl.books.business.comment;

import be.isl.books.entity.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    // Custom query methods can be defined here if needed

    List<Comment> findByBookId(Long bookId);
}

package be.isl.books.business.comment;

import be.isl.books.entity.Author;
import be.isl.books.entity.Comment;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateCommentById(Long commentId, Comment updatedComment) {
        Comment existingComment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment with ID " + commentId + " not found"));


        existingComment.setComment(updatedComment.getComment());
        existingComment.setHide(updatedComment.getHide());
        existingComment.setStars(updatedComment.getStars());
        existingComment.setUpdatedTs(updatedComment.getUpdatedTs());

        // Save the updated author
        return commentRepository.save(existingComment);
    }

    public List<Comment> getAllComments() {
        return (List<Comment>) commentRepository.findAll();
    }

    public Optional<Comment> getCommentById(Long commentId) {
        return commentRepository.findById(commentId);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}


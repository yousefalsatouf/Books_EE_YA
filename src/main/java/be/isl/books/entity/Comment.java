package be.isl.books.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "stars")
    private int stars;

    @Column(name = "hide")
    private boolean hide;

    @Column(name = "inserted_ts")
    private Date insertedTs;

    @Column(name = "updated_ts")
    private Date updatedTs;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public boolean getHide() {
        return hide;
    }

    public void setHide(boolean hide) {
        this.hide = hide;
    }

    public Date getInsertedTs() {
        return insertedTs;
    }

    public void setInsertedTs(Date insertedTs) {
        this.insertedTs = insertedTs;
    }

    public Date getUpdatedTs() {
        return updatedTs;
    }

    public void setUpdatedTs(Date updatedTs) {
        this.updatedTs = updatedTs;
    }}


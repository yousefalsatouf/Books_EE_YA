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

    // Constructors, getters, and setters
}


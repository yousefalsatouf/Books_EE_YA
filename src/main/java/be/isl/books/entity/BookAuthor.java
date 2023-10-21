package be.isl.books.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Book_author")
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "inserted_ts")
    private Date insertedTs;

    @Column(name = "updated_ts")
    private Date updatedTs;

}


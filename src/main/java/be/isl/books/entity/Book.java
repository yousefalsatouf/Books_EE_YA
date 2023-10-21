package be.isl.books.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "nb_pages")
    private int nbPages;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "price")
    private double price;

    @Column(name = "publication_date")
    private Date publicationDate;

    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "inserted_ts")
    private Date insertedTs;

    @Column(name = "updated_ts")
    private Date updatedTs;

    // Constructors, getters, and setters
}


package be.isl.books.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "inserted_ts")
    private Date insertedTs;

    @Column(name = "updated_ts")
    private Date updatedTs;

    // Constructors, getters, and setters
}

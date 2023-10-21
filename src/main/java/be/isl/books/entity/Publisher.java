package be.isl.books.entity;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "name")
    private String name;

    @Column(name = "inserted_ts")
    private Date insertedTs;

    @Column(name = "updated_ts")
    private Date updatedTs;

    // Constructors, getters, and setters
}

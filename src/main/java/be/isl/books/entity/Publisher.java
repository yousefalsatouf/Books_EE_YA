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

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

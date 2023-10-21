package be.isl.books.business.publisher;
import be.isl.books.entity.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    // Custom query methods can be defined here if needed

    List<Publisher> findByName(String name);
}


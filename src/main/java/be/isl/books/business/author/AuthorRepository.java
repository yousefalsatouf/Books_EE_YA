package be.isl.books.business.author;

import be.isl.books.entity.Author;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByFirstnameAndLastname(String firstname, String lastname);
    List<Author> findByDateOfBirthBetween(Date startDate, Date endDate);
}


package be.isl.books.business.author;

import be.isl.books.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    List<Author> findByFirstname(String firstName);
    List<Author> findByLastname(String lastName);
    List<Author> findByEmail(String email);
    List<Author> findByDateOfBirth(Date dateOfBirth);

    List<Author> findByFirstnameAndDateOfBirth(String firstname, Date dateOfBirth);

}


package be.isl.books.business.author;

import be.isl.books.entity.Author;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    List<Author> findByFirstnameAndLastname(String firstname, String lastname);
    List<Author> findByDateOfBirthBetween(Date startDate, Date endDate);

   /* @Transactional
    @Modifying
    @Query("UPDATE Author a SET a.firstname = :newFirstName, a.lastname = :newLastName, a.email = :newEmail, a.dateOfBirth = :newDateOfBirth WHERE a.authorId = :authorId")
    int updateAuthorById(
            @Param("authorId") Long authorId,
            @Param("newFirstName") String newFirstName,
            @Param("newLastName") String newLastName,
            @Param("newEmail") String newEmail,
            @Param("newDateOfBirth") Date newDateOfBirth
    );*/
}


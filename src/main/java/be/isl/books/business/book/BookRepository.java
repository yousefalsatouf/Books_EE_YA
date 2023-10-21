package be.isl.books.business.book;

import be.isl.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByDescription(String description);
    List<Book> findByNbPages(int nbPages);
    List<Book> findByIsbn(String isbn);
    List<Book> findByPrice(Double price);
    List<Book> findByPublicationDate(Date publicationDate);
    /*@Query("SELECT b FROM Book b " +
            "JOIN b.bookAuthors ba " +
            "JOIN ba.author a " +
            "WHERE a.lastName = :authorLastName " +
            "AND a.dateOfBirth = :authorDateOfBirth")
    List<Book> findByAuthorLastnameAndAuthorDateOfBirth(String authorLastname, Date authorDateOfBirth);*/
}


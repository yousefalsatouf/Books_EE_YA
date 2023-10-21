package be.isl.books.business.book;

import be.isl.books.entity.Author;
import be.isl.books.entity.Book;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBookById(Long bookId, Book updatedBook) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book with ID " + bookId + " not found"));

        existingBook.setTitle(updatedBook.getTitle());
        existingBook.setDescription(updatedBook.getDescription());
        existingBook.setNbPages(updatedBook.getNbPages());
        existingBook.setPrice(updatedBook.getPrice());
        existingBook.setPublicationDate(updatedBook.getPublicationDate());
        existingBook.setPublisherId(updatedBook.getPublisherId());
        existingBook.setUpdatedTs(updatedBook.getUpdatedTs());

        // Save the updated author
        return bookRepository.save(existingBook);
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    // Custom service methods can be defined here if needed
}

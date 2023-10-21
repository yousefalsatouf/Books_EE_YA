package be.isl.books.ui;

import be.isl.books.business.author.AuthorRepository;
import be.isl.books.business.book.BookRepository;
import be.isl.books.business.comment.CommentRepository;
import be.isl.books.business.publisher.PublisherRepository;
import be.isl.books.entity.Author;
import be.isl.books.entity.Book;
import be.isl.books.entity.Comment;
import be.isl.books.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PublisherRepository publisherRepository;

    // Author //
    @GetMapping("/authors/firstName")
    public List<Author> searchAuthorsByFirstName(@RequestParam String firstName) {return authorRepository.findByFirstname(firstName);}
    @GetMapping("/authors/lastName")
    public List<Author> searchAuthorsByLastName(@RequestParam String lastName) {return authorRepository.findByLastname(lastName);}
    @GetMapping("/authors/email")
    public List<Author> searchAuthorsByEmail(@RequestParam String email) {return authorRepository.findByEmail(email);}
    @GetMapping("/authors/dateOfBirth")
    public List<Author> searchAuthorsByDateOfBirth(@RequestParam Date date) {return authorRepository.findByDateOfBirth(date);}

    // Book //
    @GetMapping("/books/title")
    public List<Book> searchBooksByTitle(@RequestParam String title) {return bookRepository.findByTitle(title);}
    @GetMapping("/books/description")
    public List<Book> searchBooksByDescription(@RequestParam String description) {return bookRepository.findByDescription(description);}
    @GetMapping("/books/nbPages")
    public List<Book> searchBooksByNbPages(@RequestParam int nbPages) {return bookRepository.findByNbPages(nbPages);}
    @GetMapping("/books/isbn")
    public List<Book> searchBooksByIsBn(@RequestParam String isBn) {return bookRepository.findByIsbn(isBn);}
    @GetMapping("/books/price")
    public List<Book> searchBooksByprice(@RequestParam Double price) {return bookRepository.findByPrice(price);}
    @GetMapping("/books/publicationDate")
    public List<Book> searchBooksByPublicationDate(@RequestParam Date date) {return bookRepository.findByPublicationDate(date);}
    /*@GetMapping("/books/authorAndDateOfBirth")
    public List<Book> searchBooksByAuthorAndDateOfBirth(@RequestParam String authorLastname, @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date authorDateOfBirth) {
        return bookRepository.findByAuthorLastnameAndAuthorDateOfBirth(authorLastname, authorDateOfBirth);
    }*/

    // Comment //
    @GetMapping("/comments/comment")
    public List<Comment> searchCommentsByComment(@RequestParam String comment) {return commentRepository.findByComment(comment);}
    @GetMapping("/comments/stars")
    public List<Comment> searchCommentsByStars(@RequestParam int stars) {return commentRepository.findByStars(stars);}
    @GetMapping("/comments/hide")
    public List<Comment> searchCommentsByHidden(@RequestParam Boolean hidden) {return commentRepository.findByHide(hidden);}

    // Publisher //
    @GetMapping("/publishers/name")
    public List<Publisher> searchPublishersName(@RequestParam String name) {return publisherRepository.findByName(name);}
}


package be.isl.books.ui;

import be.isl.books.business.author.AuthorService;
import be.isl.books.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Author>> getAuthorById(@PathVariable Long id) {
        Optional<Author> author = authorService.getAuthorById(id);
        if (author.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {
        if(author.getInsertedTs()==null) {// createdAt
            author.setInsertedTs(new Date());
        }
        Author savedAuthor = authorService.saveAuthor(author);
        return ResponseEntity.created(URI.create("/authors/" + savedAuthor.getAuthorId())).body(savedAuthor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Author> updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        if(author.getUpdatedTs()==null) {// updatedAt
            author.setUpdatedTs(new Date());
        }
        Author updatedAuthor = authorService.updateAuthorById(id, author);
        if (updatedAuthor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedAuthor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}


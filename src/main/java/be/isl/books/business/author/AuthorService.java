package be.isl.books.business.author;

import be.isl.books.entity.Author;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public Author updateAuthorById(Long authorId, Author updatedAuthor) {
        Author existingAuthor = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author with ID " + authorId + " not found"));

        existingAuthor.setFirstname(updatedAuthor.getFirstname());
        existingAuthor.setLastname(updatedAuthor.getLastname());
        existingAuthor.setEmail(updatedAuthor.getEmail());
        existingAuthor.setDateOfBirth(updatedAuthor.getDateOfBirth());
        existingAuthor.setUpdatedTs(updatedAuthor.getUpdatedTs());

        // Save the updated author
        return authorRepository.save(existingAuthor);
    }

    public List<Author> getAllAuthors() {
        return (List<Author>) authorRepository.findAll();
    }

    public Optional<Author> getAuthorById(Long authorId) {
        return authorRepository.findById(authorId);
    }

    public void deleteAuthor(Long authorId) {
        authorRepository.deleteById(authorId);
    }
}


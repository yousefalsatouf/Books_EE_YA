package be.isl.books.business.publisher;

import be.isl.books.entity.Comment;
import be.isl.books.entity.Publisher;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {

    private final PublisherRepository publisherRepository;

    @Autowired
    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher savePublisher(Publisher publisher) {
        return publisherRepository.save(publisher);
    }

    public Publisher updatePublisherById(Long publisherId, Publisher updatedPublisher) {
        Publisher existingPublisher = publisherRepository.findById(publisherId)
                .orElseThrow(() -> new EntityNotFoundException("Publisher with ID " + publisherId + " not found"));

        existingPublisher.setName(updatedPublisher.getName());
        existingPublisher.setUpdatedTs(updatedPublisher.getUpdatedTs());

        // Save the updated author
        return publisherRepository.save(existingPublisher);
    }

    public List<Publisher> getAllPublishers() {
        return (List<Publisher>) publisherRepository.findAll();
    }

    public Optional<Publisher> getPublisherById(Long publisherId) {
        return publisherRepository.findById(publisherId);
    }

    public void deletePublisher(Long publisherId) {
        publisherRepository.deleteById(publisherId);
    }

    // Custom service methods can be defined here if needed
}


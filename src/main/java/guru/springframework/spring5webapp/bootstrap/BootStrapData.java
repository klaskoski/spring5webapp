package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.*;
import guru.springframework.spring5webapp.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        var eric = new Author();
        eric.setFirstName("Konrad");
        eric.setLastName("Laskoski");

        var ddd = new Book();
        ddd.setAuthors(Set.of(eric));
        ddd.setTitle("Domain Driven Design");
        ddd.setIsbn("11111");
        eric.getBooks().add(ddd);

        var publisher = new Publisher();
        publisher.setName("Warsaw");
        publisher.setAddress("Warsaw");
        ddd.setPublisher(publisher);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);
        publisher.getBooks().add(ddd);
        publisherRepository.save(publisher);

        System.out.println("Startind");
        System.out.println("Number of books is " + bookRepository.count());
        System.out.println("Number of publishers " + publisherRepository.count());
        System.out.println("Number of books for publisher " + publisher.getBooks().size());
    }
}

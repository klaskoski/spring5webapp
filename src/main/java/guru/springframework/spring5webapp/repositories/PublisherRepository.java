package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}

package pl.sullag.caretakerapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sullag.caretakerapp.model.Group;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
}

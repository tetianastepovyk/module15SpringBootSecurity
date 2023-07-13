package module15DevSpringBootSecurity.repository;

import module15DevSpringBootSecurity.entity.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import module15DevSpringBootSecurity.entity.Note;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {
}
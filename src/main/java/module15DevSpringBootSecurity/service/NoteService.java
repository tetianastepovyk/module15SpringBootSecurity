package module15DevSpringBootSecurity.service;

import lombok.RequiredArgsConstructor;
import module15DevSpringBootSecurity.entity.Note;
import org.springframework.stereotype.Service;
import module15DevSpringBootSecurity.repository.NoteRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    //метод повертає список всіх нотаток
    public List<Note> listAll() {
       return (List<Note>) noteRepository.findAll();
    }

    //метод додає нову нотатку
    public Note add(Note note) {
        return noteRepository.save(note);
    }
    //видаляє нотатку з вказаним ідентифікатором.
    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        noteRepository.deleteById(id);
    }
    //шукає нотатку по note.id
    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new NoSuchElementException();
        }
        noteRepository.save(note);
    }

    public Note getById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        return noteRepository.findById(id).orElseThrow();
    }
}

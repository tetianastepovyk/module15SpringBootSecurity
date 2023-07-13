package module15DevSpringBootSecurity.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import module15DevSpringBootSecurity.entity.Note;
import module15DevSpringBootSecurity.service.NoteService;

import java.util.Map;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @GetMapping("/list")
    public ModelAndView getListOfNotes() {
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @PostMapping(value = "/delete", consumes = "application/x-www-form-urlencoded")
    public ModelAndView deleteNoteById(@RequestParam Map<String, String> reqParams) {
        noteService.deleteById(Long.parseLong(reqParams.get("id")));
        ModelAndView modelAndView = new ModelAndView("redirect:/note/list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(@RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", noteService.getById(id));
        return modelAndView;
    }

    @PostMapping(value = "/edit", consumes = "application/x-www-form-urlencoded")
    public ModelAndView editNote(@RequestParam Map<String, String> reqParams) {
        Note note = Note.builder().id(Long.parseLong(reqParams.get("id"))).title(reqParams.get("title")).content(reqParams.get("content")).build();
        noteService.update(note);
        ModelAndView modelAndView = new ModelAndView("redirect:/note/list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }
}

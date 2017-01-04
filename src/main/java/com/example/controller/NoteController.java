package com.example.controller;

import com.example.entity.Note;
import com.example.entity.User;
import com.example.repository.NoteRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("{username}/notes")
public class NoteController {
    @Autowired
    NoteRepository noteRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping
    public Collection<Note> readNotes(@PathVariable String username){
        return noteRepository.findByUserUsername(username);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addNote(@PathVariable String username, @RequestBody Note note){
        User user = userRepository.findByUsername(username)
                .orElseThrow(()-> new UserNotFoundException(username));
        note.setUser(user);
        noteRepository.save(note);
    }
}

@ResponseStatus(HttpStatus.NOT_FOUND)
class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("could not find user '"+username+"'.");
    }
}

package com.example;

import com.example.entity.Note;
import com.example.entity.User;
import com.example.repository.NoteRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Spring4BootAngularJsApplication implements CommandLineRunner{

	@Autowired
	NoteRepository noteRepository;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring4BootAngularJsApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		User vasia = new User("Vasia", "123");
		userRepository.save(vasia);
		Note note1 = new Note("note text 1", vasia);
		noteRepository.save(note1);

		User roman = new User("Roman", "9999");
		userRepository.save(roman);
		Note note2 = new Note("note text 11", roman);
		Note note3 = new Note("note text 22", roman);
		noteRepository.save(note2);
		noteRepository.save(note3);
	}
}

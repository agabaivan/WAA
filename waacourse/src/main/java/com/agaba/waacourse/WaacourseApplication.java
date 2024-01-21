package com.agaba.waacourse;

import com.agaba.waacourse.entity.Post;
import com.agaba.waacourse.entity.User;
import com.agaba.waacourse.repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WaacourseApplication implements CommandLineRunner {

	@Autowired
	private UserRepo repo;

	public static void main(String[] args) {
		SpringApplication.run(WaacourseApplication.class, args);

	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 =  new User("John");
		user1.addPost(new Post( "First Post", "This is the content of the first post.", "John Doe"));
		user1.addPost(new Post( "Second Post", "This is the content of the second post.", "Jane Doe"));
		user1.addPost(new Post("Third Post", "This is the content of the third post.", "Alice Smith"));
		repo.save(user1);


	}

}

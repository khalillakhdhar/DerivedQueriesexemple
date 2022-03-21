package com.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.demo.model.User;
import com.demo.model.repository.UserRepository;

@SpringBootApplication
public class DerivedQueriesApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepo;
	public static void main(String[] args) {
		SpringApplication.run(DerivedQueriesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	userRepo.deleteAll();
	User u1= new User("user1", "u1", "adr1", "3300998887", 30);
	User u2= new User("user2", "u3", "adr2", "3300998111", 40);
	User u3= new User("user1", "u1", "adr2", "3300998222", 50);
	userRepo.save(u1);
	userRepo.save(u2);
	userRepo.save(u3);
	
	List<User> liuser= new ArrayList<User>();// intilisation
	liuser=userRepo.findByNom("user2");
	for(User us:liuser)
	{
		System.out.println("findbyNom"+us.toString());
	}
	List<User> liuserage= new ArrayList<User>();// intilisation
	liuserage=userRepo.findByNomOrAge("user2", 10);
	//liuserage.forEach(User us);
//	for(User us:liuserage)
//	{
//		System.out.println("findby Nom OR age"+us.toString());
//	}
	List<User> liuseradresse= new ArrayList<User>();// intilisation
	liuseradresse=userRepo.findDistinctByAdresse("adr2");
	for(User us:liuser)
	{
		System.out.println("find by adresse sans doublant"+us.toString());
	}
	
	
	
	}
	

}

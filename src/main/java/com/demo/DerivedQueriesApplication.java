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
	User u1= new User("admin", "u1", "adr1", "3300998887", 30);
	User u2= new User("teste", "u3", "adr2", "3300998111", 30);
	User u3= new User("adminuser", "u1", "new york", "3300998222", 50);
	userRepo.save(u1);
	userRepo.save(u2);
	u3.setJob("enseignant");
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
	for(User us:liuseradresse)
	{
		System.out.println("find by adresse sans doublant"+us.toString());
	}
	List<User> linulljob= new ArrayList<User>();// intilisation
	linulljob=userRepo.findByJobIsNull();
	for(User us:linulljob)
	{
		System.out.println("find by job where job is NULL"+us.toString());
	}
	List<User> startNames= new ArrayList<User>();// intilisation
	startNames=userRepo.findByNomStartingWith("admin");
	for(User us:startNames)
	{
		System.out.println("find by names starts"+us.toString());
	}
	List<User> adresseContent= new ArrayList<User>();// intilisation
	adresseContent=userRepo.findByAdresseContaining("york");
	for(User us:adresseContent)
	{
		System.out.println("find by adresse containing"+us.toString());
	}
	List<User> userordered= new ArrayList<User>();// intilisation
	userordered=userRepo.findByAgeOrderByNomDesc(30);
	for(User us:userordered)
	{
		System.out.println("find by age 30 ordonné"+us.toString());
	}
	
	}
	

}

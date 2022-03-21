package com.demo.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
List<User> findByNom(String nom);
List<User> findByAge(int age);
//List<User> findByCodeUser(String code);
List<User> findDistinctByAdresse(String ad); // required param=> String int...
List<User> findByNomAndAge(String nom,int age); // age ==int age ET nom==String nom
List<User> findByNomOrAge(String nom, int age); // age ==int age OU nom==String nom
//List<User> findByAgeOrNom(int Age, String nom); correcte


}

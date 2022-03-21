package com.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String nom;
private String prenom;
private String adresse;
private String tel;
private int age;
@Column(nullable = true)
String job;


//private String code_user;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}




public User(String nom, String prenom, String adresse, String tel, int age) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.adresse = adresse;
	this.tel = tel;
	this.age = age;
}
public User() {
	super();
}
@Override
public String toString() {
	return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", tel=" + tel + ", age="
			+ age + "]";
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}







	
}

package it.beTalent.nomiCognomi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "idusers")
	    private long id;
		
		@Column(name = "name")
	    private String name;
		
		
		
		@Column(name = "surname")
	    private String surname;
		
		
		@Column(name = "username")
		private String username;
		
		@Column(name = "password")
		private String password;
		
		@Column(name = "email")
		private String email;
		
		
		public User() {
			super();
			
		}


		public long getId() {
			return id;
		}


		public void setId(long id) {
			this.id = id;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public String getSurname() {
			return surname;
		}


		public void setSurname(String surname) {
			this.surname = surname;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}
		
		
		

	
}

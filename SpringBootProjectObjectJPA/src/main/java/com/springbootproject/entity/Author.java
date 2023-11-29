package com.springbootproject.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Author {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int author_id;
	//@Column(name="DESC", nullable = false, length = 15)
	private String author_firstName;
	private String author_lastName;
	private String author_address;
	
	//@OneToOne(mappedBy="author")
	//@JsonBackReference
	//private BookEntityObject Bookentityobject;

	//public BookEntityObject getBookentityobject() {
		//return Bookentityobject;
	//}
	//public void setBookentityobject(BookEntityObject bookentityobject) {
		//Bookentityobject = bookentityobject;
	//}
	public int getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}
	public String getAuthor_firstName() {
		return author_firstName;
	}
	public void setAuthor_firstName(String author_firstName) {
		this.author_firstName = author_firstName;
	}
	public String getAuthor_lastName() {
		return author_lastName;
	}
	public void setAuthor_lastName(String author_lastName) {
		this.author_lastName = author_lastName;
	}
	public String getAuthor_address() {
		return author_address;
	}
	public void setAuthor_address(String author_address) {
		this.author_address = author_address;
	}
	public Author(int author_id, String author_firstName, String author_lastName, String author_address) {
		super();
		this.author_id = author_id;
		this.author_firstName = author_firstName;
		this.author_lastName = author_lastName;
		this.author_address = author_address;
	}
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", author_firstName=" + author_firstName + ", author_lastName="
				+ author_lastName + ", author_address=" + author_address + "]";
	}

}

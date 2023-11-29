package com.springbootproject.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Writer_Book_object")
public class BookEntityObject {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="book_id")
	private int id;
	private String name;
	private String title;
	//this variable is object type Author
	//here i put one to one relationShip
    @OneToOne(cascade=CascadeType.ALL)
    //@JsonManagedReference
	private Author author;
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitel(String title) {
		this.title = title;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public BookEntityObject(int id, String name, String title, Author author) {
		super();
		this.id = id;
		this.name = name;
		this.title = title;
		this.author = author;
	}
	public BookEntityObject() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "BookEntityObject [id=" + id + ", name=" + name + ", title=" + title + ", author=" + author + "]";
	}
	

}

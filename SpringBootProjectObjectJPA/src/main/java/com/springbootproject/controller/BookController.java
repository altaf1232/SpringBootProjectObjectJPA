package com.springbootproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.entity.BookEntityObject;
import com.springbootproject.service.BookService;

@RestController
public class BookController {
	  @Autowired
	    private BookService bookService;
	    
		@GetMapping("/books")
		//ya Multipal book key liye hai 
		//iss book ko eaak list ma store karlate hai this.bookService.getAllBooks()
		//status not found karne key liye aapko ResponseEntities likhana huga aapne public getBooks() method 
		// ma aaur uss key aander send karngay book
		//yaha per aap list ka book send kar rahe hu tu aapko define karna huga aaur ResponseEntity keywal single book ko contain nahi karegi bahut sari book ko cantain karegi 
		//ResponseEntity key pass eaak static method jiska name hai status aaur proper object banane key liye aapko eaak aaur method used karna huga build
		 public ResponseEntity<List<BookEntityObject>>  getBooks()
		 {
			
		List<BookEntityObject>list=bookService.getAllBooks();
		//here i create if condition
		if(list.size()<=0) 
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		 //	if(list.size()<=0) hu jata hai tu iss condition ma  mughe kuch return hai tu statucs not found karna hai 
		//matlab aap key list ki size zero hai tu that miss book aapko nahi mila huga 			
		}
			return  ResponseEntity.of(Optional.of(list));
		 }
		@PostMapping("/savebooks")
		//aap key Request ma ju data aarah hai book key object data kon karega tu yaha per pass karna huga @RequestBody
		public BookEntityObject addBooks(@RequestBody BookEntityObject  book)
		{
			BookEntityObject booksTest=	this.bookService.addTestBook(book);
			System.out.println(book);
		    return booksTest;
		}
		@DeleteMapping("/books/{BookId}")
		public void deleteBook_a(@PathVariable("BookId")int id) {
			this.bookService.deleteBook_b(id);
		}
}

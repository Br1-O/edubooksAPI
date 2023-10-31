package com.br1.edubooks.controller;

import com.br1.edubooks.model.domain.Book;
import com.br1.edubooks.model.dto.request.dtoBook_createData;
import com.br1.edubooks.model.dto.response.dtoBook_displayData;
import com.br1.edubooks.model.repositories.IBookRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    //dependency injection
        private final IBookRepository bookRepository;

        public BookController(IBookRepository bookRepository) {
            this.bookRepository = bookRepository;
        }

    //GET list of books from db
        @GetMapping("/")
        public ResponseEntity<Page<dtoBook_displayData>> show(@PageableDefault(size = 4, sort="title") Pageable pagination){

            return ResponseEntity.ok(bookRepository.findByIsAvailableTrue(pagination).map(dtoBook_displayData::new));
        }

    //GET one book from db via id in Path
        @GetMapping("/{id}")
        public ResponseEntity<dtoBook_displayData> showOne(@PathVariable Long id){
            dtoBook_displayData book= new dtoBook_displayData(bookRepository.getReferenceById(id));
            return ResponseEntity.ok(book);
        }

    //CREATE method
    @PostMapping("/add")
    public ResponseEntity<dtoBook_displayData> register(@RequestBody @Valid dtoBook_createData newBookData, UriComponentsBuilder UriComponentsBuilder){

        Book newBook = bookRepository.save(new Book(newBookData));
        dtoBook_displayData dtoBook_dataDisplay = new dtoBook_displayData(newBook);

        URI url = UriComponentsBuilder.path("/books/{id}").buildAndExpand(newBook.getId()).toUri();
        return ResponseEntity.created(url).body(dtoBook_dataDisplay);
    }


}

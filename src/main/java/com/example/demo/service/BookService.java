package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.dto.BookDTO;
import com.example.demo.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;

    public BookService(BookRepository bookRepository, ModelMapper modelMapper) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = modelMapper.map(bookDTO, Book.class);
        Book savedBook = bookRepository.save(book);
        return modelMapper.map(savedBook,BookDTO.class);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<BookDTO> getAllBooks() {
        final List<Book> books = bookRepository.findAll();
        List<BookDTO> bookDTOList  = modelMapper.map(books,new TypeToken<List<BookDTO>>(){}.getType());
        return bookDTOList;
    }
}

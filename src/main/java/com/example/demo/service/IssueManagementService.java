package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.IssueDetails;
import com.example.demo.dto.BookIssueStatus;
import com.example.demo.dto.IssueDetailsDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.IssueDetailsRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class IssueManagementService {
    private final IssueDetailsRepository issueDetailsRepository;
    private final ModelMapper modelMapper;
    private final BookRepository bookRepository;

    public IssueManagementService(IssueDetailsRepository issueDetailsRepository, BookRepository bookRepository, ModelMapper modelMapper) {
        this.issueDetailsRepository = issueDetailsRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    public ResponseDTO issueBook(IssueDetailsDTO issueDetailsDTO) {
        ResponseDTO responseDTO = new ResponseDTO(BookIssueStatus.SUCCESS,"Book Issued");
        final IssueDetails issueDetails = modelMapper.map(issueDetailsDTO, IssueDetails.class);

        final Optional<Book> optionalBook = bookRepository.findById(issueDetailsDTO.getBookId());

        if(optionalBook.isPresent()){
            final Book book = optionalBook.get();
            if(book.getQuantity() > 0){
                book.setQuantity(book.getQuantity() - 1);
                bookRepository.save(book);
                issueDetailsRepository.save(issueDetails);
            }else{
                responseDTO = new ResponseDTO(BookIssueStatus.NOT_AVAILABLE,"Not enough copies available");
            }
            responseDTO=  new ResponseDTO(BookIssueStatus.FAILED,String.format("No book available for given details {}", issueDetailsDTO));
        }
        return responseDTO;
    }

    public ResponseDTO returnBook(Long issueId) {
        ResponseDTO responseDTO = new ResponseDTO(BookIssueStatus.SUCCESS,"Book Returned");

        final Optional<IssueDetails> issueDetails = issueDetailsRepository.findById(issueId);

        if(issueDetails.isPresent()) {
            final Long bookId = issueDetails.get().getBookId();
            final Book returnedBook = bookRepository.findById(bookId).get();
            returnedBook.setQuantity(returnedBook.getQuantity() + 1);
            bookRepository.save(returnedBook);
            issueDetailsRepository.delete(issueDetails.get());
        }else{
                responseDTO=  new ResponseDTO(BookIssueStatus.FAILED,String.format("No issue available for given details {}", issueId));
        }
        return responseDTO;
    }

    public List<IssueDetailsDTO> getIssuedBooks() {
        final List<IssueDetails> issueDetails = issueDetailsRepository.findAll();
        List<IssueDetailsDTO> issueDetailsDTOS  = modelMapper.map(issueDetails,new TypeToken<List<IssueDetailsDTO>>(){}.getType());
        return issueDetailsDTOS;
    }

}

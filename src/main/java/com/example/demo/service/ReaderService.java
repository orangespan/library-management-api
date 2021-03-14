package com.example.demo.service;

import com.example.demo.domain.Book;
import com.example.demo.domain.Reader;
import com.example.demo.dto.BookDTO;
import com.example.demo.dto.ReaderDTO;
import com.example.demo.repository.ReaderRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    private final ReaderRepository readerRepository;
    private final ModelMapper modelMapper;

    public ReaderService(ReaderRepository readerRepository, ModelMapper modelMapper) {
        this.readerRepository = readerRepository;
        this.modelMapper = modelMapper;
    }

    public ReaderDTO saveReader(ReaderDTO readerDTO) {
        Reader reader = modelMapper.map(readerDTO,Reader.class);
        Reader savedReader = readerRepository.save(reader);
        return modelMapper.map(savedReader,ReaderDTO.class);
    }

    public Optional<Reader> getReaderById(Long id) {
        return readerRepository.findById(id);
    }

    public List<ReaderDTO> getAllReaders() {
        final List<Reader> readers = readerRepository.findAll();
        List<ReaderDTO> readerDTOS  = modelMapper.map(readers,new TypeToken<List<ReaderDTO>>(){}.getType());
        return readerDTOS;
    }

}

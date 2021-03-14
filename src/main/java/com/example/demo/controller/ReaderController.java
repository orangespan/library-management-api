package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.dto.ReaderDTO;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/readers")
public class ReaderController {

    private final ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public ReaderDTO createReader(@RequestBody @Validated ReaderDTO readerDTO) {
        return readerService.saveReader(readerDTO);
    }

    @GetMapping
    public List<ReaderDTO> getAllReaders() {
        return readerService.getAllReaders();
    }

}

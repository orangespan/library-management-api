package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class LibraryManagementIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldIssueABookToReader(){
        //TODO
    }

    @Test
    public void shouldReturnABookToReader(){
        //TODO
    }

    @Test
    public void shouldReturnNoBookAvalResponseWhenNoCopiesToIssue(){
        //TODO
    }

    @Test
    public void shouldReturnNoBookFoundMessageWhenNoBookFound(){
        //TODO
    }



}

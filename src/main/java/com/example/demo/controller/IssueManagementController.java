package com.example.demo.controller;

import com.example.demo.dto.IssueDetailsDTO;
import com.example.demo.dto.ReaderDTO;
import com.example.demo.dto.ResponseDTO;
import com.example.demo.service.IssueManagementService;
import com.example.demo.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/issue-management")
public class IssueManagementController {

    private final IssueManagementService issueManagementService;

    public IssueManagementController(IssueManagementService issueManagementService) {
        this.issueManagementService = issueManagementService;
    }

    @PostMapping(value = "issue-book")
    public ResponseDTO issueBook(@RequestBody @Validated IssueDetailsDTO issueDetailsDTO) {
        return issueManagementService.issueBook(issueDetailsDTO);
    }

    @PostMapping(value = "return-book/{issueId}")
    public ResponseDTO returnBook(@PathVariable Long issueId) {
        return issueManagementService.returnBook(issueId);
    }

    @GetMapping(value = "issues")
    public List<IssueDetailsDTO> getAllIssues() {
        return issueManagementService.getIssuedBooks();
    }


}

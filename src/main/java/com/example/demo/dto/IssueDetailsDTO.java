package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IssueDetailsDTO {
    private Long id;
    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "readerId")
    private Long readerId;
    //TODO date borrowed
}

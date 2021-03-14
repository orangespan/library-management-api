package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "issue_details")
public class IssueDetails {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    @Column(name = "bookId")
    private Long bookId;
    @Column(name = "readerId")
    private Long readerId;
    //TODO date borrowed
}

package com.example.githubScrapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class BranchDTO {
    private String name;
    private CommitDTO commit;
}

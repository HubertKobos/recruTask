package com.example.githubScrapp.responses;


import com.example.githubScrapp.dto.BranchDTO;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class ResponseRepository {
    private String name;
    private String owner_login;
    private List<BranchDTO> branches;
}

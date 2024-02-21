package com.example.githubScrapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class RepositoryDTO {
    private String name;
    private OwnerDto owner;
    private boolean fork;
    private String branches_url;

}

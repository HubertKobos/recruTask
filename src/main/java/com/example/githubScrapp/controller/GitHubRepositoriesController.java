package com.example.githubScrapp.controller;

import com.example.githubScrapp.responses.ResponseRepository;
import com.example.githubScrapp.service.GitHubApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value="/repositories")
@RequiredArgsConstructor
public class GitHubRepositoriesController {
    private final GitHubApiService gitHubApiService;

    @GetMapping("/{username}")
    public ResponseEntity<List<ResponseRepository>> listRepositoriesWithoutForks(@PathVariable String username){
        List<ResponseRepository> repos = gitHubApiService.getUserRepositoriesWithoutForks(username);
        return ResponseEntity.status(HttpStatus.OK).body(repos);
    }
}

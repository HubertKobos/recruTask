package com.example.githubScrapp;

import com.example.githubScrapp.dto.RepositoryDTO;
import com.example.githubScrapp.exceptions.UserNotFoundException;
import com.example.githubScrapp.service.GitHubApiService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GitHubApiServiceTest {
    @MockBean
    private RestTemplate restTemplate;

    @Test
    public void testGetUserRepositoriesWithoutForks_UserNotFound() {
        Random rnd = new Random();
        String username = String.valueOf(rnd.nextInt(0, 10000)); // generate random username made of numbers
        when(restTemplate.getForObject(Mockito.anyString(), Mockito.eq(RepositoryDTO[].class))).thenThrow(HttpClientErrorException.NotFound.class);

        GitHubApiService gitHubService = new GitHubApiService(restTemplate);
        assertThrows(UserNotFoundException.class, () -> gitHubService.getUserRepositoriesWithoutForks(username));
    }

}

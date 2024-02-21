package com.example.githubScrapp.service;

import com.example.githubScrapp.dto.BranchDTO;
import com.example.githubScrapp.dto.RepositoryDTO;
import com.example.githubScrapp.responses.ResponseRepository;
import com.example.githubScrapp.exceptions.UserNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class GitHubApiService {
    private final String GITHUB_API_BASE_URL = "https://api.github.com/";
    private final Logger log = LoggerFactory.getLogger(GitHubApiService.class);
    private final RestTemplate restTemplate;

    public GitHubApiService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<ResponseRepository> getUserRepositoriesWithoutForks(String username){
        RepositoryDTO[] repos;
        String url = GITHUB_API_BASE_URL + "users/" + username + "/repos";

        try{
            repos = restTemplate.getForObject(url, RepositoryDTO[].class);
        }catch (HttpClientErrorException.NotFound ex) {
            throw new UserNotFoundException("User with given username not found");
        }


        List<ResponseRepository> responseRepos = new ArrayList<>();

        // scrap branches for each repository, map to ResponseRepository object and append to the responseRepos list
        for(RepositoryDTO repo : repos){
            if(!repo.isFork()){

                String branchesUrl = repo.getBranches_url().replace("{/branch}", "");
                String fullBranchesUrl = UriComponentsBuilder.fromHttpUrl(branchesUrl).toUriString();
                BranchDTO[] branches = restTemplate.getForObject(fullBranchesUrl, BranchDTO[].class);

                if(branches != null){
                    ResponseRepository responseRepository = new ResponseRepository();
                    responseRepository.setName(repo.getName());
                    responseRepository.setOwner_login(repo.getOwner().getLogin());
                    responseRepository.setBranches(Arrays.asList(branches));
                    responseRepos.add(responseRepository);
                }
            }
        }
        return responseRepos;
    }


}

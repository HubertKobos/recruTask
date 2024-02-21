package com.example.githubScrapp.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
@ToString
public class OwnerDto {
    private String login;
}

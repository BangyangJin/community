package com.shu.community.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class GithubUser {
    private String name;
    private Long id;
    private String bio;
    private String avatarUrl;
}

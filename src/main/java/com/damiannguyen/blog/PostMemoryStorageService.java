package com.damiannguyen.blog;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PostMemoryStorageService {
    private static final List<PostDto> STORAGE = new ArrayList<>();
    static{
        STORAGE.add(new PostDto("Lorem ipsum dolor", "Lorem dolor..."));
        STORAGE.add(new PostDto("Lorem ipsum polor", "Lorem polor..."));
        STORAGE.add(new PostDto("Lorem ipsum color", "Lorem color..."));
    }

    public Optional<PostDto> getPostDto(String uuid){
        return STORAGE
                .stream()
                .filter(
                        post -> post.getUuid().equalsIgnoreCase(uuid)
                ).findFirst();
    }

    public List<PostDto> getPosts(){
        return STORAGE;
    }

    public PostDto create(String title, String text){
        PostDto postDto = new PostDto(title, text);
        STORAGE.add(postDto);
        return postDto;
    }
}

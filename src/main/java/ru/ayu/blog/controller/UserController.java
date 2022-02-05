package ru.ayu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ayu.blog.dto.PageDto;
import ru.ayu.blog.dto.PostDto;
import ru.ayu.blog.dto.SearchDto;
import ru.ayu.blog.service.UserServiceImpl;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/getPages")
    public PageDto getPages(@RequestBody SearchDto searchDto){

        PageDto pageDto = userService.searchPages(searchDto);

        return pageDto;
    }
    @GetMapping("/getPost")
    public PostDto getPost(@RequestParam Long id){

        PostDto postDto = userService.searchPost(id);

        return postDto;
    }

}

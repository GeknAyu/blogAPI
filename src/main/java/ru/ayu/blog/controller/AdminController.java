package ru.ayu.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ayu.blog.dto.PostDto;
import ru.ayu.blog.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @PostMapping("/workingOnThePost")
    public PostDto createPost(@RequestBody PostDto postDto) {

        postDto = adminService.createPostBlog(postDto);

        return postDto;
    }
    @PutMapping("/workingOnThePost")
    public PostDto updatePost(@RequestBody PostDto postDto) {

        postDto = adminService.updatePostBlog(postDto);

        return postDto;
    }
    @DeleteMapping("/workingOnThePost")
    public void deletePost(@RequestParam("id") Long id) {

        adminService.deletePostBlog(id);

    }
}

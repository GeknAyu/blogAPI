package ru.ayu.blog.service;

import ru.ayu.blog.dto.PostDto;

public interface AdminService {
    public abstract PostDto createPostBlog(PostDto postDto);

    public abstract PostDto updatePostBlog(PostDto postDto);

    public abstract void deletePostBlog(Long id);

    public abstract void checkPostBlogCorrectInput(PostDto postDto);

    public abstract void checkPostBlogCorrectId(Long id);


}

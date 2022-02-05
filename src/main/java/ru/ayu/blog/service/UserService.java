package ru.ayu.blog.service;

import ru.ayu.blog.dto.PageDto;
import ru.ayu.blog.dto.PostDto;
import ru.ayu.blog.dto.SearchDto;

public interface UserService {
    public abstract PageDto searchPages(SearchDto searchDto);

    public abstract PostDto searchPost(Long id);

    public abstract void checkPostBlogCorrectId(Long id);
}

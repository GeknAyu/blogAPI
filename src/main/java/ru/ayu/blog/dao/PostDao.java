package ru.ayu.blog.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.ayu.blog.domain.Post;
import ru.ayu.blog.domain.Tags;

import java.util.List;

public interface PostDao {


    public Page<Post> findByTagsBlogAndByTitle(List<Tags> tags, String title, Pageable pageable);
    public Page<Post> findByTagsBlog(List<Tags> tags, Pageable pageable);
    public Page<Post> findByTitle(String title, Pageable pageable);
}

package ru.ayu.blog.dao;

import org.springframework.data.jpa.domain.Specification;
import ru.ayu.blog.domain.Post;
import ru.ayu.blog.domain.Tags;

public class SpecificationPost {
    static Specification<Post> tagsSpec(Tags tags) {
        return (root, cq, cb) -> cb.isMember(tags, root.get("tags"));
    }

    static Specification<Post> titleSpec(String title) {
        return (postBlog, cq, cb) -> cb.like(postBlog.get("title"), "%" + title + "%");
    }
}

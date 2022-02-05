package ru.ayu.blog.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.ayu.blog.domain.Post;

public interface PostRepos extends JpaRepository<Post, Long>, JpaSpecificationExecutor<Post> {



}

package ru.ayu.blog.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import ru.ayu.blog.domain.Post;
import ru.ayu.blog.domain.Tags;
import ru.ayu.blog.repos.PostRepos;
import java.util.List;

import static ru.ayu.blog.dao.SpecificationPost.*;

@Repository
public class PostDao implements PostCustomRepos {
    @Autowired
    PostRepos postRepos;

    public Page<Post> findByTagsBlogAndByTitle(List<Tags> tags, String title, Pageable pageable) {
        Specification<Post> s = titleSpec(title);
        for(Tags t : tags){
            s = s.and(tagsSpec(t));
        }
       return postRepos.findAll(s,pageable);
    }
    public Page<Post> findByTagsBlog(List<Tags> tags, Pageable pageable){
        Specification<Post> s = Specification.where(null);
        for(Tags t : tags){
            s = s.and(tagsSpec(t));
        }
        return postRepos.findAll(s,pageable);
    }
    public Page<Post> findByTitle(String title, Pageable pageable){
        return postRepos.findAll((titleSpec(title)),pageable);
    }
    public List<Post> findController(List<Tags> tags, String title, Pageable pageable){
        Specification<Post> s = Specification.where(null);
        if(tags != null){
            for(Tags t : tags){
                s = s.and(tagsSpec(t));
            }

        }
        if(title != null){
            s = s.and(titleSpec(title));
        }
        return postRepos.findAll(s, pageable).getContent();
    }

}

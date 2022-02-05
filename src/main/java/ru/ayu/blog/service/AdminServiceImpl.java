package ru.ayu.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ayu.blog.converter.PostConverter;
import ru.ayu.blog.domain.Post;
import ru.ayu.blog.dto.PostDto;
import ru.ayu.blog.repos.PostRepos;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    PostConverter converter;
    @Autowired
    PostRepos postRepos;

    public PostDto createPostBlog(PostDto postDto){
        checkPostBlogCorrectInput(postDto);

        Post post = converter.dtoToEntity(postDto);
        Date createDate = new Date();
        post.setCreateDate(createDate);
        post.setId(null);
        post = postRepos.save(post);
        postDto = converter.entityToDto(post);

        return postDto;
    }
    public PostDto updatePostBlog(PostDto postDto){
        checkPostBlogCorrectInput(postDto);
        checkPostBlogCorrectId(postDto.getId());

        Post post = converter.dtoToEntity(postDto);
        Post oldPost = postRepos.findById(post.getId()).get();
        post.setCreateDate(oldPost.getCreateDate());
        post = postRepos.save(post);
        postDto = converter.entityToDto(post);

        return postDto;
    }
    public void checkPostBlogCorrectInput(PostDto postDto){
        if(postDto.getTags() == null){
            throw new RuntimeException( "error! no tags!");
        }
        else if(postDto.getContent() == null){
            throw new RuntimeException( "error! no content!");
        }
        else if(postDto.getTitle() == null){
            throw new RuntimeException( "error! no title!");
        }

    }
    public void checkPostBlogCorrectId(Long id){
        if(id == null){
            throw new RuntimeException( "incorrect id! id null!");
        }
        else if(postRepos.findById(id).isEmpty()){
            throw new RuntimeException( "incorrect id! not found!");
        }

    }
    public void deletePostBlog(Long id){
        checkPostBlogCorrectId(id);
        postRepos.deleteById(id);
    }


}

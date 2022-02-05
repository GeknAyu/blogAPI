package ru.ayu.blog.converter;

import org.springframework.stereotype.Component;
import ru.ayu.blog.domain.Post;
import ru.ayu.blog.dto.PostDto;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostConverter {
    public PostDto entityToDto(Post post){
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setCreateDate(post.getCreateDate());
        dto.setTags(post.getTags());

        return dto;
    }

    public List<PostDto> entityToDto(List<Post> post){
        List<PostDto> dto  = new ArrayList<PostDto>();
        for(Post pb : post){
            PostDto postBlogElementDto  = new PostDto();
            postBlogElementDto.setId(pb.getId());
            postBlogElementDto.setTitle(pb.getTitle());
            postBlogElementDto.setContent(pb.getContent());
            postBlogElementDto.setCreateDate(pb.getCreateDate());
            postBlogElementDto.setTags(pb.getTags());

            dto.add(postBlogElementDto);
        }

        return dto;
    }

    public Post dtoToEntity(PostDto dto){
        Post post = new Post();
        post.setId(dto.getId());
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        post.setCreateDate(dto.getCreateDate());
        post.setTags(dto.getTags());

        return post;
    }

    public List<Post> dtoToEntity(List<PostDto> dto){
        List<Post> post = new ArrayList<Post>();
        for(PostDto pbd : dto){
            Post postElement = new Post();
            postElement.setId(pbd.getId());
            postElement.setTitle(pbd.getTitle());
            postElement.setContent(pbd.getContent());
            postElement.setCreateDate(pbd.getCreateDate());
            postElement.setTags(pbd.getTags());

            post.add(postElement);
        }

        return post;
    }
}

package ru.ayu.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.ayu.blog.converter.PostConverter;
import ru.ayu.blog.domain.Post;
import ru.ayu.blog.dao.PostDao;
import ru.ayu.blog.dto.PageDto;
import ru.ayu.blog.dto.PostDto;
import ru.ayu.blog.dto.SearchDto;
import ru.ayu.blog.repos.PostRepos;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    PostRepos postRepos;

    @Autowired
    PostConverter converter;

    @Autowired
    PostDao postDao;

    final Integer costPageNumber = 0;
    final Integer costPageSize = 6;

    public PageDto searchPages(SearchDto searchDto){
        Integer pageNumber = costPageNumber;
        Integer pageSize = costPageSize;

        if(searchDto.getPageNumber() != null){
            pageNumber = searchDto.getPageNumber();
        }
        if(searchDto.getPageSize() != null){
            pageSize = searchDto.getPageSize();
        }

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        List<Post> post = postDao.findController(searchDto.getTags(),searchDto.getTitle(),pageable);
        List<PostDto> postDto = converter.entityToDto(post);
        PageDto pageDto = new PageDto(searchDto, postDto);

        return pageDto;
    }

    public void checkPostBlogCorrectId(Long id){
        if(id == null){
            throw new RuntimeException("incorrect id! id null!");
        }
    }

    public PostDto searchPost(Long id){
        checkPostBlogCorrectId(id);

        PostDto postDto =converter.entityToDto(postRepos.findById(id).get());

        return postDto;
    }

}

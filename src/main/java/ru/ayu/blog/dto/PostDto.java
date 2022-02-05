package ru.ayu.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ayu.blog.domain.Tags;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long id;

    private String title;

    private String content;

    private Date createDate;

    private List<Tags> tags;

}

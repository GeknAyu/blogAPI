package ru.ayu.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ayu.blog.domain.Tags;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SearchDto {
    private String title;

    private List<Tags> tags;

    private Integer pageNumber;

    private Integer pageSize;

}

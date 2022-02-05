package ru.ayu.blog.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String content;

    private Date createDate;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Tags.class)
    private List<Tags> tags;

    public Post(String title, String content, Date createDate, List<Tags> tags) {
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.tags = tags;
    }

    public Post(String title, String content, List<Tags> tags) {
        this.title = title;
        this.content = content;
        this.tags = tags;
    }
}

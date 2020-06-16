package cn.tl.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Data

@Getter
@Setter

@Entity
@Table(name = "comment")
public class Comment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer id;

    @Column(name = "c_time")
    private String time;

    @Column(name = "c_content")
    private String content;

    @Column(name = "c_belong_category")
    private String belongCategory;

    @Column(name = "c_belong_article")
    private Integer belongArticle;
}

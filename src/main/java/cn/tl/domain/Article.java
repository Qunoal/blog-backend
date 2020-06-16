package cn.tl.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data

@Entity
@Table(name = "article")
public class Article implements Serializable {

    @Id
    @Column(name = "a_id")
    private Integer id;

    @Column(name = "a_title")
    private String title;

    @Column(name = "a_category")
    private String category;

    @Column(name = "a_release_time")
    private String releaseTime;

    @Column(name = "a_read_number")
    private Integer readNumber;

    @Column(name = "a_origin")
    private String origin;

    @Column(name = "a_introduce")
    private String introduce;

    @Column(name = "a_introduce_img")
    private String introduceImg;

    /**
     * 配置一对多的映射关系
     */
    @OneToMany(targetEntity = Comment.class)
    @JoinColumn(name = "c_belong_article", referencedColumnName = "a_id")
    private List<Comment> commentList = new ArrayList<Comment>();

}

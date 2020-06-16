package cn.tl.controller;

import cn.tl.dao.ArticleDao;
import cn.tl.dao.CommentDao;
import cn.tl.domain.Comment;
import cn.tl.domain.partArticle.ArticleRecommendVo;
import cn.tl.domain.partArticle.ArticleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

//解决跨域问题
@CrossOrigin(origins = {"*", "null"})

@RestController
public class RightController {
    // 初始值给5000个
    private long redHeartNumber = 5000L;

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ArticleDao articleDao;

    /**
     * 红心增加
     */
    @RequestMapping("/increase")
    public void redHeartIncrease () {
        this.redHeartNumber++;
    }

    /**
     * 获取红心数量
     *
     * @return
     */
    @RequestMapping("/redHeartNumber")
    public long getRedHeartNumber () {
        return this.redHeartNumber;
    }


    /**
     * 获取最新8条评论
     */
    @RequestMapping("/findNewComment")
    public List<Comment> findNewComment () {
        return commentDao.findNewComment(8);
    }


    /**
     * 获取观看人数最多的文章：右侧推荐文章, 返回自定义实体
     */
    @RequestMapping("/findRecommendArticle")
    public List<ArticleVo> findRecommendArticle () {

        List<ArticleVo> articleList = new ArrayList<ArticleVo>();

        /**
         * 查询实体的部分字段
         */
        List<ArticleRecommendVo> articleVo = articleDao.findRecommendArticle();

        for (ArticleRecommendVo v : articleVo) {

            ArticleVo a = new ArticleVo();

            a.setId(v.geta_id());
            a.setTitle(v.geta_title());
            a.setReadNumber(v.geta_read_number());

            articleList.add(a);
        }

        return articleList;
    }

}

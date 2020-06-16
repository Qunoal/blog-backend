package cn.tl.cn.tl;

import cn.tl.dao.ArticleDao;
import cn.tl.dao.CommentDao;
import cn.tl.domain.Comment;
import cn.tl.domain.partArticle.ArticleRecommendVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class testRight {

    @Autowired
    private CommentDao commentDao;
    @Autowired
    private ArticleDao articleDao;

    /**
     * 查询最新的10
     */
    @Test
    @Transactional
    public void test1 () {
        List<Comment> list = commentDao.findNewComment(8);
        for (Comment comment : list) {
            System.out.println(comment);
        }
    }

    /**
     * 查询推荐文章 10篇
     */
    @Test
    @Transactional
    public void test2 () {
        List<ArticleRecommendVo> vos = articleDao.findRecommendArticle();
        for (ArticleRecommendVo article : vos) {
            System.out.println(article.geta_title());
        }
    }
}

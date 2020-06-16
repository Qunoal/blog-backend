package cn.tl.cn.tl;

import cn.tl.dao.ArticleDao;
import cn.tl.dao.CommentDao;
import cn.tl.domain.Article;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testArticle {
    @Autowired
    private CommentDao commentDao;

    @Autowired
    private ArticleDao articleDao;


    /**
     * 查询所有文章
     */
    @Test
    @Transactional
    public void test () {
        List<Article> all = articleDao.findAll();
        for (Article article : all) {
            System.out.println(article);
        }
    }

    /**
     * 更具id查询文章
     */
    @Test
    @Transactional
    public void test2 () {
        Article article = articleDao.findById(1).get();
        System.out.println(article);
    }

}


















package cn.tl.controller;

import cn.tl.dao.ArticleDao;
import cn.tl.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//解决跨域问题
@CrossOrigin(origins = {"*", "null"})

@RestController
public class ArticleController {

    @Autowired
    private ArticleDao articleDao;

    /**
     * 查询10篇文章
     *
     * @return
     */
    @RequestMapping("/findArticleList")
    public List<Article> findAllArticle (@RequestParam String page) {
        int index = (Integer.parseInt(page) - 1) * 10;

        return articleDao.findLimitArticle(index);
    }

    /**
     * 获取所有的文章分类
     */
    @RequestMapping("/findCategory")
    public List<String> findCategory () {
        return articleDao.findCategory();
    }

    /**
     * 根据分类查询数据
     */
    @RequestMapping("/findAllCategoryArticleList")
    public List<Article> findAllCategoryArticleList (@RequestParam String category, @RequestParam String page) {
        int index = (Integer.parseInt(page) - 1) * 10;
        return articleDao.findByCategory(category, index);
    }

    /**
     * 根据id查询 文章数据
     */
    @RequestMapping("/findOne")
    public Article findOne (@RequestParam("aid") Integer aid) {
        return articleDao.findById(aid).get();
    }

    /**
     * 文章内容
     */
    @RequestMapping("/findContent")
    public List<String> findContent (@RequestParam("aid") Integer aid) {
        return articleDao.findContent(aid);
    }
}

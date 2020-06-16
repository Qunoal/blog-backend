package cn.tl.cn.tl;

import cn.tl.dao.CommentDao;
import cn.tl.domain.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class testComment {
    @Autowired
    private CommentDao commentDao;

    /**
     * 获取所有评论
     */
    @Test
    public void test1 () {
        List<Comment> all = commentDao.findAll();
        for (Comment comment : all) {
            System.out.println(comment);
        }
    }

    /**
     * 查询关于模块下的评论信息
     */
    @Test
    public void test2 () {
        // List<Comment> list = commentDao.findByBelongCategory("关于");
        // for (Comment comment : list) {
        //     System.out.println(comment);
        // }

        List<Comment> list = commentDao.findByBelongCategory("赞赏");
        for (Comment comment : list) {
            System.out.println(comment);
        }
    }
}

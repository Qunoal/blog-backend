package cn.tl.controller;

import cn.tl.dao.CommentDao;
import cn.tl.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
//解决跨域问题
@CrossOrigin(origins = {"*", "null"})
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    /**
     * 接收评论数据并保持到数据库
     *
     * @param comment
     */
    @RequestMapping("/saveComment")
    @Transactional
    public void saveComment (@RequestBody Comment comment) {
        commentDao.save(comment);
    }

    /**
     * 根据模块，查询该模块下的所有评论
     *
     * @param belong
     * @return
     */
    @RequestMapping("/findBelong")
    public List<Comment> findBelong (@RequestParam("belong") String belong) {
        return commentDao.findByBelongCategory(belong);
    }
}

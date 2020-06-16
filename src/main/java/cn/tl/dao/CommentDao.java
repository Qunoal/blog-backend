package cn.tl.dao;

import cn.tl.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment, Integer>, JpaSpecificationExecutor<Comment> {
    /**
     * 方法命名查询，根据 所属分类查询对应的评论信息 如：关于页面下的评论
     *
     * @param belong
     * @return
     */
    // @Query(value = "from Comment where belongCategory = ?1")
    List<Comment> findByBelongCategory (String belong);

    /**
     * 查询八条评论数据
     * @param limit
     * @return
     */
    @Query(value = "select * from comment WHERE c_belong_category is null order by c_id desc LIMIT 8", nativeQuery = true)
    List<Comment> findNewComment (Integer limit);
}

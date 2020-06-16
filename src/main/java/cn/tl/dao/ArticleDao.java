package cn.tl.dao;

import cn.tl.domain.Article;
import cn.tl.domain.partArticle.ArticleRecommendVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface ArticleDao extends JpaRepository<Article, Integer>, JpaSpecificationExecutor<Article> {
    /**
     * 获取所有分类
     *
     * @return
     */
    @Query(value = "select a_category from article group by a_category", nativeQuery = true)
    List<String> findCategory ();

    /**
     * limit查询,每页查询10条数据
     */
    @Query(value = "select a_id,a_title,a_category,a_release_time,a_read_number,a_origin,a_introduce,a_introduce_img from article limit ?1, 10", nativeQuery = true)
    List<Article> findLimitArticle (Integer page);

    /**
     * 根据文章分类获取所有文章
     *
     * @param category
     * @return
     */
    // /待优化
    @Query(value = "select a_id,a_title,a_category,a_release_time,a_read_number,a_origin,a_introduce,a_introduce_img from article where a_category = ?1 limit ?2, 10", nativeQuery = true)
    List<Article> findByCategory (String category, Integer page);

    /**
     * 获取观看人数最多的文章，推荐数据
     */
    // @Query(value = "select a.a_id,a.a_title,a.a_read_number from article as a order by a_read_number desc limit 10", nativeQuery = true)
    @Query(value = "select a_id,a_title,a_read_number from article order by a_read_number desc limit 10", nativeQuery = true)
    List<ArticleRecommendVo> findRecommendArticle ();

    /**
     * 根据id查询文章数据
     *
     * @return
     */
    @Query(value = "select a_id,a_title,a_category,a_release_time,a_read_number,a_origin,a_introduce,a_introduce_img from article where a_id = ?1", nativeQuery = true)
    Optional<Article> findById (Integer aid);

    /**
     * 根据id查询文章内容
     */
    @Query(value = "select a_content from article where a_id = ?1", nativeQuery = true)
    List<String> findContent (Integer aid);
}

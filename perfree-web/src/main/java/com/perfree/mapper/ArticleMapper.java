package com.perfree.mapper;

import com.perfree.model.Article;
import com.perfree.model.ArticleTag;
import com.perfree.model.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ArticleMapper {
    /**
     * 添加文章
     * @param article article
     * @return int
     */
    int add(Article article);

    /**
     * 关联文章和标签
     * @param articleTags articleTags
     */
    void addArticleTag(List<ArticleTag> articleTags);

    /**
     * 文章列表数据
     * @param article article
     * @return   List<Article>
     */
    List<Article> getList(Article article);

    /**
     * 根据文章id获取标签
     * @param id id
     * @return List<Tag>
     */
    List<Tag> getArticleTagById(String id);

    /**
     * 更改文章置顶状态
     * @param article article
     * @return int
     */
    int changeTopStatus(Article article);

    /**
     * 更改是否可以评论
     * @param article article
     * @return int
     */
    int changeCommentStatus(Article article);

    /**
     * 更改状态
     * @param article article
     * @return int
     */
    int changeStatus(Article article);

    /**
     * 删除文章
     * @param idArr idArr
     * @return int
     */
    int del(String[] idArr);

    /**
     * 根据id获取文章信息
     * @param id id
     * @return Article
     */
    Article getById(String id);

    /**
     * 删除文章和标签的关联
     * @param id id
     */
    void deleteTagByArticleId(String id);

    /**
     * 更新文章
     * @param article article
     * @return int
     */
    int update(Article article);

    /**
     * 获取文章数量
     * @return Long
     */
    Long getArticleCount();

    /**
     * 获取最新的22条文章(后台首页)
     * @return List<Article
     */
    List<Article> getArticleListByDashboard();

    /**
     * 获取热门文章
     * @return List<Article>
     */
    List<Article> getHotArticle();
}

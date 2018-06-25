package jp.co.rakus.ec201804b.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.Article;

@Repository
public class ArticleRepository {
	private static final RowMapper<Article> articleRowMapper = (rs, i) -> {
		Article article = new Article();
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		return article;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	public List<Article> findAllArticle() {
		String sql = "select * from articles where email=:email";
		List<Article> articleList = template.query(sql, articleRowMapper);
		return articleList;
	}

	public Article insertArticle(Article article) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(article);
		String sql = "insert into articles (name,content) values(:name,:content)";
		if (article.getId() != null) {
			throw new NullPointerException();
		}

		template.queryForObject(sql, param, articleRowMapper);
		return article;
	}
}
package jp.co.rakus.ec201804b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.AdminUser;

@Repository
public class AdminUserLoginRepository {
	private static final RowMapper<AdminUser> adminUserRowMapper = (rs, i) -> {
		AdminUser adminUser=new AdminUser();
		adminUser.setId(rs.getLong("id"));
		adminUser.setName(rs.getString("name"));
		adminUser.setEmail(rs.getString("email"));
		adminUser.setPassword(rs.getString("password"));
		return adminUser;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	public AdminUser findByAddress(String email) {
		String sql="select id,name,price,imagePath,deleted ";
		AdminUser adminUser =new AdminUser();
		SqlParameterSource param=new MapSqlParameterSource().addValue("email",email);
		adminUser=template.queryForObject(sql,param,adminUserRowMapper);
		return adminUser;
	}

}

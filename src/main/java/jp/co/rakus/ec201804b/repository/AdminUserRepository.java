package jp.co.rakus.ec201804b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.AdminUser;
import jp.co.rakus.ec201804b.domain.User;

@Repository
public class AdminUserRepository {
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

	public AdminUser findByEmail(String email) {
		try {
		String sql="select * from admin_users where email=:email";
		AdminUser adminUser =new AdminUser();
		SqlParameterSource param=new MapSqlParameterSource().addValue("email",email);
		adminUser=template.queryForObject(sql,param,adminUserRowMapper);
		return adminUser;
		}catch(Exception e) {
			return null;
		}
	}
	
	public AdminUser insert(AdminUser adminUser) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(adminUser);
		String sql = "insert into admin_users "
				+ " (name,email,password) values (:name,:email,:password)";
		try{
		template.update(sql, param);
		}catch(Exception e) {
		e.printStackTrace();
		}
		return adminUser;
	}

}

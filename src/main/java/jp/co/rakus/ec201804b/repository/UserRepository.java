package jp.co.rakus.ec201804b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.User;

@Repository
public class UserRepository {
	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
	//	user.setZipCode(rs.getString("zipCode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};
	
	private static final String TABLE_NAME = "kari"; //要編集
	@Autowired
	private NamedParameterJdbcTemplate template;

	public User findByAddress(String email) {
		String sql="select * from users where email=:email";
		User user =new User();
		SqlParameterSource param=new MapSqlParameterSource().addValue("email",email);
		user=template.queryForObject(sql,param,userRowMapper);
		return user;
	}

	public User insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "insert into " + TABLE_NAME
				+ " (name,email,password,zipCode,address,telephone) values (:name,:email,:password,:zipCode,:address,:telephone)";
		template.update(sql, param);
		return user;
	}
}
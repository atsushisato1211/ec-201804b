package jp.co.rakus.ec201804b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.User;



@Repository
public class UserRepository {
	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		User user=new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setZipCode(rs.getString("zipCode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		return user;
	};

	@Autowired
	private NamedParameterJdbcTemplate template;

	public User findByAddress(String email) {
		String sql="select id,name,email,password,zip_code,address,telephone where email=:email";
		User user =new User();
		SqlParameterSource param=new MapSqlParameterSource().addValue("email",email);
		user=template.queryForObject(sql,param,userRowMapper);
		return user;
	}
}
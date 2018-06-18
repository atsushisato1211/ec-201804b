package jp.co.rakus.ec201804b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.UserLoginForm;

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

	public User findByAddressAndPassword(Model model,UserLoginForm form) {
		String sql="";
		
		
		User user =new User();
		return user;
	}

}

package jp.co.rakus.ec201804b.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.User;

/**
 * 利用者情報を操作するレポジトリー.
 * 
 * @author Nanami.Sasaki
 *
 */
@Repository
public class UserRepository {
	private static final RowMapper<User> userRowMapper = (rs, i) -> {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setName(rs.getString("name"));
		user.setEmail(rs.getString("email"));
		user.setPassword(rs.getString("password"));
		user.setZipCode(rs.getString("zipcode"));
		user.setAddress(rs.getString("address"));
		user.setTelephone(rs.getString("telephone"));
		user.setQuestion(rs.getString("question"));
		return user;
	};

	private static final String TABLE_NAME = "users"; // 要編集
	@Autowired
	private NamedParameterJdbcTemplate template;

	/**
	 * メールアドレスからユーザー検索を行うメソッド.
	 * 
	 * @param email　メールアドレス
	 * @return　Userオブジェクトを返す
	 */
	public User findByEmail(String email) {
		try {
			String sql = "select id,name,email,password,zipcode,address,telephone,question from " + TABLE_NAME
					+ " where email=:email";
			User user = new User();
			SqlParameterSource param = new MapSqlParameterSource().addValue("email", email);
			user = template.queryForObject(sql, param, userRowMapper);
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * ユーザー登録を行うメソッド.
	 * 
	 * @param user　Userオブジェクト
	 * @return　Userオブジェクト
	 */
	public User insert(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "insert into users "
				+ " (name,email,password,zipcode,address,telephone,question) values (:name,:email,:password,:zipCode,:address,:telephone,:question)";
		try {
			template.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * ユーザー情報の変更を行うメソッド.
	 * 
	 * @param user　Userオブジェクト
	 */
	public void update(User user) {
		SqlParameterSource param = new BeanPropertySqlParameterSource(user);
		String sql = "update users"
				+ " set name=:name,email=:email,zipcode=:zipCode,address=:address,telephone=:telephone where id=:id";
		try {
			template.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * パスワードの変更を行うメソッド.
	 * 
	 * @param password　パスワード
	 * @param id　ID
	 */
	public void changeUserPassword(String password,Long id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("password", password).addValue("id", id);
		String sql = "update users set password=:password where id=:id";

		try {
			template.update(sql, param);
		} catch (Exception e) {
			e.printStackTrace();// エラー文を出してくれる
		}
	}

	/**
	 * IDからユーザー情報の検索を行うメソッド.
	 * 
	 * @param id　ID
	 * @return　Userオブジェクト
	 */
	public User load(Long id) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		String sql = "select id,name,email,password,zipCode,address,telephone,question from users where id=:id";

		try {
			User user = template.queryForObject(sql, param, userRowMapper);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * メールアドレスと秘密の質問からユーザー情報の検索を行うメソッド.
	 * 
	 * @param email　メールアドレス　
	 * @param question　秘密の質問
	 * @return Userオブジェクト
	 */
	public User searchByEmailAndQuestion(String email,String question) {
		SqlParameterSource param=new MapSqlParameterSource().addValue("email", email).addValue("question", question);
		String sql="select id,name,email,password,zipCode,address,telephone,question from users where email=:email and question=:question";
		
		try {
			User user=template.queryForObject(sql, param, userRowMapper);
			return user;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
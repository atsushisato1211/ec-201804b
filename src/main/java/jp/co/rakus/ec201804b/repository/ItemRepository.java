package jp.co.rakus.ec201804b.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jp.co.rakus.ec201804b.domain.Item;



/**
 * 商品repository.
 * @author kohei.takahashi
 *
 */
@Repository
@Transactional
public class ItemRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final String TABLE_NAME = "items";
	
	private static final RowMapper<Item> ITEM_ROWMAPPEP = (rs, i) -> {
		Item item = new Item();

		item.setId(rs.getLong("id"));
		item.setName(rs.getString("name"));
		item.setDescription(rs.getString("description"));
		item.setPrice(rs.getInt("price"));
		item.setImagePath(rs.getString("imagePath"));
		item.setDeleted(rs.getBoolean("deleted"));
		return item;
	};
	
	/**
	 * 1件検索を行うメソッド.
	 * @param id 商品id
	 * @return 商品の詳細情報
	 * 全件検索は後で修正
	 */
	public Item load(Integer id) {
		String sql = "select * from " + TABLE_NAME + " where deleted=true and id=:id order by id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("id", id);
		Item itemdetail = template.queryForObject(sql, param,ITEM_ROWMAPPEP);
		return itemdetail;
	}
	
	/**
	 * 管理者の全件検索を行うメソッド.
	 * @return itemList アイテムリスト
	 */
	public List<Item> findAll() {
		String sql = "select * from " + TABLE_NAME + " order by id";
		List<Item> itemList = template.query(sql, ITEM_ROWMAPPEP);
		return itemList;
	}
	
	/**
	 * userの全件検索を行うメソッド.
	 * @return itemList アイテムリスト 削除フラグがtrueのみ
	 */
	public List<Item> findAllByNotDeleted() {
		String sql = "select * from " + TABLE_NAME + " where deleted=true order by id";
		List<Item> itemList = template.query(sql, ITEM_ROWMAPPEP);
		return itemList;
	}
	/**
	 * 名前検索を行うメソッド.
	 * @param name 商品名
	 * @return itemList アイテムリスト
	 */
	public List<Item>findByName(String name){
		String sql = "select * from " + TABLE_NAME + " where name like :name order by id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%"+name+"%");
		List<Item>itemList=template.query(sql, param,ITEM_ROWMAPPEP);
		return itemList;
	}
	/**
	 * 名前検索を行うメソッド.
	 * @param name 商品名
	 * @return itemList アイテムリスト
	 */
	public List<Item>findByNameAndNotDeleted(String name){
		String sql = "select * from " + TABLE_NAME + " where deleted=true and name like :name order by id";
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", "%"+name+"%");
		List<Item>itemList=template.query(sql, param,ITEM_ROWMAPPEP);
		return itemList;
	}
	
	/**
	 * 管理者の削除フラグの変更.
	 * @param id 商品id
	 * @param deleted 削除フラグ
	 */
	public void changeByDeleted(Integer id,Boolean deleted) {
		String sql = "update items set deleted=:deleted where id=:id";
//		UPDATE  items  SET deleted = false where id = 1
		SqlParameterSource param = new MapSqlParameterSource().addValue("deleted", deleted).addValue("id", id);
		template.update(sql, param);
	}

}

package jp.co.rakus.ec201804b.repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.OrderItem;


@Repository
public class OrderItemRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static String TABLE_NAME = "order_items";
	
	private static final RowMapper<OrderItem> ORDERITEM_ROWMAPPER=(rs,i)->{
		OrderItem orderItem = new OrderItem();
		orderItem.setId(rs.getLong("id"));
		orderItem.setItemId(rs.getLong("item_id"));
		orderItem.setOrderId(rs.getLong("order_id"));
		orderItem.setQuantity(rs.getInt("quantity"));
		return orderItem;
	};
	
	public List<OrderItem> findByItemId(long itemId) {
		try {
			String sql="select id,item_id,order_id,quantity from " + TABLE_NAME + " where item_id=:itemId"; 
			SqlParameterSource param = new MapSqlParameterSource().addValue("itemId", itemId);
			List<OrderItem> orderItem = template.query(sql, param, ORDERITEM_ROWMAPPER);
			return orderItem;
		}catch (Exception e) {
			System.out.println("sqlエラー");
			return null;
		}
	}
	
}

package jp.co.rakus.ec201804b.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;

@Repository
public class OrderRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	private final static String TABLE_NAME = "orders";
	
	private final static ResultSetExtractor<List<Order>> ORDER_RSE = new ResultSetExtractor<List<Order>>() {
		@Override
		public List<Order> extractData(ResultSet rs) throws SQLException, DataAccessException {
			List<Order> orderList = new ArrayList<>();
			Order order = null;
			long beforOrderId = 0;
			while (rs.next()) {
				long currentOrderId = rs.getInt("order_id");
				System.out.println(currentOrderId);
				if (currentOrderId != beforOrderId) {
					order = new Order();
					order.setId(currentOrderId);
					order.setOrderNumber(rs.getString("order_number"));
					order.setStatus(rs.getLong("status"));
					order.setOrderItemList(new ArrayList<OrderItem>());
					order.setTotalPrice(rs.getInt("total_price"));
					order.setOrderDate(rs.getDate("order_date"));
					order.setDeliveryName(rs.getString("delivery_name"));
					order.setDeliveryEmail(rs.getString("delivery_email"));
					order.setDeliveryZipCode(rs.getString("delivery_zip_code"));
					order.setDeliveryAddress(rs.getString("delivery_address"));
					order.setDeliveryTel(rs.getString("delivery_tel"));
					orderList.add(order);
				}
				if (rs.getInt("orderitem_order_id") == 0) {
					continue;
				}
				
				OrderItem orderItem = new OrderItem();
				orderItem.setId(rs.getLong("id"));
				orderItem.setItemId(rs.getLong("item_id"));
				Item item = new Item();
				item.setName(rs.getString("item_name"));
				item.setPrice(rs.getInt("item_price"));
				item.setDescription(rs.getString("description"));
				item.setImagePath(rs.getString("imagePath"));
				item.setDeleted(rs.getBoolean("deleted"));
				orderItem.setItem(item);
				orderItem.setOrderId(rs.getLong("orderitem_order_id"));
				orderItem.setQuantity(rs.getInt("orderitem_quantity"));
				order.getOrderItemList().add(orderItem);
				beforOrderId = currentOrderId;
			}
			return orderList;
		}
	};
	
	public List<Order> findAll() {
		String sql = "o.order";
		List<Order> orderList = template.query(sql, ORDER_RSE);
		return orderList; 
	}

}

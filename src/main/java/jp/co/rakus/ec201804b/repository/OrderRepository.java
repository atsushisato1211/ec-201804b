package jp.co.rakus.ec201804b.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.OrderItem;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.form.ItemForm;

@Repository
public class OrderRepository {
	
	@Autowired
	private HttpSession session;

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
				if (currentOrderId != beforOrderId) {
					order = new Order();
					order.setId(currentOrderId);
					order.setOrderNumber(rs.getString("order_number"));
					order.setStatus(rs.getInt("status"));
					order.setUserId(rs.getLong("user_id"));
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
				orderItem.setOrderId(rs.getLong("orderitem_order_id"));
				orderItem.setQuantity(rs.getInt("orderitem_quantity"));
				
				Item item = new Item();
				item.setName(rs.getString("item_name"));
				item.setPrice(rs.getInt("item_price"));
				item.setDescription(rs.getString("description"));
				item.setImagePath(rs.getString("imagePath"));
				item.setDeleted(rs.getBoolean("deleted"));
				orderItem.setItem(item);
				
				order.getOrderItemList().add(orderItem);
				beforOrderId = currentOrderId;
			}
			return orderList;
		}
	};
	
	public List<Order> findAll() {
		List<Order> orderList = new ArrayList<>();
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id)";
		orderList = template.query(sql, ORDER_RSE);
		return orderList;
	}
	

	public Order load(long id) {
		try {
		SqlParameterSource param = new MapSqlParameterSource().addValue("id",id);
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where order_id = :id";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		return orderList.get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
	public Order findByUserId(long userId,long orderId) {
		try {
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId).addValue("orderId", orderId);
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where user_id = :userId and order_id=:orderId";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		return orderList.get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
	public void update(int status,Long id) {
		
		SqlParameterSource param=new MapSqlParameterSource().addValue("status", status).addValue("id", id);
		String sql="update orders set status=:status where id=:id";
		
		template.update(sql, param);
	}
	
	public void updateById(User user, Long id) {
		Long userId = user.getId();
		String userName = user.getName();
		String userEmail = user.getEmail();
		String userAddress = user.getAddress();
		String userTel = user.getTelephone();
		String userZipCode = user.getZipCode();
		SqlParameterSource param=new MapSqlParameterSource().addValue("userId", userId)
				.addValue("userName", userName).addValue("userEmail", userEmail)
				.addValue("userAddress", userAddress).addValue("userTel", userTel)
				.addValue("userZipCode", userZipCode).addValue("id", id);
		String sql="update orders set user_id=:userId, deliveryName=:userName, "
				+ " deliveryEmail=:userEmail, deliveryAddress=:userAddress, "
				+ " deliveryTel=:userTel, deliveryZipCode=:userZipCode where id=:id";
		
		template.update(sql, param);
	}
	

	public void insertOrder(Order order) {
		if (order.getId() == null) {
			if(MaxOrderId() != null)
				order.setId(MaxOrderId());
			else
				order.setId((long) 1);
		}
		if (order.getOrderNumber() == null) {
			if(MaxOrderId() != null)
				order.setOrderNumber(String.valueOf(MaxOrderId()));
			else
				order.setOrderNumber("1");
		}
		session.setAttribute("orderId", order.getId());
		System.out.println(order.getId());
		try {
			String sql = "insert into orders values(:id,:orderNumber,:userId,:status,:totalPrice,:orderDate,:deliveryName,:deliveryEmail,:deliveryZipCode,:deliveryAddress,:deliveryTel)";
			SqlParameterSource param = new BeanPropertySqlParameterSource(order);
			template.update(sql, param);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}	
	public Long MaxOrderId() {
		String sql = "select max(id)+1 from orders";
		SqlParameterSource param = new MapSqlParameterSource();

		return template.queryForObject(sql, param, Long.class);
	}


	public void insertOrderItem(OrderItem orderItem) {
		System.out.println("insertを呼ばれました");
		if (orderItem.getId() == null) {
			if(MaxOrderItemId() != null)
				orderItem.setId(MaxOrderItemId());
			else
				orderItem.setId((long) 1);
		}
		
		orderItem.setOrderId((Long) session.getAttribute("orderId"));
		try {
			String sql = "insert into order_items values(:id,:itemId,:orderId,:quantity)";
			SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);
			template.update(sql, param);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Long MaxOrderItemId() {
		String sql = "select max(id)+1 from order_items";
		SqlParameterSource param = new MapSqlParameterSource();

		return template.queryForObject(sql, param, Long.class);
	}
	
	public void deleteByItemId() {
		
	}
	


}

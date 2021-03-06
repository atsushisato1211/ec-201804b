package jp.co.rakus.ec201804b.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
				item.setStock(rs.getInt("stock"));
				item.setProceed(rs.getInt("proceed"));
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
				+ "i.price as item_price, description, imagePath, deleted,stock,proceed from orders o "
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
				+ "i.price as item_price, description, imagePath, deleted,stock,proceed from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where order_id = :id";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		return orderList.get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
	public Order findByUserIdAndOrderId(long userId,long orderId) {
		try {
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId).addValue("orderId", orderId);
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted,stock,proceed from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where user_id = :userId and order_id=:orderId";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		return orderList.get(0);
		}catch (Exception e) {
			return null;
		}
	}
	
	public List<Order> findByOrderId(long orderId) {
		try {
		SqlParameterSource param = new MapSqlParameterSource().addValue("orderId", orderId);
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted,stock,proceed from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where order_id=:orderId";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		return orderList;
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
		String sql="update orders set user_id=:userId, delivery_name=:userName, "
				+ " delivery_email=:userEmail, delivery_address=:userAddress, "
				+ " delivery_tel=:userTel, delivery_zip_code=:userZipCode where id=:id";
		
		template.update(sql, param);
	}
	
	public Order findByUserIdAndStatus(Long userId, Integer status) {
		try {
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId).addValue("status", status);
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted,stock ,proceed from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where user_id = :userId and status=:status";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		return orderList.get(0);
	}catch (Exception e) {
		return null;
	}
	}

	public void insertOrder(Order order) {
		if (order.getId() == null) {
			if(MaxOrderId() != null)
				order.setId(MaxOrderId());
			else
				order.setId((long) 1);
		}
		int year = LocalDate.now().getYear();
		String number = year + "000000";
		order.setOrderNumber(number);
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
	
	
	
	public void updateOrderItem(OrderItem orderItem) {
		System.out.println("updateOrderItemを呼ばれました");
		if(orderItem.getOrderId()==null)
			orderItem.setOrderId((Long) session.getAttribute("orderId"));
		try {
			
			String sql = "update order_items set quantity=quantity+:quantity where item_id=:ItemId and order_id=:orderId";
			SqlParameterSource param = new BeanPropertySqlParameterSource(orderItem);
			template.update(sql, param);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void insertOrderItem(OrderItem orderItem) {
		System.out.println("insertを呼ばれました");
		if (orderItem.getId() == null) {
			if(MaxOrderItemId() != null)
				orderItem.setId(MaxOrderItemId());
			else
				orderItem.setId((long) 1);
		}
//		if(orderItem.getOrderId()==null)
//			orderItem.setOrderId((Long) session.getAttribute("orderId"));
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
	
	public void deleteByItemId(long itemId,long orderId) {
		System.out.println("deleteを呼ばれました");
		
		try {
			SqlParameterSource param=new MapSqlParameterSource().addValue("itemId", itemId).addValue("orderId", orderId);
			String sql = "delete from order_items where item_id=:itemId and order_id=:orderId";
			template.update(sql, param);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public Order findByUserId(Long userId) {
		SqlParameterSource param = new MapSqlParameterSource().addValue("userId",userId);
		String sql = "select o.id as order_id, order_number, user_id, status, "
				+ "total_price, order_date, delivery_name,delivery_email,"
				+ " delivery_zip_code, delivery_address, delivery_tel, oi.id as id,"
				+ "oi.item_id as item_id, oi.order_id as orderitem_order_id, "
				+ "oi.quantity as orderitem_quantity, i.name as item_name, "
				+ "i.price as item_price, description, imagePath, deleted,stock,proceed from orders o "
				+ "left outer join order_items oi "
				+ "on (o.id = oi.order_id) "
				+ "join items i on (oi.item_id = i.id) where user_id = :userId";
		List<Order> orderList = template.query(sql, param, ORDER_RSE);
		if(orderList.size() == 0) {
			return null;
		}
		return orderList.get(0);
		
	}


	public void updateByOrderId(Long guestOrderId, Long loginOrderId) {
		SqlParameterSource param=new MapSqlParameterSource().addValue("guestOrderId", guestOrderId).addValue("loginOrderId", loginOrderId);
		String sql="update order_items set order_id=:loginOrderId where order_id=:guestOrderId";
		
		template.update(sql, param);
	}


	public void deleteByOrderId(Long guestOrderId) {
System.out.println("deleteを呼ばれました");
		
		try {
			SqlParameterSource param=new MapSqlParameterSource().addValue("orderId", guestOrderId);
			String sql = "delete from order_items where order_id=:orderId";
			template.update(sql, param);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	public void updatetoralPrice(Integer totalPrice, Long orderId) {
		SqlParameterSource param=new MapSqlParameterSource().addValue("totalPrice", totalPrice).addValue("orderId", orderId);
		String sql="update orders set total_price=:totalPrice where id=:orderId";
		template.update(sql, param);
		
	}
	
	
	public Integer MaxNumber() {
		SqlParameterSource param = new MapSqlParameterSource();

		
		String sql = "select order_number from orders";
		List<String> numberList= template.queryForList(sql,param, String.class);
		int maxNumber = 0;
		for (String number : numberList) {
			int numberInt = Integer.parseInt(number);
			if(maxNumber < numberInt) {
				maxNumber = numberInt;
			}
		}
		return maxNumber;
	}

	
	
	public void updateNumber(Long orderId) {
		int number = MaxNumber();
		//テーブルにある一番大きいnumberをとってくる
		int orderNumber = number + 1;
		SqlParameterSource param=new MapSqlParameterSource().addValue("orderNumber",String.valueOf(orderNumber)).addValue("id", orderId);
		String sql="update orders set order_number=:orderNumber where id=:id";
		template.update(sql, param);
		
	}
	


}

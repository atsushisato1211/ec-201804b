package jp.co.rakus.ec201804b;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.repository.OrderRepository;
import jp.co.rakus.ec201804b.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	/** DBから情報を得るためのリポジトリ */
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private HttpSession session;

	@Autowired
	private HttpServletRequest request;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String) DBから検索をし、ログイン情報を構成して返す。
	 */
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println("user1");
		User user = userRepository.findByEmail(email);

		if (user == null) {
			throw new UsernameNotFoundException("そのEmailは登録されていません。");
		}
		// orderIdを引っ張ってくる
		System.out.println(session.getAttribute("userId"));
		
		
		if (session.getAttribute("userId") != null) {
			Long guestUserId = (Long) session.getAttribute("userId");
			System.out.println(guestUserId);
			//購入前のものを取ってくる(ゲスト)
			Order guestOrder = orderRepository.findByUserIdAndStatus(guestUserId, 0);
			
			if (guestOrder != null) {
				//とってきたやつのorderId
				Long guestOrderId = guestOrder.getId();
				Order loginUserOrder = orderRepository.findByUserIdAndStatus(user.getId(), 0);
				
				if(loginUserOrder !=null) {
					Long loginOrderId = loginUserOrder.getId();
					orderRepository.updateByOrderId(guestOrderId, loginOrderId);
					orderRepository.deleteByOrderId(guestOrderId);
				}
				//前のuserIdでショッピングカートを検索preOrder
				//それがもしあったらそのidでupdateOrderId
				//前のいらないのをdelete
				orderRepository.updateById(user, guestOrderId);//一番最後
				session.removeAttribute("userId");
			}
		}

		// 権限付与の例
		Collection<GrantedAuthority> authorityList = new ArrayList<>();
		authorityList.add(new SimpleGrantedAuthority("ROLE_MEMBER")); // ユーザ権限付与
		// if(member.isAdmin()) {
		// authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // 管理者権限付与
		// }
		return new LoginUser(user, authorityList);

	}

}

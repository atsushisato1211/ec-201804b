package jp.co.rakus.ec201804b;

import java.util.ArrayList;
import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import jp.co.rakus.ec201804b.domain.LoginUser;
import jp.co.rakus.ec201804b.domain.User;
import jp.co.rakus.ec201804b.repository.UserRepository;

public class UserDetailsServiceImpl {
	@Service
	public class MemberDetailsServiceImpl implements UserDetailsService {
		/** DBから情報を得るためのリポジトリ */
		@Autowired
		private UserRepository userRepository;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.security.core.userdetails.UserDetailsService#
		 * loadUserByUsername(java.lang.String) DBから検索をし、ログイン情報を構成して返す。
		 */
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			User user = userRepository.findByEmail(email);

			if (user == null) {
				throw new UsernameNotFoundException("そのEmailは登録されていません。");
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
}

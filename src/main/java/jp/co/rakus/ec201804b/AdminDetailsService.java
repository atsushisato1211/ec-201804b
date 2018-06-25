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

import jp.co.rakus.ec201804b.domain.AdminUser;
import jp.co.rakus.ec201804b.domain.LoginAdminUser;
import jp.co.rakus.ec201804b.repository.ArticleRepository;

@Service
public class AdminDetailsService implements UserDetailsService {
	
	
		/** DBから情報を得るためのリポジトリ */
		@Autowired
		private ArticleRepository adminUserRepository;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.security.core.userdetails.UserDetailsService#
		 * loadUserByUsername(java.lang.String) DBから検索をし、ログイン情報を構成して返す。
		 */
		@Override
		public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
			AdminUser adminUser = adminUserRepository.findByEmail(email);
			System.out.println("admin1");

			if (adminUser == null) {
				throw new UsernameNotFoundException("そのEmailは登録されていません。");
			}
			
			// 権限付与の例
			Collection<GrantedAuthority> authorityList = new ArrayList<>();
			authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // ユーザ権限付与
			// if(member.isAdmin()) {
			// authorityList.add(new SimpleGrantedAuthority("ROLE_ADMIN")); // 管理者権限付与
			// }
			return new LoginAdminUser(adminUser, authorityList);

		}
	
}
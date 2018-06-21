package jp.co.rakus.ec201804b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig {

	@Configuration
	@Order(2)
	//１から最初に見るので、1でユーザーだけを記述しないとダメ
	public static class UserConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		private UserDetailsServiceImpl userDetailsService;

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/css/**", "/img/**", "/js/**", "/fonts/**");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.antMatcher("/user/**")
			.authorizeRequests() // 認可に関する設定
					.antMatchers("/user/index", "/user/item**","/user/insert", "/user/show", "/user/form", "/user/create").permitAll() // 「/」などのパスは全てのユーザに許可
					//ユーザーがいけるパスだけを記述する
					// .antMatchers("/admin/**").hasRole("ADMIN") //
					// /admin/から始まるパスはADMIN権限でログインしている場合のみアクセス可(権限設定時の「ROLE_」を除いた文字列を指定)
					.antMatchers("/user/payment/**").hasRole("MEMBER") //
					// /member/から始まるパスはMEMBER権限でログインしている場合のみアクセス可(権限設定時の「ROLE_」を除いた文字列を指定)
					.anyRequest().authenticated();

			// BASIC認証の有効化
			// http.httpBasic().disable();
			http.formLogin() // ログインに関する設定
					.loginPage("/user/index") // ログイン画面に遷移させるパス(ログイン認証が必要なパスを指定してかつログインされていないとこのパスに遷移される)
					.loginProcessingUrl("/user/login") // ログインボタンを押した際に遷移させるパス(ここに遷移させれば自動的にログインが行われる)
					.failureUrl("/user/index?error=true") // ログイン失敗に遷移させるパス
					.defaultSuccessUrl("/user/item", false) // 第1引数:デフォルトでログイン成功時に遷移させるパス
														// 第2引数: true :認証後常に第1引数のパスに遷移
														// false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
					.usernameParameter("email") // 認証時に使用するユーザ名のリクエストパラメータ名(今回はメールアドレスを使用)
					.passwordParameter("password"); // 認証時に使用するパスワードのリクエストパラメータ名

			http.logout() // ログアウトに関する設定
					.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout**")) // ログアウトさせる際に遷移させるパス
					.logoutSuccessUrl("/user/index") // ログアウト後に遷移させるパス(ここではログイン画面を設定)
					.deleteCookies("JSESSIONID") // ログアウト後、Cookieに保存されているセッションIDを削除
					.invalidateHttpSession(true); // true:ログアウト後、セッションを無効にする false:セッションを無効にしない
		}

		/**
		 * 「認証」に関する設定.<br>
		 * 認証ユーザを取得する「UserDetailsService」の設定や<br>
		 * パスワード照合時に使う「PasswordEncoder」の設定
		 * 
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
		 */
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}

		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}
	
	@Configuration
	@Order(1)
	public static class AdminConfigurerAdapter extends WebSecurityConfigurerAdapter {
		@Autowired
		private AdminDetailsService adminDetailsService;

		@Override
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/css/**", "/img/**", "/js/**", "/fonts/**");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.antMatcher("/admin/**").authorizeRequests() // 認可に関する設定
					.antMatchers("/admin/index").permitAll() // 「/」などのパスは全てのユーザに許可
					.antMatchers("/admin/form", "/admin/menu","/admin/viewItemInsert","/admin/viewList","/admin/orderList", "/admin/orderDetail**").hasRole("ADMIN") //
					// /admin/から始まるパスはADMIN権限でログインしている場合のみアクセス可(権限設定時の「ROLE_」を除いた文字列を指定)
					// .antMatchers("/member/**").hasRole("MEMBER") //
					// /member/から始まるパスはMEMBER権限でログインしている場合のみアクセス可(権限設定時の「ROLE_」を除いた文字列を指定)
					.anyRequest().authenticated();

			// BASIC認証の有効化
			// http.httpBasic().disable();
			http.formLogin() // ログインに関する設定
					.loginPage("/admin/index") // ログイン画面に遷移させるパス(ログイン認証が必要なパスを指定してかつログインされていないとこのパスに遷移される)
					.loginProcessingUrl("/admin/login") // ログインボタンを押した際に遷移させるパス(ここに遷移させれば自動的にログインが行われる)
					.failureUrl("/admin/index?adminError=true") // ログイン失敗に遷移させるパス
					.defaultSuccessUrl("/admin/menu", false) // 第1引数:デフォルトでログイン成功時に遷移させるパス
														// 第2引数: true :認証後常に第1引数のパスに遷移
														// false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
					.usernameParameter("email") // 認証時に使用するユーザ名のリクエストパラメータ名(今回はメールアドレスを使用)
					.passwordParameter("password"); // 認証時に使用するパスワードのリクエストパラメータ名

			http.logout() // ログアウトに関する設定
					.logoutRequestMatcher(new AntPathRequestMatcher("/admin/logout**")) // ログアウトさせる際に遷移させるパス
					.logoutSuccessUrl("/admin/index") // ログアウト後に遷移させるパス(ここではログイン画面を設定)
					.deleteCookies("JSESSIONID") // ログアウト後、Cookieに保存されているセッションIDを削除
					.invalidateHttpSession(true); // true:ログアウト後、セッションを無効にする false:セッションを無効にしない
		}

		/**
		 * 「認証」に関する設定.<br>
		 * 認証ユーザを取得する「UserDetailsService」の設定や<br>
		 * パスワード照合時に使う「PasswordEncoder」の設定
		 * 
		 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder)
		 */
		@Override
		public void configure(AuthenticationManagerBuilder auth) throws Exception {
			auth.userDetailsService(adminDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		}

		@Bean
		PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}
}
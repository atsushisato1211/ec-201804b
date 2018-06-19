package jp.co.rakus.ec201804b;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jp.co.rakus.ec201804b.repository.UserRepository;
@Configuration 
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Autowired
	private UserRepository repository;
	
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.antMatchers( "/css/**"
						, "/img/**"
						, "/js/**"
						, "/fonts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		
		http.authorizeRequests() // 認可に関する設定
		.antMatchers("/", "/index").permitAll() //「/」などのパスは全てのユーザに許可
		//.antMatchers("/admin/**").hasRole("ADMIN") // /admin/から始まるパスはADMIN権限でログインしている場合のみアクセス可(権限設定時の「ROLE_」を除いた文字列を指定)
		//.antMatchers("/member/**").hasRole("MEMBER") // /member/から始まるパスはMEMBER権限でログインしている場合のみアクセス可(権限設定時の「ROLE_」を除いた文字列を指定)
		.anyRequest().authenticated();
		
		
		// BASIC認証の有効化
		http.httpBasic().disable();
		http.formLogin() // ログインに関する設定
				.loginPage("/index") // ログイン画面に遷移させるパス(ログイン認証が必要なパスを指定してかつログインされていないとこのパスに遷移される)
				.loginProcessingUrl("/login") // ログインボタンを押した際に遷移させるパス(ここに遷移させれば自動的にログインが行われる)
				.failureUrl("/?error=true") // ログイン失敗に遷移させるパス
				.defaultSuccessUrl("/user/item", false) // 第1引数:デフォルトでログイン成功時に遷移させるパス
														// 第2引数: true :認証後常に第1引数のパスに遷移
														// false:認証されてなくて一度ログイン画面に飛ばされてもログインしたら指定したURLに遷移
				.usernameParameter("email") // 認証時に使用するユーザ名のリクエストパラメータ名(今回はメールアドレスを使用)
				.passwordParameter("password"); // 認証時に使用するパスワードのリクエストパラメータ名

		http.logout() // ログアウトに関する設定
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout**")) // ログアウトさせる際に遷移させるパス
				.logoutSuccessUrl("/index") // ログアウト後に遷移させるパス(ここではログイン画面を設定)
				.deleteCookies("JSESSIONID") // ログアウト後、Cookieに保存されているセッションIDを削除
				.invalidateHttpSession(true); // true:ログアウト後、セッションを無効にする false:セッションを無効にしない
	}
}
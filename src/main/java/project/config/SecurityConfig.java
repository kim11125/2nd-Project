package project.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	//접근권한 관련
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/","/login", "/reg").permitAll()
			//나머지는 인증
			.anyRequest().authenticated()
			;
		
		
		http.formLogin()
			.loginPage("/loginPage")
			.loginProcessingUrl("/login/proc")
			.usernameParameter("userId")
			.passwordParameter("pw")
			;
			
	}
	
	//패스워드 암호화
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//무시처리
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
	;
}
	
	
	

}

package be.sdutry.kombinedsite;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/", "/user/register").permitAll()
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/user/login")
				.permitAll()
				.and()
			.logout()
				.permitAll();
	}
	
	@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder().username("admin@kombined.be").password("admin").roles("USER", "ADMIN").build();
		UserDetails test = User.withDefaultPasswordEncoder().username("test@kombined.be").password("test").roles("USER").build();
		
		return new InMemoryUserDetailsManager(admin, test);
	}
}

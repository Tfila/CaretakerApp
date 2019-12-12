package pl.sullag.caretakerapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("mery@gm.pl")
                .password(passwordEncoder.encode("Ab1234.,"))
                .roles("USER");
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password(passwordEncoder.encode("admin"))
                .roles("ADMIN");

        auth.jdbcAuthentication()
                .usersByUsernameQuery(
                        "SELECT u.email, u.password, 1 " +
                                "FROM Users u " +
                                "WHERE u.email = ?"
                )
                .authoritiesByUsernameQuery(
                        "SELECT u.email, u.role, 1 " +
                                "FROM Users u " +
                                "WHERE u.email = ?"
                )
                .passwordEncoder(passwordEncoder)
                .dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin**").hasRole("ADMIN")
                .anyRequest().authenticated()
               .and()
               .formLogin().loginPage("/login")
                .loginProcessingUrl("/processLogin")
                .defaultSuccessUrl("/index",true)
                .and()
                .logout().permitAll();
    }
}

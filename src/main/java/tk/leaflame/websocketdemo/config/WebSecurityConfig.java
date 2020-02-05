package tk.leaflame.websocketdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import tk.leaflame.websocketdemo.component.AuthenticationAccessDeniedHandler;
import tk.leaflame.websocketdemo.filter.CorsFilter;
import tk.leaflame.websocketdemo.filter.JwtFilter;
import tk.leaflame.websocketdemo.filter.JwtLoginFilter;
import tk.leaflame.websocketdemo.service.UserService;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationAccessDeniedHandler accessDeniedHandler;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
//        http
//                .authorizeRequests()
//                .antMatchers("/resources/**").permitAll()
//                .and()
//                .csrf().disable()
//                .formLogin()
//                .loginPage("/login.html").permitAll()
//                .loginProcessingUrl("/login")
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .defaultSuccessUrl("/room.html", true);
//    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/index.html", "/static/**", "/swagger-ui.html",
                        "/webjars/**", "/swagger-resources/**", "/v2/**", "/favicon.ico");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {//auth
//        auth.inMemoryAuthentication()
//                .withUser("leaf")
//                .password("$2a$10$NKh/vEbUy3i1MtXpLV5VAeW4RElCSAjp7oKBgCYv7t4guq.0NgKgy")
//                .roles("user")
//                .and()
//                .withUser("admin")
//                .password("$2a$10$Hi0VrMTVKLGxT7kJqRyoDuKYkaJZEx0I4PUVRbauBOZQkgTBWjmUK")
//                .roles("admin");
        auth.userDetailsService(userService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {//http
        http.authorizeRequests()
                .antMatchers("/admin")
                .hasRole("admin")
                .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                .antMatchers(HttpMethod.GET, "/login/**").permitAll()
                .antMatchers("/user/reg").permitAll()
                .antMatchers("/ws/**").permitAll() // Temporarily ignore token authorization in ws
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
                .and()
                .headers().frameOptions().disable()
                .and()
                .addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }
}

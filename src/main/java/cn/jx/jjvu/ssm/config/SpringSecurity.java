package cn.jx.jjvu.ssm.config;

import cn.jx.jjvu.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/admin/login.html")
                .loginProcessingUrl("/login")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);


        http
                .authorizeRequests()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/js/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/images/**").permitAll()
                .antMatchers("/admin/login.html").permitAll()
                .antMatchers("/admin/admin_index.html").permitAll()

                .antMatchers("/index.html").permitAll()

                .antMatchers("/pages/admin/main.jsp").permitAll()
                .antMatchers("/pages/admin/top.jsp").permitAll()
                .antMatchers("/pages/admin/left.jsp").permitAll()
                .antMatchers("/pages/admin/menu.jsp").permitAll()


                .antMatchers("/menuController/toAddMenu").permitAll()
                .antMatchers("/menuController/addMenu").permitAll()
                .antMatchers("/menuController/manageMenu").permitAll()
                .antMatchers("/menuController/manageDownMenu").permitAll()
                .antMatchers("/menuController/delMenu").permitAll()
                .antMatchers("/menuController/toEditMenu").permitAll()
                .antMatchers("/menuController/editMenu").permitAll()


                .antMatchers("/pages/admin/addmenu.jsp").permitAll()
                .antMatchers("/pages/admin/managemenu.jsp").permitAll()
                .antMatchers("/pages/admin/managedownmenu.jsp").permitAll()
                .antMatchers("/pages/admin/editmenu.jsp").permitAll();

        http
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler);
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder);
    }
}

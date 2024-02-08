//package com.thamiprojects.userapi.config;
//
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@EnableWebSecurity
//@AllArgsConstructor
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//  @Override
//  public void configure(HttpSecurity httpSecurity) throws Exception {
//    httpSecurity.csrf().disable()
//      .authorizeRequests()
//      .antMatchers("/api1/**").permitAll()
//      .antMatchers("/api2/**").permitAll()
//      .antMatchers("/api3/**").permitAll()
//  }
//}

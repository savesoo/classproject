package com.app.springsecurity.config;

import com.app.springsecurity.security.Custom403Handler;
import com.app.springsecurity.security.CustomLoginSuccessHandler;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Log4j2
@Configuration
public class CustomSecurityConfig {

    @Bean
    public AuthenticationSuccessHandler successHandler(){
        return new CustomLoginSuccessHandler();
    }

    @Bean // filter에서 설정 사용하기 위한 bean 등록
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf().disable();

        // 필요한 Security 설정       -> HttpSecurity로 설정 가능!
        // 1. 요청(URL)에 대한 인증과 허가에 대한 설정
        httpSecurity.authorizeHttpRequests()
                .antMatchers("/sample/sample").authenticated() // 해당 경로 요청시 인증을 요구함
                .antMatchers("/sample/all").permitAll() // 권한 여부 상관없이 모두 허가
                .antMatchers("/sample/member").hasRole("USER") // 권한 정의
                .antMatchers("/sample/admin").hasRole("ADMIN");


        // 2. form 기반 인증 처리 : 커스텀 로그인 페이지 설정 -> 성공시 처리하는 핸들러 객체 등록
        //httpSecurity.formLogin().successHandler(successHandler());

        httpSecurity.formLogin().loginPage("/sample/login").successHandler(successHandler());

        // 3. 인/허가 실패 403 : 권한 부족시 처리 핸들러 등록
        httpSecurity.exceptionHandling().accessDeniedHandler(accessDeniedHandler());

        // 4. 로그아웃
        httpSecurity.logout();

        // 5. 자동 로그인
        //httpSecurity.rememberMe().key("1234567890").rememberMeParameter("remember-me").tokenValiditySeconds(60*60*24*7);

        return httpSecurity.build();
    }

    @Bean
    public AccessDeniedHandler accessDeniedHandler(){
        return new Custom403Handler();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // xml 대신 java에 등록
        return new BCryptPasswordEncoder();
    }


    // 테스트 환경 -> CustomLoginSuccessHandler에서 수행
    // 사용할 정보를 확인
/*    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails userDetails = User.builder()
                .username("user1")
                .password(passwordEncoder().encode("1111")) // 암호화 = DB에도 암호화된 pw가 저장됨
                .roles("USER")
                .build();

        log.info(" >>>>>> UserDetailService : " + passwordEncoder().encode("1111"));
        log.info(" >>>>>> " + userDetails);

        return new InMemoryUserDetailsManager(userDetails);
    }*/
}

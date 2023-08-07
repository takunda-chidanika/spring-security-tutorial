package com.example.springsecuritytutorial.security;

import com.example.springsecuritytutorial.auth.ApplicationUserService;
import com.example.springsecuritytutorial.jwt.JwtUsernameAndPasswordAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.springsecuritytutorial.security.ApplicationUserRole.STUDENT;

/**
 * @author tjchidanika
 * @created 2/8/2023
 */

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
@EnableMethodSecurity
public class ApplicationSecurityConfig {

    private final PasswordEncoder passwordEncoder;
    private final ApplicationUserService applicationUserService;

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(applicationUserService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return new ProviderManager(authProvider);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/", "index", "/index.html", "/css/*", "/js/*").permitAll()
                        .requestMatchers("/api/**").hasRole(STUDENT.name())
                        .anyRequest()
                        .authenticated()
                )
//                .formLogin((formLogin) -> formLogin.
//                        loginPage("/login")
//                        .permitAll()
//                        .defaultSuccessUrl("/courses", true)
//                )
//                .rememberMe((rememberMe) -> rememberMe
//                        .tokenValiditySeconds((int) TimeUnit.MINUTES.toSeconds(1))
//                        .key("codeXAfrica")
//                        .rememberMeParameter("remember-me")
//                )
//                .logout((logout) -> logout
//                        .logoutUrl("/logout")
//                        .deleteCookies("JSESSIONID", "remember-me")
//                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
//                        .clearAuthentication(true)
//                        .invalidateHttpSession(true)
//                        .logoutSuccessUrl("/login")
//                )
        ;

        return http.build();
    }

    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(daoAuthenticationProvider());
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(applicationUserService);

        return provider;
    }

}

package dev.elitefinancetrack.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withUsername("yogaasri")
                .password("{noop}yog12")
                .roles("Developer")
                .build();

        UserDetails user2 = User.withUsername("Alexa")
                .password("{noop}alexa12")
                .roles("Admin")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.POST,"api/userName/").hasRole("Developer")
                        .requestMatchers(HttpMethod.POST,"api/userName/").hasRole("Admin"));

        // Http basic authentication
        http.httpBasic(Customizer.withDefaults());

        // Disable csrf for stateless rest API
        http.csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }
}
package me.personal.barbearia_api.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

/* Este código define uma classe de configuração que cria um filtro CORS para permitir requisições de origens
diferentes. O CORS é um mecanismo de segurança que restringe requisições HTTP de um domínio para outro, a menos que o
servidor autorize explicitamente essas requisições.
Essas configurações são feitas para o ambiente de desenvolvimento.*/

@Configuration // anotação que indica que a classe tem uma configuração para o spring
public class CorsConfig {
    @Bean // anotação de bean spring
    public FilterRegistrationBean<CorsFilter> corsFilterRegistrationBean() {
        var config = new CorsConfiguration();
        // Permite o envio de cookies e cabeçalhos de autenticação em requisições CORS.
        config.setAllowCredentials(true);

        // Permite requisições de qualquer origem.
        config.setAllowedOriginPatterns(Collections.singletonList("*"));

        // Permite todos os métodos HTTP (GET, POST, PUT, DELETE, etc.).
        config.setAllowedMethods(Collections.singletonList("*"));

        // Permite todos os cabeçalhos HTTP.
        config.setAllowedHeaders(Collections.singletonList("*"));

        // Cria uma instância de UrlBasedCorsConfigurationSource para mapear as configurações CORS para URLs.
        var source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        // mapeia as config para todas as URLs

        // cria um filtro de registro para o CorsFilter
        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>();

        // Define o filtro a ser registrado como um CorsFilter com a configuração de origem das URLS (source).
        bean.setFilter(new CorsFilter(source));

        // Define a ordem de execução do filtro como a mais alta possível. Isso garante que o filtro CORS seja executado
        // antes de outros filtros.
        bean.setOrder(HIGHEST_PRECEDENCE);

        return bean; // retorna o bean configurado
    }
}

package app.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteLocatorConfig {

	@Bean
	RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route("ms-workers", r -> r.path("/ms-worker/**").filters(f -> f.stripPrefix(1)).uri("lb://ms-worker"))
				.route("ms-payroll", r -> r.path("/ms-payroll/**").filters(f -> f.stripPrefix(1)).uri("lb://ms-payroll"))
				.route("ms-user", r -> r.path("/ms-user/**").filters(f -> f.stripPrefix(1)).uri("lb://ms-user"))
				.build();
	}

}

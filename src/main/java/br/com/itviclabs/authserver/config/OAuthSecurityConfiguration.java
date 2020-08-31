package br.com.itviclabs.authserver.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
public class OAuthSecurityConfiguration extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private UserDetailsService userDetails;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		/* configure the applications that will access the auth-server*/
		clients.inMemory()
				.withClient("restaurante-vo-maria")
				.authorizedGrantTypes("password")
				.secret(encoder.encode("1234"))
				.scopes("web", "mobile");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(userDetails);
	}
}

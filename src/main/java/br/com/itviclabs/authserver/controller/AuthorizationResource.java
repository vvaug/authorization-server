package br.com.itviclabs.authserver.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorizationResource {

	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
}

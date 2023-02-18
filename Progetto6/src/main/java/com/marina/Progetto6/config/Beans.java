package com.marina.Progetto6.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.marina.Progetto6.entities.Dispositivo;
import com.marina.Progetto6.entities.Role;
import com.marina.Progetto6.entities.RoleType;
import com.marina.Progetto6.entities.StatoDispos;
import com.marina.Progetto6.entities.TipoDispositivo;
import com.marina.Progetto6.entities.User;

@Configuration
public class Beans {

	@Bean
	@Scope("prototype")
	public User user(String name, String lastname, String email, String password) {
		
		return User.builder()
				.name(name)
				.lastname(lastname)
				.email(email)
				.password(password)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Role role(RoleType r) {
		return Role.builder()
				.role(r)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Dispositivo dispos(TipoDispositivo td, StatoDispos sd) {
		return Dispositivo.builder()
				.tipo(td)
				.stato(sd)
				.build();
	}
}

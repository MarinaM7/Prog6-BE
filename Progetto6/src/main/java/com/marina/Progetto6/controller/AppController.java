package com.marina.Progetto6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marina.Progetto6.entities.Dispositivo;
import com.marina.Progetto6.services.DaoService;

@Controller
public class AppController {
	
	@Autowired
	DaoService ds;
	
	@GetMapping("/")
	@ResponseBody
	public String index() {
		return "Home page";
	}

	@GetMapping("/admin")
	@ResponseBody
	@PreAuthorize("hasRole('ADMIN')")
	public String admin() {
		return "Page dedicata al ADMIN";
	}

	
	@GetMapping("/alldispos")
	@ResponseBody
	//@PreAuthorize("hasRole('ADMIN')")
	public List<Dispositivo> allDispos() {
		return ds.getAllDispos();
	}

	@GetMapping("/dispositivi/{stato}")
	@ResponseBody
	//@PreAuthorize("hasRole('ADMIN')")
	public List<Dispositivo> stato(@PathVariable String stato) {
		return ds.getDispByStato(stato.toUpperCase());
	}

}

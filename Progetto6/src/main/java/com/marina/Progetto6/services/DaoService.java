package com.marina.Progetto6.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marina.Progetto6.entities.Dispositivo;
import com.marina.Progetto6.entities.Role;
import com.marina.Progetto6.entities.StatoDispos;
import com.marina.Progetto6.entities.User;
import com.marina.Progetto6.repos.DisposRepo;
import com.marina.Progetto6.repos.RoleRepo;
import com.marina.Progetto6.repos.UserRepo;

@Service
public class DaoService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private DisposRepo dr;
	
	public Optional<User> getUserById(int id) {
		return userRepo.findById(id);
	}
	
	public User saveUser(User obj) {
		return userRepo.save(obj);
	}
	
	public Role saveRole(Role obj) {
		return roleRepo.save(obj);
	}
	
	public Dispositivo saveDispos(Dispositivo obj) {
		return dr.save(obj);
	}
	
	public void update(int userid, StatoDispos s, int id) {
		dr.assegnaDispositivo(userid, s, id);
	}
	
	public List<Dispositivo> getAllDispos() {
		return dr.findAll();
	}
	
	public List<Dispositivo> getDispByStato(String s) {
		return dr.getDispByStato(s);
	}
}

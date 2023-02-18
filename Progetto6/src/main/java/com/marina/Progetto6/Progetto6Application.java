package com.marina.Progetto6;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.marina.Progetto6.entities.Dispositivo;
import com.marina.Progetto6.entities.Role;
import com.marina.Progetto6.entities.StatoDispos;
import com.marina.Progetto6.entities.User;
import com.marina.Progetto6.services.DaoService;

@SpringBootApplication
public class Progetto6Application implements CommandLineRunner {
		
	@Autowired
	private DaoService ds;


	public static void main(String[] args) {
		SpringApplication.run(Progetto6Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		ApplicationContext ctx = new AnnotationConfigApplicationContext(Beans.class);
//		
//		User u1 = (User)ctx.getBean("user", "Marina", "Muntenita", "marinam@gmail.com", "marina");
//		
//		Role r1 = (Role)ctx.getBean("role", RoleType.ROLE_ADMIN);
//		Role r2 = (Role)ctx.getBean("role", RoleType.ROLE_USER);
//
//		u1.setRoles(new HashSet<>() {{
//			add(r1);
//		}});
//
//		Dispositivo d1 = (Dispositivo)ctx.getBean("dispos", TipoDispositivo.LAPTOP, StatoDispos.DISPONIBILE);
//		Dispositivo d2 = (Dispositivo)ctx.getBean("dispos", TipoDispositivo.SMARTPHONE, StatoDispos.DISMESSO);
//		Dispositivo d3 = (Dispositivo)ctx.getBean("dispos", TipoDispositivo.TABLET, StatoDispos.IN_MANUTENZIONE);
//		Dispositivo d4 = (Dispositivo)ctx.getBean("dispos", TipoDispositivo.LAPTOP, StatoDispos.DISPONIBILE);
//		Dispositivo d5 = (Dispositivo)ctx.getBean("dispos", TipoDispositivo.TABLET, StatoDispos.DISPONIBILE);
//		
//		
//		((AnnotationConfigApplicationContext)ctx).close();
		
		//populateRole(r1);
		//populateRole(r2);
		
		//populateUsers(u1);
		
//		populateDispositivi(d1);
//		populateDispositivi(d2);
//		populateDispositivi(d3);
//		populateDispositivi(d4);
//		populateDispositivi(d5);
		
		//assegnaDispos(d4, u1);
		
	}
	
	public void populateRole(Role r) {
		ds.saveRole(r);
	}
	
	public void populateUsers(User u) {
		ds.saveUser(u);
	}
	
	public void populateDispositivi(Dispositivo d) {	
		ds.saveDispos(d);
	}
	
	private void getRolesFromUserById(int id) {
        Optional<User> authUserObj = ds.getUserById(id);
        User authUser = authUserObj.get();
        String role = "USER";
        Set<Role> roles = authUser.getRoles();

        for( Role r : roles ) {
            if( r.getRole().toString().contains("ADMIN") ) {
                role = "ADMIN";
                break;
            }
        }

        System.out.println(role);
    }
	
	public void assegnaDispos(Dispositivo d, User u) {
			
		String s = null;
		
		switch(d.getStato()) {
		
		case DISPONIBILE:
			ds.update(u.getId(), StatoDispos.ASSEGNATO, d.getId());
			s = "Dispositivo assegnato correttamente all'utente" + u.getName() + u.getLastname();
			break;
		
		case ASSEGNATO:
			s = "Dispositivo occupato";
			break;
			
		case DISMESSO:
			s = "Dispositivo non disponibile";
			break;
			
		case IN_MANUTENZIONE:
			s = "Dispositivo in manutenzione";
			break;
		}
		System.out.println(s);	
	}

}

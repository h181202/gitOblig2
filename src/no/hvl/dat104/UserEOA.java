package no.hvl.dat104;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 * @author David Korsrud Bråten
 *
 */
@Stateless
public class UserEOA {

		
	
	@PersistenceContext(name = "userPersistenceUnit")
	private EntityManager em;
	
	public void leggTilUser(User user) {
		//if(!userFinnes(user)) {
		//	em.persist(user);
		//}
	}
	
	public User finnUser(int mobilnr) {
		User user = em.find(User.class, mobilnr);
		return user;	
//		user1.setMobil(81549300);
//		user1.setFnavn("Erik");
//		user1.setEnavn("Rolpemann");
//		user1.setSex(true);
//		user1.setBetalt(false);
//		return user1;
	}
	
	public List<User> finnAlleUser(){
		Query query = em.createQuery("SELECT u FROM User u ORDER BY u.fnavn, u.enavn", User.class);
		return query.getResultList();
		
		
		
//		User user1 = new User();
//		List<User> userList = new ArrayList<User>();
//		user1.setMobil(81549300);
//		user1.setFnavn("Erik");
//		user1.setEnavn("Rolpemann");
//		user1.setSex(true);
//		user1.setBetalt(false);
//		userList.add(user1);
//		return userList;
	}
	
	public void betaling(User user) {
		//user.setBetalt(true);
		//em.persist(user);
	}
	
	public boolean userFinnes(User user) {
			return finnUser(user.getMobil()) != null;
		}

	
}

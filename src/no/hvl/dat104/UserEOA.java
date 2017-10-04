package no.hvl.dat104;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
			em.persist(user);
		//}
	}
	
	public User finnUser(int mobilnr) {
			User user = em.find(User.class, mobilnr);
		return user;	
	}
	
	public List<User> finnAlleUser(){
			TypedQuery<User> query = em.createQuery("SELECT u FROM User u ORDER BY u.fnavn, u.enavn", User.class);
		return query.getResultList();
	}
	
	public void betaling(User user) {
		user.setBetalt(true);
		em.persist(user);
	}
	
	public boolean userFinnes(User user) {
			return finnUser(user.getMobil()) != null;
		}
		
		
	
	
	
	
	
}

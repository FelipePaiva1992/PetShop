package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.VwAcessoUsuario;
import persistance.util.DAO;

public class AcessoUsuarioDao implements DAO<VwAcessoUsuario>{

	String pUnit;
	HttpServletRequest request;
	HttpSession session;
	
	public AcessoUsuarioDao(HttpServletRequest request){
		this.request = request;
		session = request.getSession();
		String pu = "petshop_bd";
		pUnit = pu;
	}
	
	public AcessoUsuarioDao(){
		
	}
	


	public VwAcessoUsuario findByNmUser(String user) {
		
		EntityManager em = Persistence.createEntityManagerFactory("petshop_bd").createEntityManager();
		
		Query query = em.createQuery("FROM VwAcessoUsuario where nmUsuario = :user");
		query.setParameter("user", user);	
		VwAcessoUsuario vwAcessoUsuario = (VwAcessoUsuario) query.getSingleResult();
		
		em.close();
		
		return vwAcessoUsuario;
	}

	@Override
	public VwAcessoUsuario findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(VwAcessoUsuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletById(int id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public VwAcessoUsuario insert(VwAcessoUsuario entity) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean update(VwAcessoUsuario entity) {
		// TODO Auto-generated method stub
		return false;
	}

}

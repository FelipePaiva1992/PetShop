//package persistence.listenner;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
//
//@WebListener
//public class PULoader implements ServletContextListener {
//
//	private static Map<String,EntityManagerFactory> pUnitFactories;
//	private String[] listaPUs;
//	
//    public PULoader() {
//
//    }
//
//
//    public void contextInitialized(ServletContextEvent event) {
//
//    	listaPUs = event.getServletContext().getInitParameter("pu_names").toString().split(",");
//    	startEmFactories();
//    }
//
//    
//    public static EntityManager getEntityManager(String esquema){
//    	return pUnitFactories.get(esquema).createEntityManager();
//    }
//    
//    
//    private void startEmFactories(){
//    	
//    	pUnitFactories = new HashMap<String,EntityManagerFactory>();
//    	
//    	for(String pu : listaPUs){
//    		
//    		System.out.println("PUs: "+pu);
//    		
//    		EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(pu);
//    		
//    		pUnitFactories.put(pu, emFactory);
//    	}    	
//    }
//    
//    
//    public void contextDestroyed(ServletContextEvent event) {
//    	
//    }
//	
//}

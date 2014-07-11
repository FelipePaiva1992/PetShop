package util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.hibernate.Query;
import org.hibernate.Session;
 
@SuppressWarnings("unchecked")
public class GenericDAO<T> {
 
	@PersistenceContext(unitName="petshop_bd")
    private static EntityManager entityManager;
	


	static {
        EntityManagerFactory fac = Persistence.createEntityManagerFactory("petshop_bd");
        entityManager = fac.createEntityManager();
    }    
    
 
    /**
     * retorna objeto do tipo T passando o id
     * @param id
     * @return objeto T
     */
    public T findById(int id) {
        return (T) entityManager.find(getTypeClass(), id);
    }
    
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * Inseri dados na tabela
     * 
     * @param entity
     */
    public void insert(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    /**
     * Atualizada dado da tabela
     * 
     * @param entity
     */
    public void update(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
    
	 /**
	  * Deleta dado da tabela passando um int id
	  * @param id
	  * 
	  * @author fpaiva
	  */
    public void deletById(int id) {
        try {
            T entity = findById(id);
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }
 
    /**
     * Retorna lista com todos os valores encontrados na tabela
     * 
     * @return list itens
     */
    public List<T> findAll() {
        return entityManager.createQuery(("From " + getTypeClass().getName()))
                .getResultList();
    }
 
    /**
     * Retorna do tipo da classe que implementou o GenericDao
     * @return
     */
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
        return clazz;
    }
    
    
    //---------------------------------------------------------------------------------------------------------------------------------
    
    //numero limite de valores por pagina
    int LimitePorPagina = 2;
    
    
    
    /**
     * Metodo efetua um calculo com o numero de resultados de uma tabela e retorna o numero de paginas que o sistema vai listar
     * 
     * @param criteria (null caso não houver filtro, ou uma String com a clausula WHERE)
     * 
     * @return numero de paginas referente a tabela de consulta
     * @author fpaiva
     */
    public int numberOfPages(String criteria){
    	
    	int numerodePagina = 0;
    	List todos;
    	String stringTodos;
    	int numeroDados;
    	
    	if(criteria == null || criteria == ""){
    		
    		todos = entityManager.createQuery(("SELECT Count(*) From " + getTypeClass().getName())).getResultList();
    		stringTodos = todos.get(0).toString();
    		numeroDados = Integer.parseInt(stringTodos); 
    		
    		if(numeroDados%LimitePorPagina == 0){
    			numerodePagina = numeroDados/LimitePorPagina;
    		}else{
    			numerodePagina = (numeroDados/LimitePorPagina)+1;	
    		}
    		
    	}else{
    		
    		todos = entityManager.createQuery(("SELECT Count(*) From " + getTypeClass().getName() + " " + criteria)).getResultList();
    		stringTodos = todos.get(0).toString();
    		numeroDados = Integer.parseInt(stringTodos); 
    		
    		if(numeroDados%LimitePorPagina == 0){
    			numerodePagina = numeroDados/LimitePorPagina;
    		}else{
    			numerodePagina = (numeroDados/LimitePorPagina)+1;	
    		}
    		
    	}    	
		return numerodePagina;
		
    }
    
    /**
     * Metodo retorna numero de itens encontrados na tabela de acordo com a condição
     * 
     * @param criteria (null caso não houver filtro, ou uma String com a clausula WHERE)
     * 
     * @return Int com o numero de itens obtidos
     */
    public int numberOfItens(String criteria){
    	
    	int numeroDados;
    	List todos;
    	String stringTodos;
    	
    	if(criteria == null || criteria == ""){
    		
    		todos = entityManager.createQuery(("SELECT Count(*) From " + getTypeClass().getName())).getResultList();
    		stringTodos = todos.get(0).toString();
    		numeroDados = Integer.parseInt(stringTodos); 
    		
    	}else{
    		
    		todos = entityManager.createQuery(("SELECT Count(*) From " + getTypeClass().getName() + " " + criteria)).getResultList();
    		stringTodos = todos.get(0).toString();
    		numeroDados = Integer.parseInt(stringTodos); 
    		
    	}
    	return numeroDados;
		
    }
    
    /**
     * Metodo recebe a pagina e retorna a lista com os resultados da pagina escolhida
     * 
     * @param pagina (numero da pagina que quer obter o retorno
     * @param criteria (null caso não houver filtro, ou uma String com a clausula WHERE)
     * 
     * @return lista com os valores encontrados
     * 
     * @author fpaiva
     */
    
    public List<T> findXInSpecificPage(int pagina, String criteria){
		
    	Session hSession;
    	Query query;
    	
    	if(criteria == null || criteria == ""){
    		
    		hSession =  (Session) entityManager.getDelegate();            
            query = hSession.createQuery(("From " + getTypeClass().getName()));            
            query.setFirstResult((pagina * LimitePorPagina) - LimitePorPagina);
            query.setMaxResults(LimitePorPagina); 
            
    	}else{
    		
    		hSession =  (Session) entityManager.getDelegate();            
            query = hSession.createQuery(("From " + getTypeClass().getName() + " " + criteria));            
            query.setFirstResult((pagina * LimitePorPagina) - LimitePorPagina);
            query.setMaxResults(LimitePorPagina);
            
    	}
        return query.list();
    }
    

    

}
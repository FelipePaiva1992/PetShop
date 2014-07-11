package persistance.util;


	public interface DAO <T>{

	    public T findById(int id);
	      
	    public T insert(T entity);
	    
	    public boolean delete(T entity);
	    
	    public boolean deletById(int id);
	    
	    public boolean update(T entity);

	}

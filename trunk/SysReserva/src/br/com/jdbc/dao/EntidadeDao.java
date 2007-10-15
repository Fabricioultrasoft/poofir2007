package src.br.com.jdbc.dao;

import java.util.List;

public interface EntidadeDao {

	void save(Object obj);
	void delete(Object obj);
	List list();
	Object find(int id);

}

package src.br.com.jdbc.dao;

import java.util.List;
import src.br.com.model.Entidade;

public interface CommunDao {
        void delete(Entidade entidade);
        List<Entidade> list(Class entidadeClass);
	void save(Entidade entidade);
}

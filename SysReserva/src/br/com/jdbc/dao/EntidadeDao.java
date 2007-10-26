
package src.br.com.jdbc.dao;
import br.com.Reflactor.Reflactor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.br.com.jdbc.ConnectionFactory;
import src.br.com.model.Entidade;

public class EntidadeDao implements CommunDao {
    protected Connection connection;
    
    public EntidadeDao(){
      try {
	this.connection = ConnectionFactory.getConnection();
      } catch (SQLException e) {
	e.printStackTrace();
      }
    }

    public void delete(Entidade entidade) {
      try {
        String tabela = entidade.getClass().getSimpleName();
	PreparedStatement ps = this.connection
                .prepareStatement("DELETE FROM "+ tabela + " WHERE ID=?");
	ps.setInt(1, entidade.getId());
	ps.execute();
	ps.close();
      } catch (SQLException e) {
	e.printStackTrace();
      }
    }

    public List<Entidade> list(Class entidadeClass){
      List<Entidade> entidades = new ArrayList<Entidade>();
      Map fieldList = new HashMap();
      try {
        String tabela = entidadeClass.getSimpleName();
        PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + tabela);
        ResultSet rs = ps.executeQuery();
        int qtd = rs.getMetaData().getColumnCount();
        while (rs.next()) {
          for(int i=1; i<=qtd; i++){
            String nome = rs.getMetaData().getColumnName(i).toLowerCase();
            Object value = rs.getObject(nome);
            fieldList.put(nome, value);
          }//for
          Entidade entidade = (Entidade) entidadeClass.newInstance();
          Reflactor.setEntidade(entidade, fieldList);
          entidades.add(entidade);
        }//while
        ps.close();
      } catch (InstantiationException ex) {
        Logger.getLogger(EntidadeDao.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IllegalAccessException ex) {
        Logger.getLogger(EntidadeDao.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SecurityException ex) {
        Logger.getLogger(EntidadeDao.class.getName()).log(Level.SEVERE, null, ex);
      } catch (SQLException e) {
        e.printStackTrace();
      }
      return entidades;
    }
    
    private void executeQuery(String sql, Collection values){
      try {
        PreparedStatement ps = connection.prepareStatement(sql);
        Iterator iteratorValue = values.iterator();
        int index = 1;
        while(iteratorValue.hasNext()){
          Object value = iteratorValue.next();
          ps.setObject(index, value);
          index++;
        }
        ps.execute();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    
    private void update(Entidade entidade){
      Map mapFields = Reflactor.getMapFields(entidade);
      String sql = "UPDATE " + entidade.getClass().getSimpleName() + " SET ";
      Iterator iteratorKey = mapFields.keySet().iterator();
      while(iteratorKey.hasNext()){
        Object key = iteratorKey.next();
        sql += key.toString() + "=?,";
      }
      sql = sql.substring(0, sql.length()-1) + " WHERE ID=" + entidade.getId();
      executeQuery(sql, mapFields.values());
    }

    private void insert(Entidade entidade){
      Map mapFields = Reflactor.getMapFields(entidade);
      String sql = "INSERT INTO " + entidade.getClass().getSimpleName();
      Iterator iteratorKey = mapFields.keySet().iterator();
      String values = "";
      String fields = "";
      while(iteratorKey.hasNext()){
        Object key = iteratorKey.next();
        fields += key.toString() + ",";
        values += "?,";
      }
      fields = " (" + fields.substring(0, fields.length()-1) + ")";
      values = " VALUES(" + values.substring(0, values.length()-1) + ")";
      sql += fields + values;
      System.out.println(sql);
      executeQuery(sql, mapFields.values());
    }
    
    public void save(Entidade entidade) {
      if (entidade.getId() == 0)
        insert(entidade);
      else
	update(entidade);
    }
    
}

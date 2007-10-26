/*
 * EntidadeController.java
 * 
 * Created on 21/10/2007, 19:56:48
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package src.br.com.controller;

import java.util.List;
import src.br.com.jdbc.dao.EntidadeDao;
import src.br.com.model.Entidade;

/**
 *
 * @author Clelia
 */
public class EntidadeController {
    private EntidadeDao dao;
    
    public EntidadeController(){
      dao = new EntidadeDao();
    }
    
    public List<Entidade> list(Class entidadeClass){
      return dao.list(entidadeClass);
    }
    
    public void save(Entidade entidade){
      dao.save(entidade);
    }
    
    public void delete(Entidade entidade){
      dao.delete(entidade);
    }

}

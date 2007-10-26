package src.br.com.model;

import br.com.annotation.GetValue;
import br.com.annotation.Persistent;

public class Entidade {
    @GetValue
    private int id;
    @Persistent
    private String nome;
    
    public Entidade(){}
    
    public Entidade(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }

}

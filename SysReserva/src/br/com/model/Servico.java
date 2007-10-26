package src.br.com.model;

import br.com.annotation.Persistent;

public class Servico extends Entidade {
  @Persistent
  private Number valor;

  public Servico(){
      super();
  }
  
  public Servico(int id){
      super.setId(id);
  }
  public Number getValor(){
    return valor;
  }
        
  public void setValor(Number valor){
    this.valor = valor;
  }

}
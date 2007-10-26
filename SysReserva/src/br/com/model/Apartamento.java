package src.br.com.model;

import br.com.annotation.Persistent;

public class Apartamento extends Entidade {
   @Persistent
   private int qtdCamas;

    public Apartamento() {
      super();
    }
    
    public Apartamento(int id){
      super(id);
    }

    public int getQtdCamas() {
        return qtdCamas;
    }

    public void setQtdCamas(int qtdCamas) {
        this.qtdCamas = qtdCamas;
    }





}

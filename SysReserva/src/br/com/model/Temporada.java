package src.br.com.model;

import br.com.annotation.Persistent;
import java.util.Date;

public class Temporada extends Entidade {
  @Persistent
  private Date inicio;
  @Persistent
  private Date fim;
  @Persistent
  private Number taxa;
  @Persistent
  private String tipo;
  
  public Temporada() {
      super();
  }

  public Temporada(int id){
      super(id);
  }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Number getTaxa() {
        return taxa;
    }

    public void setTaxa(Number taxa) {
        this.taxa = taxa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

  

}

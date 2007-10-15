package src.br.com.model;
import java.util.Date;

public class Hospede {
  private int id;
  private String nome;
  private Endereco endereco;
  private String foneResidencial;
  private String foneContato;
  private Date dataNascimento;

  // Construtor
  public Hospede (int id, String nome) {
	this.id = id;
    this.nome = nome;
  }

  public Hospede () {
  }

  // Métodos Básicos

  public int getId(){
	  return id;
  }

  public void setId(int id){
	  this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
	  this.nome = nome;
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco (Endereco endereco) {
    this.endereco = endereco;
  }

  public String getFoneResidencial() {
    return foneResidencial;
  }

  public void setFoneResidencial(String foneResidencial) {
	  this.foneResidencial = foneResidencial;
  }

  public String getFoneContato() {
    return foneContato;
  }

  public void setFoneContato(String foneContato) {
	  this.foneContato = foneContato;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento (Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

@Override
public boolean equals(Object obj) {
	Hospede hosp = (Hospede) obj;
	return id == hosp.getId();
}

@Override
public String toString() {
	return "Código: "+ id + " Nome: "+ nome + ".\n" +
	       endereco.toString() + "\n" +
	       "Fone residêncial/contato: " + foneResidencial + " / "+ foneContato;
}
}
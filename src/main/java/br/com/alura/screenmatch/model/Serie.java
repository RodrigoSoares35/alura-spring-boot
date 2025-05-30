
package br.com.alura.screenmatch.model;

import br.com.alura.screenmatch.traducao.ConsultaMyMemory;
import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
@Table(name="serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

  private String titulo;
  private Integer totalTemporadas;
  private double avaliacao;

  @Enumerated(EnumType.STRING)
  private Categoria genero;
  private String atores;
  private String poster;
  private String sinopse;
  
  public Serie(DadosSerie dadosSerie){
      this.titulo = dadosSerie.titulo();
      this.totalTemporadas = dadosSerie.totalTemporadas();
      this.avaliacao = OptionalDouble.of(Double.valueOf
      (dadosSerie.avaliacao())).orElse(0);
      this.genero = Categoria.fromString(dadosSerie.genero().split(",")[0].trim());
      this.atores = dadosSerie.atores();
      this.poster = dadosSerie.poster();
      //this.sinopse = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse()).trim();
      String sinopseTraduzida = ConsultaMyMemory.obterTraducao(dadosSerie.sinopse());
      this.sinopse = sinopseTraduzida != null ? sinopseTraduzida.trim() : "Sinopse indisponível.";
  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
      return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTotalTemporadas() {
        return totalTemporadas;
    }

    public void setTotalTemporadas(Integer totalTemporadas) {
        this.totalTemporadas = totalTemporadas;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public String getAtores() {
        return atores;
    }

    public void setAtores(String atores) {
        this.atores = atores;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    @Override
    public String toString() {
        return  "genero=" + genero 
                + "titulo=" + titulo 
                + ", totalTemporadas=" + totalTemporadas 
                + ", avaliacao=" + avaliacao 
                + ", atores=" + atores 
                + ", poster=" + poster 
                + ", sinopse=" + sinopse;
    }
  
}

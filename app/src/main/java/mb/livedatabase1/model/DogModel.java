package mb.livedatabase1.model;
import java.io.Serializable;

public class DogModel implements Serializable {
    //Atributos
    private Integer id;
    private String  nome;
    private Integer idade;
    private Integer imagem;

    //Construtor (Vazio, SemId, ComId, Etc)
    public DogModel() { }
    public DogModel(String nome, Integer idade, Integer imagem) {this.nome = nome; this.idade = idade; this.imagem = imagem;}
    public DogModel(Integer id, String nome, Integer idade, Integer imagem) {this.id = id; this.nome = nome; this.idade = idade; this.imagem = imagem;}

    //GettSetter
    public Integer getId()                  { return id;            }
    public void setId(Integer id)           {this.id = id;          }
    public String getNome()                 {return nome;           }
    public void setNome(String nome)        {this.nome = nome;      }
    public Integer getIdade()               {return idade;          }
    public void setIdade(Integer idade)     {this.idade = idade;    }
    public Integer getImagem()              {return imagem;         }
    public void setImagem(Integer imagem)   {this.imagem = imagem;  }

    //ToString (Debugar)
    @Override public String toString() {
        return "DogModel{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", idade=" + idade +
                ", imagem=" + imagem +
                '}';
    }
}



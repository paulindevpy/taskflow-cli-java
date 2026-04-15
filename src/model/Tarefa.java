package model;


public class Tarefa {
    private int id;
    private String titulo;
    private String descricao;
    private String prazo;
    private String status;

public Tarefa(int id, String titulo, String descricao, String prazo) {
    this.id = id;
    this.titulo = titulo;
    this.descricao = descricao;
    this.prazo = prazo;
    this.status = "PENDENTE";

}

public void atualizarStatus(String novoStatus){
    this.status = novoStatus;
}


@Override
public String toString() {
    return "ID: " + id +
            "| Titulo: " + titulo +
            "| Status: " + status +
            "| Prazo: " + prazo;
     }
public String getTitulo() {
    return titulo;

    }
public int getId() {
    return id;
    }

}

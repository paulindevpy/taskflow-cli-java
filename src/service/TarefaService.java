package service;

import model.Tarefa;
import java.util.ArrayList;
import java.util.List;


public class TarefaService {
    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AZUL = "\u001B[34m";
    public static final String AMARELO = "\u001B[33m";

    private List<Tarefa> tarefas = new ArrayList<>();
    private int proximoId = 1;

    public void adicionarTarefa(String titulo, String descricao, String prazo) {
        Tarefa tarefa = new Tarefa(proximoId, titulo, descricao, prazo);

        tarefas.add(tarefa);
        System.out.println(VERDE + "Tarefa adicionada com ID: " + proximoId + RESET);
        proximoId++;
    }

    public void listarTarefas() {
        for (Tarefa t : tarefas) {
            System.out.println(t);
        }
    }

    public void removerTarefa(int id) {
        Tarefa tarefaParaRemover = null;
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {
                tarefaParaRemover = t;
                break;
            }
        }
        if (tarefaParaRemover != null) {
            tarefas.remove(tarefaParaRemover);
            System.out.println("Tarefa removida com sucesso! ");
        } else {
            System.out.println("Tarefa não encontrada! ");

        }
    }

    public void atualizarStatus(int id, String novoStatus) {
        for (Tarefa t : tarefas) {
            if (t.getId() == id) {

                t.atualizarStatus(novoStatus);
                System.out.println("Status atualizado!");
                return;
            }
        }
        System.out.println("Tarefa não encontrada!");
    }
}
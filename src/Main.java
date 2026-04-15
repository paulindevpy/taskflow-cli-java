
import model.Tarefa;
import service.TarefaService;
import java.util.Scanner;


public class Main {
    public static final String RESET = "\u001B[0m";
    public static final String VERDE = "\u001B[32m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String AZUL = "\u001B[34m";
    public static final String AMARELO = "\u001B[33m";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TarefaService service = new TarefaService();

       int opcao;

       do {
           try {

            System.out.println(AZUL + "\n =====================" + RESET);
            System.out.println(VERDE + "      TASKFLOW MENU " + RESET);
            System.out.println(AZUL + "===================== " + RESET);
            System.out.println(AMARELO + "1 - Adicionar tarefa");
            System.out.println("2 - Listar tarefas");
            System.out.println("3 - Atualizar status");
            System.out.println("4 - Deletar tarefa" + RESET);
            System.out.println(VERMELHO + "0 - Sair " + RESET);
            System.out.print("Escolha: ");
            String entrada = scanner.nextLine();
            opcao = Integer.parseInt(entrada);
        }catch (Exception e){
                System.out.println(VERMELHO + "Digite apenas números!" + RESET);
                opcao = -1;
        }

            if (opcao == 1) {
                System.out.print("Titulo: ");
                String titulo = scanner.nextLine();

                System.out.print("Descrição: ");
                String descricao = scanner.nextLine();

                System.out.print("Prazo: ");
                String prazo = scanner.nextLine();
                service.adicionarTarefa(titulo, descricao, prazo);
            } else if (opcao == 2) {
                service.listarTarefas();
            } else if (opcao == 3) {
                System.out.println("ID da tarefa: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.println("Novo status (PENDENTE / EM_ANDAMENTO / CONCLUIDA): ");
                String status = scanner.nextLine();
                service.atualizarStatus(id, status);
            } else if (opcao == 4) {
                System.out.print("Digite o ID da tarefa(del) :");
                int id = Integer.parseInt(scanner.nextLine());
                service.removerTarefa(id);
            }

       } while (opcao != 0);
        System.out.println("Encerrando sistema... ");
    }
}
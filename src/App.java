import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    static List<String> Tarefas = new ArrayList<String>();
    static Scanner sc1 = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        menu();
    }
    public static void menu() throws Exception {
        limpaTela();
        System.out.println("Lista de afazeres");
        System.out.println("");
        System.out.println("Digite uma das opções abaixo para continuar:");
        System.out.println("1 - Adicionar tafera");
        System.out.println("2 - Completar tafera");
        System.out.println("3 - Excluir tarefa");
        System.out.println("4 - Listar tarefas");

        String resposta = System.console().readLine();

        if(resposta.intern() == "1" )
            adicionarTarefa();
        if(resposta.intern() == "2" )
            completarTarefa();
        if(resposta.intern() == "3" )
            excluirTarefa();
        if(resposta.intern() == "4" )
            adicionarTarefa();
    }
    public static void adicionarTarefa() throws Exception {
        limpaTela();
        System.out.println("Digite a tafera que voce quer adicionar na lista");
        System.out.println("");
        var tafera = System.console().readLine();
        Tarefas.add(Tarefas.size(),tafera.intern()  + " - em progresso");
        limpaTela();
        System.out.println("Item adicionado com sucesso!");
        System.out.println("");
        voltaMenu();
    }
    public static void completarTarefa() throws Exception {
        limpaTela();
        listarTarefa();
        System.out.println("");
        System.out.println("Digite o numero do item que voce quer excluir");
        var resposta = System.console().readLine();
        try
        {
            String tarefa = Tarefas.get(Integer.parseInt(resposta.intern())-1);
            Tarefas.remove(Integer.parseInt(resposta.intern())-1);
            Tarefas.add(tarefa.intern().replace("- em progresso", "- completo"));
        }
        catch (Exception erro)
        {
            completarTarefa();
        }
        limpaTela();
        System.out.println("Item comcluido com sucesso!");
        voltaMenu();
    }
    public static void excluirTarefa() throws Exception {
        limpaTela();
        listarTarefa();
        System.out.println("");
        System.out.println("Digite o numero do item que voce quer excluir");
        var resposta = System.console().readLine();
        System.out.println("Deseja mesmo excluir o item " + resposta + "? y/n");
        resposta = System.console().readLine();
        
        if(resposta =="n")
            excluirTarefa();

        try
        {
        Tarefas.remove(Integer.parseInt(resposta.intern())-1);
        }
        catch (Exception erro)
        {
            excluirTarefa();
        }
        limpaTela();
        System.out.println("Item excluido com sucesso");
        voltaMenu();
    }
    public static void listarTarefa() throws Exception {
        limpaTela();
        var cont = 1;
        do{
            System.out.println(cont +" " + Tarefas.get(cont-1));
            cont++;
        }while(cont<=Tarefas.size());
    }
    public static void limpaTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void voltaMenu() throws Exception {
        System.out.println("Deseja fechar a aplicação? y/n");
        String resposta = System.console().readLine();
        if(resposta.intern() == "y")
            System.exit(200);
        if(resposta.intern() == "n")
            menu();

        voltaMenu();
    }
}

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
        System.out.println("5 - Fechar aplicação");
        System.out.println("");

        String resposta = System.console().readLine();

        if(resposta.intern() == "1" )
            adicionarTarefa();
        if(resposta.intern() == "2" )
            completarTarefa();
        if(resposta.intern() == "3" )
            excluirTarefa();
        if(resposta.intern() == "4" )
        {
            listarTarefa();
            voltaMenu();
        }
        if(resposta.intern() == "5" )
        fechar();
    }
    public static void adicionarTarefa() throws Exception {
        limpaTela();
        System.out.println("Digite a tafera que voce quer adicionar na lista");
        System.out.println("");
        var tafera = System.console().readLine();
        if(tafera.intern().length() < 1)
            adicionarTarefa();
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
        var resposta2 = System.console().readLine();
        
        if(resposta2.intern() =="n")
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
        while(cont<=Tarefas.size()){
            System.out.println(cont +" " + Tarefas.get(cont-1));
            cont++;
        };
        if(Tarefas.size()==0)
             System.out.println("Voce não possui taferas cadastradas");
    }
    public static void limpaTela() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    public static void fechar() throws Exception {
        System.out.println("Deseja fechar a aplicação? y/n");
        String resposta = System.console().readLine();
        if(resposta.intern() == "y")
            System.exit(200);
        if(resposta.intern() == "n")
            menu();

        limpaTela();
        fechar();
    }

    public static void voltaMenu() throws Exception {
        System.out.println("Aperte enter para voltar para o menu principal");
        System.console().readLine();
        menu();
    }
}

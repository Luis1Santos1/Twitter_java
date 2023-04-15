import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioLogado = null;

    // Cria o usuário dentro de um array
    public static Usuario criaUsuario() {
        System.out.print("Crie o seu nome: ");
        String nome = leitor.nextLine();
        System.out.print("Crie seu login: ");
        String login = leitor.nextLine();
        System.out.print("Crie seu email: ");
        String email = leitor.nextLine();
        System.out.print("Crie sua senha: ");
        String senha = leitor.nextLine();

        Usuario novoUsuario = new Usuario(nome, login, email, senha);

        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    // lista usuarios cadastrados
    public static void listaUsuarios() {
        for (Usuario usuario : usuarios) {
            System.out.println("Usuario: " + usuario.getLogin());
        }
    }

    // loga em um usuario ja cadastrado
    public static void logUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("Digite seu login para logar: \n");
        String login = leitor.next();
        System.out.print("Digite sua senha para logar: \n");
        String senha = leitor.next();

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                usuario.setLogado(true);
                System.out.println("Usuário logado com sucesso!");
                System.out.println("Usuario logado: " + usuario.getLogin());
                return;
            } else {
                System.out.println("Usuário incorreto");
            }
        }
    }

    public static void deslogUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("Digite seu login");
        String login = leitor.next();

        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                System.out.println("Usuário deslogado!");

            } else {
                System.out.println("Usuário não está logado");
            }
        }

    }

    public static void main(String[] args) {
        String text = "";
        
        while(!text.equalsIgnoreCase("logar usuario")){
            System.out.println("-- Cadastrar Usuário\n-- Listar Usuários\n-- Logar Usuário\n-- Deslogar Usuário\n-- Tweetar\n-- Mostrar Tweets do Feed\n-- Remover Tweet de um Usuário\n-- Alterar Senha de um Usuário\n-- Remover um Usuário\n-- Imprimir Estatísticas\n-- Finalizar Programa");
            text = leitor.nextLine();


            if (text.equalsIgnoreCase("Cadastrar Usuario")) {
                criaUsuario();
            } else if (text.equalsIgnoreCase("Listar usuarios")) {
                listaUsuarios();
            } else if (text.equalsIgnoreCase("Logar usuario")) {
                logUsuario(usuarios);
            } else if (text.equalsIgnoreCase("Mostrar Tweets do Feed")) {

            } else if (text.equalsIgnoreCase("Imprimir Estatísticas")) {

            } else if (text.equalsIgnoreCase("Finalizar Programa")) {
                System.out.println("Encerrando o programa...");
                break;
            } 
        }

        
        while(usuarioLogado.logado == true){
            
        }
        
    }
}

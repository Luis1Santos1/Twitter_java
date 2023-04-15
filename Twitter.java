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
        String teste = "";
        System.out.print("Crie seu login: ");
        String loginExiste = leitor.nextLine();
        while(teste != "DeuCerto"){
            for(Usuario usuario : usuarios){
                if(usuario.getLogin().equals(loginExiste)){
                    System.out.println(	"Usuario já existe");
                    teste = "DeuCerto";
                }else{
                    loginExiste = leitor.nextLine();
                }
            }

        }
        String login = loginExiste;
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
        String login = leitor.nextLine();
        System.out.print("Digite sua senha para logar: \n");
        String senha = leitor.nextLine();

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
        System.out.print("Digite seu login para deslogar: ");
        String deslogar = leitor.nextLine();
        
        for (Usuario usuario : usuarios) {
            if(usuario.logado == true) {
                if (usuario.getLogin().equals(deslogar)) {
                    usuarioLogado = null;
                    usuario.setLogado(false);
                    System.out.println("Usuário deslogado!");
                } else {
                    System.out.println("Usuário não está logado");
                }
            }
        }

    }

    public static void main(String[] args) {
        String text = "";
        String finalizarSession = "";

        while(finalizarSession != "Finalizar"){
        
            while(!text.equalsIgnoreCase("logar usuario")){
                System.out.println("-- Cadastrar Usuário\n-- Listar Usuários\n-- Logar Usuário\n-- Mostrar Tweets do Feed\n-- Imprimir Estatísticas\n-- Finalizar Programa");
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
                    finalizarSession = "Finalizar";
                    break;
                } 
            }
            
            
            for(Usuario usuario : usuarios) {
                while(usuario.logado == true){
                    System.out.println("-- Tweetar\n-- Mostrar Tweets do Feed\n-- Listar Usuários\n-- Remover Tweet de um Usuário\n-- Alterar Senha de um Usuário\n-- Imprimir Estatísticas\n-- Deslogar Usuário\n-- Remover um Usuário\n-- Finalizar Programa");
                    text = leitor.nextLine();
                    if (text.equalsIgnoreCase("Twittar")) {
                        
                    } else if (text.equalsIgnoreCase("Mostrar Tweets do Feed")) {

                    } else if (text.equalsIgnoreCase("Listar usuarios")) {
                        listaUsuarios();
                    } else if (text.equalsIgnoreCase("Remover twittes do seu usuario")) {
                        
                    } else if (text.equalsIgnoreCase("Alterar senha do usuario")) {
                        
                    } else if (text.equalsIgnoreCase("Imprimir Estatisticas")) {
                        
                    } else if (text.equalsIgnoreCase("Deslogar Usuario")) {
                        deslogUsuario(usuarios);
                        text = "";
                    } else if (text.equalsIgnoreCase("Remover seu usuario")) {
                        
                    } else if (text.equalsIgnoreCase("Finalizar Programa")) {
                        System.out.println("Encerrando o programa...");    
                        finalizarSession = "Finalizar";
                        break;
                    } 
                }
            }
        }
    }
}

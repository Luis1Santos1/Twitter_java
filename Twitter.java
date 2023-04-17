import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioLogado = null;
    public static ArrayList<String> tweets = new ArrayList<>();

    // Cria o usuário dentro de um array
    public static Usuario criaUsuario() {

        System.out.print("Crie o seu nome: ");
        String nome = leitor.nextLine();

        String login = "";
        boolean loginExistente = true;

        //enquanto for verdadeiro ele vai entrar
        while (loginExistente == true) {
            System.out.print("Crie o seu login: ");
            login = leitor.nextLine();

            loginExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getLogin().equals(login)) {
                    System.out.println("Login já existente. Por favor, tente novamente");
                    loginExistente = true;
                    login = "";
                    break;
                }
            }
        }

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

    public static void tweetar() {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário logado. Faça o login primeiro.");
            return;
        }
        System.out.println("Digite o seu tweet: ");
        String conteudoTweet = leitor.nextLine();

        String tweet = usuarioLogado.getNome() + ": " + conteudoTweet;
        tweets.add(tweet);
        System.out.println("Tweet enviado!");
    }

    public static void MostraTweetsFeed() {
        System.out.println("Digite a quantidade de tweets que deseja visualizar: ");
        int quant = leitor.nextInt();
        System.out.println("Tweets do feed: ");
        for(int i = (quant - 1); i >= 0; i--) {
                System.out.println(tweets.get(i));
        }
    }

    public static void MostraTweetsUsuario() {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário logado. Faça o login primeiro.");
            return;
        }
        
        System.out.println("Tweets do usuario: ");
        for(String tweet : tweets) {
            if(tweet.contains(usuarioLogado.getNome() + ":")){
                System.out.println(tweet);
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
                    MostraTweetsFeed();
                } else if (text.equalsIgnoreCase("Imprimir Estatísticas")) {

                } else if (text.equalsIgnoreCase("Finalizar Programa")) {
                    System.out.println("Encerrando o programa...");
                    finalizarSession = "Finalizar";
                    break;
                } 
            }
            
            
            for(Usuario usuario : usuarios) {
                while(usuario.logado == true){
                    System.out.println("-- Tweetar\n-- Mostrar Tweets do Feed\n-- Listar Usuários\n-- Remover Tweets do seu Usuário\n-- Alterar Senha do Usuário\n-- Imprimir Estatísticas\n-- Deslogar Usuário\n-- Remover um Usuário\n-- Finalizar Programa");
                    text = leitor.nextLine();
                    if (text.equalsIgnoreCase("Tweetar")) {
                        tweetar();
                    } else if (text.equalsIgnoreCase("Mostrar Tweets do Feed")) {
                        MostraTweetsFeed();
                    } else if (text.equalsIgnoreCase("Listar usuarios")) {
                        listaUsuarios();
                    } else if (text.equalsIgnoreCase("Remover tweets do seu Usuario")) {
                        MostraTweetsUsuario();
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


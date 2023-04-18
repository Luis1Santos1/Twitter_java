import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<String> tweets = new ArrayList<>();

    // Cria o usuário dentro de um array
    public static Usuario criaUsuario() {

        System.out.print("Crie o seu nome: ");
        String nome = leitor.nextLine();

        String login = "";
        boolean loginExistente = true;

        // enquanto for verdadeiro ele vai entrar
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
                usuario.setLogado(true);
                System.out.println("Usuário logado com sucesso!");
                System.out.println("Usuario logado: " + usuario.getLogin());
                return;
            } else {
                System.out.println("Usuario ou senha incorreto");
            }
        }
    }

    public static void deslogUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("Digite seu login para deslogar: ");
        String deslogar = leitor.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.logado == true) {
                if (usuario.getLogin().equals(deslogar)) {

                    usuario.setLogado(false);
                    System.out.println("Usuário deslogado!");
                } else {
                    System.out.println("Usuário não está logado");
                }
            }
        }

    }

    public static void MostraTweetsFeed() {
        System.out.println("Digite a quantidade de tweets que deseja visualizar: ");
        int quant = leitor.nextInt();
        System.out.println("Tweets do feed: ");
        for (int i = (quant - 1); i >= 0; i--) {
            System.out.println(tweets.get(i));
        }
    }


    public static void tweetar() {

        for (Usuario usuario : usuarios) {
            if (usuario.logado == false) {
                System.out.println("Nenhum usuário logado. Faça o login primeiro.");
                return;
            }else{
                System.out.println("Digite o seu tweet: ");
                String conteudoTweet = leitor.nextLine();
        
                String tweet = usuario.getNome() + ": " + conteudoTweet;
                tweets.add(tweet);
                System.out.println("Tweet enviado!");
            }
        }



       

    }

    public static void main(String[] args) {
        String text = "";
        boolean finalizar = false;

        while (!finalizar) {
            System.out.println(
                    "-- 1 Cadastrar Usuário\n-- 2 Listar Usuários\n-- 3 Logar Usuário\n-- 4 Deslogar Usuario\n-- 5 Tweetar\n-- 6 mostrar últimos N tweets do feed\n-- 7 remover tweet de um usuário\n-- 8 alterar senha de um usuário\n-- 9 remover um usuário\n-- 10 imprimir estatísticas\n-- 0 Finalizar Programa");

            text = leitor.nextLine();

            if (text.equals("1")) {
                criaUsuario();

            } else if (text.equals("2")) {
                listaUsuarios();

            } else if (text.equals("3")) {
                logUsuario(usuarios);

            } else if (text.equals("4")) {
                deslogUsuario(usuarios);

            } else if (text.equals("5")) {
                tweetar();
            } else if (text.equals("6")) {
                MostraTweetsFeed();
            } else if (text.equals("7")) {
           
            } else if (text.equals("8")) {

            } else if (text.equals("9")) {
         
            } else if (text.equals("10")) {
         
            } else if (text.equals("0")) {
                System.out.println("Encerrando o programa...");
                finalizar = true;
            }
        }
    }

}

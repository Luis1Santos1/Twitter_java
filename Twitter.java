import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<String> tweets = new ArrayList<>();

    // Cria o usuário dentro de um array
    public static Usuario criaUsuario() {

        System.out.print("\nCrie o seu nome: ");
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
                    System.out.println("Login já existente. Por favor, tente novamente. \n");
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

        System.out.print("\nUsuário Cadastrado!\n");

        return novoUsuario;
    }

    // lista usuarios cadastrados
    public static void listaUsuarios() {
        System.out.println("\nUsuarios cadastrados: \n");
        for (Usuario usuario : usuarios) {
            System.out.println("\nUsuario: " + usuario.getLogin() + " || Status: " + usuario.getLogado() + "");
        }
    }

    // loga em um usuario ja cadastrado
    public static void logUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("Digite seu login para logar: \n");
        String login = leitor.nextLine();
        System.out.print("Digite sua senha para logar: \n");
        String senha = leitor.nextLine();
        boolean loginEfetuado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuario.setLogado(true);
                System.out.println("\nUsuário logado com sucesso!");
                System.out.println("\nUsuario logado: " + usuario.getLogin());
                loginEfetuado = true;
                break;
            }
        }
        if (!loginEfetuado){
            System.out.println("Usuário ou senha incorreto");
        }
    }

    public static void deslogUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("\nDigite seu login para deslogar: ");
        String deslogar = leitor.nextLine();
        boolean usuarioDeslogado = false;
        for (Usuario usuario : usuarios) {
            if (usuario.logado == true) {
                if (usuario.getLogin().equals(deslogar)) {
                    usuario.setLogado(false);
                    System.out.println("\nUsuário deslogado!");
                    usuarioDeslogado = true;
                    break;
                }
            }
        }
        if (!usuarioDeslogado) {
            System.out.println("Este usuário não está logado ou não existe.");
        }
    }


    public static void tweetar() {
        boolean encontrouUsuario = false;
        System.out.println("\nDigite o login do usuario que deseja tweetar: ");
        String usuarioParaTweetar = leitor.nextLine();
        for (Usuario usuario : usuarios) {
            if (usuario.logado == true) {
                if (usuario.getLogin().equals(usuarioParaTweetar)){ 
                    System.out.println("\nDigite o seu tweet: ");
                    String conteudoTweet = leitor.nextLine();

                    String tweet = usuario.getLogin() + ": " + conteudoTweet;
                    tweets.add(tweet);

                    System.out.println("\nTweet enviado!");
                    encontrouUsuario = true;
                    break;
                }
            }
        }
        if (!encontrouUsuario) {
            System.out.println("Nenhum usuário encontrado ou logado! \n\n");
        }
    }

    public static void MostraTweetsFeed() {
        System.out.println("\nDigite a quantidade de tweets que deseja visualizar: ");
        int quant = leitor.nextInt();
        System.out.println("\nTweets do feed: \n");
        for (int i = (quant - 1); i >= 0; i--) {
            System.out.println(tweets.get(i) + "\n");
        }
    }

    public static void alterarSenha(Usuario usuario) {
        if (!usuario.getLogado()) {
            System.out.println("O usuário não está logado. \n\n");
            return;
        }
        
        System.out.print("Digite a senha atual: ");
        String senhaAtual = leitor.nextLine();
        
        if (!senhaAtual.equals(usuario.getSenha())) {
            System.out.println("Senha incorreta. \n");
            return;
        }
        
        System.out.print("Digite a nova senha: ");
        String novaSenha = leitor.nextLine();
        
        while (novaSenha.length() < 6 || novaSenha.length() > 15) {
            System.out.println("A senha deve ter entre 6 e 15 caracteres.");
            System.out.print("Digite a nova senha: ");
            novaSenha = leitor.nextLine();
        }
        
        usuario.setSenha(novaSenha);
        System.out.println("Senha alterada com sucesso.");
    }
    public static void main(String[] args) {
        String text = "";
        boolean finalizar = false;

        while (!finalizar) {
            System.out.println(
                    "\n-- 1 Cadastrar Usuário\n-- 2 Listar Usuários\n-- 3 Logar Usuário\n-- 4 Deslogar Usuario\n-- 5 Tweetar\n-- 6 mostrar últimos N tweets do feed\n-- 7 remover tweet de um usuário\n-- 8 alterar senha de um usuário\n-- 9 remover um usuário\n-- 10 imprimir estatísticas\n-- 0 Finalizar Programa");

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

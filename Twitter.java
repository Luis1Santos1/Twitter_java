import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static ArrayList<String> tweets = new ArrayList<>();
    public static String ultimoTweetador;
    public static String ultimoTweet;

    // Cria o usuário dentro de um array
    public static Usuario criaUsuario() {

        boolean nomeNOk = false;
        String nome = "";

        while (nomeNOk == false) {
            System.out.print("Crie o seu nome: ");
            nome = leitor.nextLine();

            if (nome.length() >= 2 && nome.length() <= 30) {
                nomeNOk = true;
                break;
            } else if (nome.length() < 2 || nome.length() > 30) {
                System.out.print("O nome deve ter entre 2 e 30 caracteres! \n");
                nome = "";
                nomeNOk = false;
            }
        }

        String login = "";
        boolean loginExistente = true;
        boolean loginNOK = false;

        while (loginExistente == true) {
            while (loginNOK == false) {
                System.out.print("Crie o seu login: ");
                login = leitor.nextLine();

                if (login.length() >= 2 && login.length() <= 20) {
                    loginNOK = true;
                    break;
                } else if (login.length() < 2 || login.length() > 20) {
                    System.out.print("O login deve ter entre 2 e 20 caracteres! \n");
                    login = "";
                    loginNOK = false;
                }
            }

            loginExistente = false;
            for (Usuario usuario : usuarios) {
                if (usuario.getLogin().equals(login)) {
                    System.out.println("Login já existente. Por favor, tente novamente. ");
                    loginExistente = true;
                    login = "";
                    System.out.print("Crie o seu login: ");
                    login = leitor.nextLine();
                    break;
                }
            }
        }

        String email = "";
        boolean emailNOK = false;

        while (emailNOK == false) {
            System.out.print("Crie o seu email: ");
            email = leitor.nextLine();

            if (email.length() >= 6 && login.length() <= 30) {
                emailNOK = true;
                break;
            } else if (email.length() < 6 || email.length() > 30) {
                System.out.print("O email deve ter entre 6 e 30 caracteres! \n");
                email = "";
                emailNOK = false;
            }
        }

        String senha = "";
        boolean senhaNOK = false;

        while (senhaNOK == false) {
            System.out.print("Crie sua senha: ");
            senha = leitor.nextLine();

            if (senha.length() >= 6 && senha.length() <= 15) {
                senhaNOK = true;
                break;
            } else if (senha.length() < 6 || senha.length() > 30) {
                System.out.print("A senha deve ter entre 6 e 15 caracteres! \n");
                senha = "";
                senhaNOK = false;
            }
        }

        Usuario novoUsuario = new Usuario(nome, login, email, senha);
        usuarios.add(novoUsuario);

        System.out.print("\nUsuário Cadastrado!\n");

        return novoUsuario;
    }
    // lista usuarios cadastrados
    public static void listaUsuarios() {
        System.out.println("\nUsuarios cadastrados: ");
        if (usuarios.size() > 0) {
            for (Usuario usuario : usuarios) {
                System.out.println("\nUsuario: " + usuario.getLogin() + " || Status: " + usuario.getLogado() + "");
            }
        } else if (usuarios.size() == 0) {
            System.out.println("Não existe nenhum usuário cadastrado!");
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
        if (!loginEfetuado) {
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
        boolean tweetarNOK = false;
        boolean encontrouUsuario = false;
        System.out.print("Digite o login do usuario que deseja tweetar: ");
        String usuarioParaTweetar = leitor.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.logado == true) {
                if (usuario.getLogin().equals(usuarioParaTweetar)) {
                    while (tweetarNOK == false) {
                        System.out.print("\nDigite o seu tweet: ");
                        String conteudoTweet = leitor.nextLine();

                        if (conteudoTweet.length() >= 1 && conteudoTweet.length() <= 140) {

                            int indice = tweets.size() + 1;
                            String tweet = indice + " - " + usuario.getLogin() + ": " + conteudoTweet;
                            tweets.add(tweet);

                            System.out.println("\nTweet enviado!");
                            encontrouUsuario = true;
                            ultimoTweetador = usuario.getLogin();
                            ultimoTweet = tweet;
                            break;
                        } else if (conteudoTweet.length() < 1 || conteudoTweet.length() > 140) {
                            System.out.print("O tweet deve ter entre 1 e 140 caracteres! \n");
                            conteudoTweet = "";
                            tweetarNOK = false;
                        }
                    }
                }
            }
            else if(!encontrouUsuario) {
                System.out.println("Nenhum usuário encontrado ou logado! \n");
                break;
            }
        }
    }

    public static void mostraTweetsFeed() {
        System.out.println("\nDigite a quantidade de tweets que deseja visualizar: ");
        int quant = leitor.nextInt();
        leitor.nextLine();
        if (tweets.size() >= quant) {
            System.out.println("\nTweets do feed: \n");
            /*
             * for (int i = (tweets.size() - 1); i >= (tweets.size() - quant); i--) { //
             * System.out.println(tweets.get(i) + "\n");
             * 
             * }
             */
            for (int i = (tweets.size() - (quant)); i < (tweets.size()); i++) { //
                System.out.println(tweets.get(i) + "\n");
            }

        } /*
           * else if (tweets.size() < quant){
           * System.out.
           * println("Não há tweets suficientes para exibir o número solicitado");
           * }
           */
        else {
            System.out.println("\nNão há tweets suficientes para exibir o número solicitado");
            return;
        }

    }

    public static void alterarSenha(ArrayList<Usuario> usuarios) {
        boolean usuarioEncontrado = false;
        System.out.print("\nDigite seu login que deseja mudar a senha: ");
        String login = leitor.nextLine();
        System.out.print("Digite a senha atual: ");
        String senhaAtual = leitor.nextLine();
        for (Usuario usuario : usuarios) {
            if (login.equals(usuario.getLogin()) && senhaAtual.equals(usuario.getSenha())) {
                System.out.print("Digite a nova senha: ");
                String novaSenha = leitor.nextLine();
                usuario.setSenha(novaSenha);
                System.out.println("Senha alterada com sucesso.");
                usuarioEncontrado = true;
                break;
            }
            if (!usuarioEncontrado) {
                System.out.println("Nenhum usuário encontrado ou logado! \n");
            }
        }
    }

    public static void removeTweetDeUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("\nDigite o login que deseja remover o tweet: ");
        String login = leitor.nextLine();
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                for (String tweet : tweets) {
                    if (tweet.contains(login + ": ")) {
                        System.out.println(tweet);

                    }
                }
                System.out.println("Digite o número do índice do tweet que deseja excluir: ");
                String indiceRemover = leitor.nextLine();

                for (String tweet : tweets) {
                    if (tweet.contains(indiceRemover + " - ")) {
                        tweets.remove(tweet);
                        System.out.println("Tweet removido!");
                        break;
                    }
                }

            }
        }
    }

    public static void removeUsuario(ArrayList<Usuario> usuarios) {
        boolean usuarioCerto = false;
        System.out.println("\nDigite o login do usuario que deseja remover: ");
        String login = leitor.nextLine();
        System.out.println("\nDigite a senha do usuario que deseja remover: ");
        String senha = leitor.nextLine();
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarios.remove(usuario);
                System.out.println("usuario removido!");
                usuarioCerto = true;
                break;
            }
        }
        if (!usuarioCerto) {
            System.out.println("\nUsuario ou senha incorretos\n");
        }
    }

    public static void imprimirEstatisticas() {
        int estatisticaUser = usuarios.size();
        System.out.println("\nNúmero total de usuários cadastrados:" + estatisticaUser);

        int numUsuariosLogados = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getLogado()) {
                numUsuariosLogados++;
            }
        }
        System.out.println("\nNúmero de usuários logados neste momento: " + numUsuariosLogados);

        int numTweets = tweets.size();
        System.out.println("\nNúmero de tweets no total:" + numTweets);

        int maiorTweetador = 0;

        String usuarioMaiorTweetador = "";
        for (Usuario usuario : usuarios) {
            int numTweetsUsuario = 0;
            for (String tweet : tweets) {
                if (tweet.contains(usuario.getLogin() + ":")) {
                    numTweetsUsuario = numTweetsUsuario + 1;
                    if (numTweetsUsuario > maiorTweetador) {
                        maiorTweetador = numTweetsUsuario;
                        usuarioMaiorTweetador = usuario.getLogin();
                    }

                }
            }
            System.out.println("\n" + usuario.getLogin() + " têm " + numTweetsUsuario + " tweets postados no feed.");
        }
        System.out.println("\n" + usuarioMaiorTweetador + " é o maior tweetador com " + maiorTweetador + " tweets.\n");

        System.out
                .println("O usuário " + ultimoTweetador + " é o último tweetador com o seguinte tweet: " + ultimoTweet);

    }

    public static void main(String[] args) {
        String text = "";
        boolean finalizar = false;

        while (!finalizar) {
            System.out.println("\n-- 1 Cadastrar Usuário\n-- 2 Listar Usuários\n-- 3 Logar Usuário\n-- 4 Deslogar Usuario\n-- 5 Tweetar\n-- 6 mostrar últimos N tweets do feed\n-- 7 remover tweet de um usuário\n-- 8 alterar senha de um usuário\n-- 9 remover um usuário\n-- 10 imprimir estatísticas\n-- 0 Finalizar Programa");
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
                mostraTweetsFeed();
            } else if (text.equals("7")) {
                removeTweetDeUsuario(usuarios);
            } else if (text.equals("8")) {
                alterarSenha(usuarios);
            } else if (text.equals("9")) {
                removeUsuario(usuarios);
            } else if (text.equals("10")) {
                imprimirEstatisticas();
            } else if (text.equals("0")) {
                System.out.println("Encerrando o programa...");
                finalizar = true;
            }
        }
    }

}

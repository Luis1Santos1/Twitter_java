import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);
    public static ArrayList<Usuario> usuarios = new ArrayList<>();
    public static Usuario usuarioLogado = null;

    //Cria o usuário dentro de um array
    public static Usuario criaUsuario() {
        System.out.print("Crie o seu nome: ");
        String nome = leitor.next();
        System.out.print("Crie seu login: ");
        String login = leitor.next();
        System.out.print("Crie seu email: ");
        String email = leitor.next();
        System.out.print("Crie sua senha: ");
        String senha = leitor.next();

        Usuario novoUsuario = new Usuario(nome, login, email, senha);

        usuarios.add(novoUsuario);
        return novoUsuario;
    }

    //lista usuarios cadastrados
    public static void listaUsuarios() {
        for(Usuario usuario : usuarios) {
            System.out.println("Usuario: " + usuario.getLogin());
        }
    }

    //loga em um usuario ja cadastrado
    public static void logUsuario(ArrayList<Usuario> usuarios){
        System.out.print("Digite seu login para logar: \n");
        String login = leitor.next();
        System.out.print("Digite sua senha para logar: \n");
        String senha = leitor.next();
        

        for(Usuario usuario : usuarios) {
            if(usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                usuario.setLogado(true);
                System.out.println("Usuário logado com sucesso!");
                System.out.println("Usuario logado: " + usuario.getLogin());
                return;
            }
            else{
                System.out.println("Usuário incorreto");
            }
        } 
    }

    public static void deslogUsuario(ArrayList<Usuario> usuarios) {
        System.out.print("Digite seu login");
        String login = leitor.next();

        for(Usuario usuario : usuarios) {
            if(usuario.getLogin().equals(login)) {
                System.out.println("Usuário deslogado!");
                
            }
            else{
                System.out.println("Usuário não está logado");
            }
        } 

    }
   public static void main(String[] args) {
        int digito = 0;
            while(digito != 3){
                System.out.println("Para Criar Usuario digite 1, \n Para Listar usuários digite 2");
                digito = leitor.nextInt();

                if(digito == 1){
                    criaUsuario();
                }
                else if(digito == 2){
                    listaUsuarios();
                }
                else if(digito == 3){
                    logUsuario(usuarios);
                }
                else if(digito == 4){
                    logUsuario(usuarios);
                }

            }

    

    }
    
}

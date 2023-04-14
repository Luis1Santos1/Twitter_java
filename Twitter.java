import java.util.ArrayList;
import java.util.Scanner;

public class Twitter {

    public static Scanner leitor = new Scanner(System.in);

    public static Usuario criaUsuario() {
        System.out.print("Crie o seu nome");
        String nome = leitor.next();
        System.out.print("Crie seu login");
        String login = leitor.next();
        System.out.print("Crie seu email");
        String email = leitor.next();
        System.out.print("Crie sua senha");
        String senha = leitor.next();

        ArrayList<Usuario> usuarios = new ArrayList<>();

        Usuario novoUsuario = new Usuario(nome, login, email, senha);

        usuarios.add(novoUsuario);

        return novoUsuario;
    }
/* 
    public static Usuario logUsuario(){
        System.out.print("Digite seu login");
        String nome = leitor.next();
        System.out.print("Digite sua senha");
        String nome = leitor.next();
        
        
    } */

   public static void main(String[] args) {

    System.out.println("Para Criar Usuario digite 1 , Para Logar digite 2");
    int home = leitor.nextInt();

    if(home == 1){
        criaUsuario();
    }
}
    
}

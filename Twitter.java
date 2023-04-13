import java.util.ArrayList;
import java.util.Scanner;
public class Twitter {

    public void cadastrarUsuario(String login) {
        if (logins.contains(login)) { // Verifica se o login já está cadastrado
            System.out.println("Login já existe. Tente novamente.");
        } else {
            logins.add(login); // Adiciona o login ao HashSet
            System.out.println("Usuário cadastrado com sucesso.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();

        System.out.println("Digite o seu nome: ");



    }
}

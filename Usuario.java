class Usuario {
    private String nome;
    private double login;
    private double email;
    private double senha;

    public Usuario(String nome, double login, double email, double senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    
    }

    public double getLogin() {
        return login;
    
    }

    public double getEmail() {
        return email;
    
    }

    public double getSenha() {
        return senha;
    
    }

}

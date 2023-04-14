class Usuario {
    private String nome, login, email, senha;
    boolean logado;

    public Usuario(String nome, String login, String email, String senha) {
        this.nome = nome;
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.logado = false;
    }

    public void setLogado(boolean logado){
        this.logado = logado;
    }

    public String getNome() {
        return nome;
    
    }

    public String getLogin() {
        return login;
    
    }

    public String getEmail() {
        return email;
    
    }

    public String getSenha() {
        return senha;
    
    }

}

package model;

public class Cliente{
    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    private void validarNome(String nome){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio!");
        }
        if(!nome.matches("^[a-zA-ZÀ-ÿ ]+$")){
            throw new IllegalArgumentException("Não é permitido caracteres especiais ou números no nome!");
        }
        if(nome.length() > 100){
            throw new IllegalArgumentException("O nome não pode ter mais que 100 caracteres!");
        }
    }

    private void validarCpf(String cpf){
        if(cpf == null){
            throw new IllegalArgumentException("O CPF não pode ser vazio!");
        }
        if(!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")){
            throw new IllegalArgumentException("Informe um CPF com 11 dígitos no formato correto (000.000.000-00)");
        }
        if(cpf.length() > 14){
            throw new IllegalArgumentException("CPF inválido!");
        }
    }

    private void validarTelefone(String telefone){
        if(telefone == null){
            throw new IllegalArgumentException("O número de telefone não pode ser vazio!");
        }
        if(!telefone.matches("^\\(?[1-9]{2}\\)? ?(?:[2-8]|9[1-9])\\d{3}-?\\d{4}$")){
            throw new IllegalArgumentException("Formato de telefone inválido! Use o padrão (DD) 99999-9999 ou apenas números");
        }
        if(telefone.length() > 16){
            throw new IllegalArgumentException("O número de telefone não pode ter mais que 16 caracteres!");
        }
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}
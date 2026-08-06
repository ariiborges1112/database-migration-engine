package model;

public class Fornecedor{
    private Integer id;
    private String nome;
    private String cnpj;
    private String telefone;

    public Fornecedor(String nome, String cnpj, String telefone){
        this.setNome(nome);
        this.setCnpj(cnpj);
        this.setTelefone(telefone);
    }

    public Fornecedor(Integer id, String nome, String cnpj, String telefone){
        this(nome, cnpj, telefone);
        this.setId(id);
    }

    private void validarId(Integer id){
        if(id < 1) throw new IllegalArgumentException("O ID não pode ser menor que 1!");
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

    private void validarCnpj(String cnpj){
        if(cnpj == null) return;

        if(!cnpj.matches("^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$")){
            throw new IllegalArgumentException("Informe um CNPJ com 14 dígitos no formato correto (000.000.000-00)");
        }
        if(cnpj.length() > 18){
            throw new IllegalArgumentException("CNPJ inválido!");
        }
    }

    private void validarTelefone(String telefone){
        if(telefone == null) return;

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
        validarId(id);
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        validarNome(nome);
        this.nome = nome;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        validarCnpj(cnpj);
        this.cnpj = cnpj;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        validarTelefone(telefone);
        this.telefone = telefone;
    }
}
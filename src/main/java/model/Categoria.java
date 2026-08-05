package model;

public class Categoria{
    private Integer id;
    private String nome;

    public Categoria(String nome){
        this.nome = nome;
    }

    public Categoria(Integer id, String nome){
        this(nome);
        this.id = id;
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
        if(nome.length() > 50){
            throw new IllegalArgumentException("O nome não pode ter mais que 50 caracteres!");
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
}
class Main {
    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa("Tony", "Stark", 53);
        System.out.println(pessoa1.getNome());
    }
}

class Pessoa {
    private String nome;
    private String sobrenome;
    private int idade;
    
    Pessoa(String nome, String sobrenome, int idade){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
    }
    
    String getNome(){
        return nome;
    }
    
}

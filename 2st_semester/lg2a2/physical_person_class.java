class PessoaFisica extends Pessoa {
    String cpf = "123.456.789-00";
    
    public static void main(String[] args) {
        PessoaFisica pessoa1 = new PessoaFisica();
        
        System.out.println(pessoa1.getNome());
        System.out.println(pessoa1.cpf);
    }
}

class Pessoa {
    private String nome = "Tony";
    private String sobrenome = "Stark";
    private int idade = 53;
    
    String getNome(){
        return nome;
    }
}

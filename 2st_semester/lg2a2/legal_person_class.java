class PessoaJuridica extends Pessoa {
    String cnpj = "12.345.678/0001-90";
    
    public static void main(String[] args) {
        PessoaJuridica pessoa1 = new PessoaJuridica();
        
        System.out.println(pessoa1.getSobrenome());
        System.out.println(pessoa1.cnpj);
    }
}

class Pessoa {
    private String nome = "Avengers";
    private String sobrenome = "Company";
    private int idade = 10;
    
    String getSobrenome(){
        return sobrenome;
    }
}

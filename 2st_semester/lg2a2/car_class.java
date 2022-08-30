class Carro {
    private final String placa;
    private final String marca;
    private final String modelo;
    
    Carro(String placa, String marca, String modelo){
            this.placa = placa;
            this.marca = marca;
            this.modelo = modelo;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public String diaRodizio(){
        String final_number = placa.substring(placa.length() - 1);
        int casting = Integer.valueOf(final_number);
        if(casting == 1 || casting == 2){
            return "Segunda-feira";
        }else if(casting == 3 || casting == 4){
            return "Terca-feira";
        }else if(casting == 5 || casting == 6){
            return "Quarta-feira";
        }else if(casting == 7 || casting == 8){
            return "Quinta-feira";
        }else{
            return "Sexta-feira";
        }
    }
}

class CreatingClasses {
    public static void main(String[] args) {
        Carro car = new Carro("abc-1230", "Honda", "Civic");
        System.out.println(car.getPlaca());
        System.out.println(car.diaRodizio());
    }
}
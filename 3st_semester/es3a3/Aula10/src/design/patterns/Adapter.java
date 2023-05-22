package design.patterns;

interface TomadaAlvo {
    void fornecerEletricidade();
}


class TomadaBrasileira implements TomadaAlvo {
    @Override
    public void fornecerEletricidade() {
        System.out.println("Tomada brasileira fornecendo eletricidade.");
    }
}


class TomadaEuropeia {
    public void fornecerEletricidadeEuropeia() {
        System.out.println("Tomada europeia fornecendo eletricidade.");
    }
}


class AdaptadorTomadaEuropeiaParaBrasileira implements TomadaAlvo {
    private TomadaEuropeia tomadaEuropeia;

    public AdaptadorTomadaEuropeiaParaBrasileira(TomadaEuropeia tomadaEuropeia) {
        this.tomadaEuropeia = tomadaEuropeia;
    }

    @Override
    public void fornecerEletricidade() {
        tomadaEuropeia.fornecerEletricidadeEuropeia();
    }
}

public class Adapter {
    public static void main(String[] args) {
        TomadaAlvo tomadaBrasileira = new TomadaBrasileira();
        tomadaBrasileira.fornecerEletricidade();

        TomadaEuropeia tomadaEuropeia = new TomadaEuropeia();
        
        TomadaAlvo adaptador = new AdaptadorTomadaEuropeiaParaBrasileira(tomadaEuropeia);
        adaptador.fornecerEletricidade();
    }
}



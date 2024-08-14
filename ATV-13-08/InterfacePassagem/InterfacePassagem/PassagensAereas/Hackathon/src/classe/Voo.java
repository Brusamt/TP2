package classe;

public class Voo {
    private final String numeroVoo;
    private final String origem;
    private final String destino;
    private int assentosDisponiveis;

    public Voo(String numeroVoo, String origem, String destino, int assentosDisponiveis) {
        if (assentosDisponiveis < 0) {
            throw new IllegalArgumentException("O número de assentos disponíveis não pode ser negativo.");
        }
        this.numeroVoo = numeroVoo;
        this.origem = origem;
        this.destino = destino;
        this.assentosDisponiveis = assentosDisponiveis;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public boolean realizarReserva(int quantidadeAssentos) {
        if (verificarDisponibilidade(quantidadeAssentos)) {
            assentosDisponiveis -= quantidadeAssentos;
            return true;
        }
        return false;
    }

    public boolean verificarDisponibilidade(int quantidadeAssentos) {
        return assentosDisponiveis >= quantidadeAssentos;
    }

    public double realizarPagamento(String tipoViagem, boolean pontosTuristicos) {
        double valor = 40.0;
        double custoTotal;

        switch (tipoViagem) {
            case "ida":
                custoTotal = valor;
                break;
            case "ida e volta":
                custoTotal = valor * 2;
                break;
            default:
                throw new IllegalArgumentException("Tipo de viagem inválido. Deve ser 'ida' ou 'ida e volta'.");
        }

        if (pontosTuristicos) {
            custoTotal += 50.0;
        }

        return custoTotal;  
    }

    @Override
    public String toString() {
        return "Número do Voo: " + this.numeroVoo +
                "\nOrigem: " + this.origem +
                "\nDestino: " + this.destino +
                "\nAssentos Disponíveis: " + this.assentosDisponiveis;
    }
}

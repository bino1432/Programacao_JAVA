package net.weg.TopCar.model.veiculos;

public class Caminhao extends Veiculos {

    private String pesoMaximo;
    private int comprimento;
    private int quantidadeDeRodas;
    public Caminhao(Long codigo, float preco, String marca, String placa, boolean novo,
                    String status, int quilometragem, String modelo, int ano, String presoMaximo,
                    int comprimento, int quantidadeDeRodas) {
        super(codigo, preco, marca, placa, novo, status, quilometragem, modelo, ano);
        this.pesoMaximo = presoMaximo;
        this.comprimento = comprimento;
        this.quantidadeDeRodas = quantidadeDeRodas;
    }

    @Override
    public String toString() {
        return "Caminhao{" +
                "pesoMaximo='" + pesoMaximo + '\'' +
                ", comprimento=" + comprimento +
                ", quantidadeDeRodas=" + quantidadeDeRodas +
                '}';
    }
}

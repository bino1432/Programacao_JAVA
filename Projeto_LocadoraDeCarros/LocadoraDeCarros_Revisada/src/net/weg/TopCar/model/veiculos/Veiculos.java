package net.weg.TopCar.model.veiculos;

import net.weg.TopCar.model.exceptions.VeiculoNaoEncontradoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Veiculos {
    private static ArrayList<Veiculos> veiculo = new ArrayList<>();
    private Long codigo;
    private float preco;
    private String marca;
    private String placa;
    private boolean novo;
    private String status;
    private int quilometragem;
    private String modelo;
    private int ano;

    public static void setPreco(float preco) {
        preco = preco;
    }

    public static List<Veiculos> getVeiculo() {
        return Collections.unmodifiableList(veiculo);
    }

    public Long getCodigo(){
        return codigo;
    }

    public float getPreco(){
        return preco;
    }

    public static Veiculos detalheVeiculo(String codigo) throws VeiculoNaoEncontradoException {
        for (Veiculos veiculos : veiculo){
            if (veiculos.codigo.equals(codigo)) {
                return veiculos;
            }
        }
        throw new VeiculoNaoEncontradoException(codigo);
    }

    public static ArrayList<Veiculos> addVeiculo(Veiculos veiculos){
        veiculo.add(veiculos);
        return null;
    }

    public static ArrayList<Veiculos> removeVeiculo(Veiculos veiculos){
        veiculo.remove(veiculos);
        return null;
    }

    @Override
    public String toString() {
        return "net.weg.TopCar.model.veiculos.Veiculos{" +
                "codigo='" + codigo + '\'' +
                ", preco=" + preco +
                ", marca='" + marca + '\'' +
                ", placa='" + placa + '\'' +
                ", novo=" + novo +
                ", status='" + status + '\'' +
                ", quilometragem=" + quilometragem +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                '}';
    }

    public Veiculos(Long codigo, float preco, String marca, String placa, boolean novo, String status, int quilometragem, String modelo, int ano) {
        this.codigo = codigo;
        this.preco = preco;
        this.marca = marca;
        this.placa = placa;
        this.novo = novo;
        this.status = status;
        this.quilometragem = quilometragem;
        this.modelo = modelo;
        this.ano = ano;
    }
}
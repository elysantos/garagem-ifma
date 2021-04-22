package br.edu.ifma.garagem.model;

import lombok.Data;

@Data
public class Veiculo {
    private int id;
    private Usuario proprietario;
    private String marca;
    private String modelo;
    private String placa;
    private int ano;
    private String cor;

    @Override
    public String toString() {
        return "Veiculo{" +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", placa='" + placa + '\'' +
                ", ano=" + ano +
                ", cor='" + cor + '\'' +
                '}';
    }
}

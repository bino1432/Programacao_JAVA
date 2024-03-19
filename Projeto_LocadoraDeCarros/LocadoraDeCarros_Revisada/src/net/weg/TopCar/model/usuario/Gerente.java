package net.weg.TopCar.model.usuario;

import net.weg.TopCar.model.exceptions.PrecoInvalidoException;
import net.weg.TopCar.model.exceptions.UsuarioExistenteException;
import net.weg.TopCar.model.exceptions.VeiculoExistenteException;
import net.weg.TopCar.model.Usuario;
import net.weg.TopCar.model.Veiculos;

public class Gerente extends Funcionario {
    public Gerente(String nome, String cpf, String senha, double salario) {
        super(nome, cpf, senha, salario);
    }
    public static void removerVeiculo(String codigo){
        for(Veiculos veiculo : Veiculos.getVeiculo()){
            if(veiculo.getCodigo().equals(codigo)){
                Veiculos.getVeiculo().remove(veiculo);
            }
        }
    }

    public static void mudarPreco(String codigo, float preco) throws PrecoInvalidoException{

        if (preco <= 0){
            throw new PrecoInvalidoException();
        }

        for(Veiculos veiculo : Veiculos.getVeiculo()){
            if(veiculo.getCodigo().equals(codigo)){
                Veiculos.setPreco(preco);
            }
        }
    }

    public static void cadastrarVeiculo(Veiculos veiculo)
            throws VeiculoExistenteException,
            PrecoInvalidoException {

        if(veiculo.getPreco() <= 0){
            throw new PrecoInvalidoException();
        }

        for (Veiculos veiculoExistente : Veiculos.getVeiculo()){
            if (veiculo.getCodigo().equals(veiculoExistente.getCodigo())){
                throw new VeiculoExistenteException(veiculo.getCodigo());
            }
        }
        Veiculos.addVeiculo(veiculo);
    }

    public static void cadastrarUsuario(String nome, String senha, String cpf, String cnh)
            throws UsuarioExistenteException{
        for (Usuario usuarioExistente : getUsuarios()){
            if (usuarioExistente.getCpf().equals(cpf)){
                throw new UsuarioExistenteException(nome);
            }
        }
        Usuario usuario = new Cliente(nome, senha, cpf, cnh);
        Usuario.addUsuario(usuario);
    }

    public static void removerUsuario(String cpf){
        for (Usuario usuario : getUsuarios()){
            if(usuario.getCpf().equals(cpf)){
                getUsuarios().remove(usuario);
            }
        }
    }

    @Override
    public String toString() {
        return "Gerente{}";
    }

    public void editarUsuario(Usuario novoUsuario) {
        Usuario usuario =
                Usuario.procurarUsuario(
                        novoUsuario.getCpf());
        usuario.alterarUsuario(novoUsuario);
    }
}
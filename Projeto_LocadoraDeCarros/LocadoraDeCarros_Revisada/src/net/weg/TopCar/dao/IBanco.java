package net.weg.TopCar.dao;

import net.weg.TopCar.model.exceptions.UsuarioNaoEncotradoException;

import java.util.*;

public interface IBanco<T, ID> {
    List<T> buscarTodos();
    T buscarUm(ID id)
            throws UsuarioNaoEncotradoException;
    void adicionar(T novo);
    void remover(ID id)
            throws UsuarioNaoEncotradoException;
    void alterar(ID id,
                 T novo)
            throws UsuarioNaoEncotradoException;
}
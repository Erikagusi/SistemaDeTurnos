package com.c1.ClinicaOdontologica2.Dao;

import java.util.List;

public interface Idao <T>{
    T guardar(T t);
    T buscar (Integer id);
    void eliminar (Integer id);
    void actualizar(T t);

    List<T> listarTodos();
    T buscarporString(String valor);
}

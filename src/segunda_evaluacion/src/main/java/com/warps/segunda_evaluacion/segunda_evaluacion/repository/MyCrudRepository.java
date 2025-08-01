package com.warps.segunda_evaluacion.segunda_evaluacion.repository;

public interface MyCrudRepository<T> {
    T save(T entity);
    T findById(Long id);
    void deleteById(Long id);
    Iterable<T> findAll();
}

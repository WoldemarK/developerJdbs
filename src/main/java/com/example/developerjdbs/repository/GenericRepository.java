package com.example.developerjdbs.repository;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T,Long> {
    Optional<T> save(T target);
    Optional<T> update(T target, Long id);
    Optional<T> getId(Long id);
    List<T> getAll();
    void deleteById(Long id);

}

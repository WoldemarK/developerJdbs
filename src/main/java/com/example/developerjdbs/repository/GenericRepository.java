package com.example.developer.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T,Long> {
    Optional<T> save(T target) throws SQLException;
    Optional<T> update(T target, Long id) throws SQLException;
    Optional<T> getId(Long id) throws SQLException;
    List<T> getAll() throws SQLException;
    void deleteById(Long id) throws SQLException;

}

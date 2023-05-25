package com.example.labojavadataweb.repositories;

import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<TKey, TEntity> {

    TEntity add(TEntity tEntity);
    Optional<TEntity> getOne(TKey id);
    Class<TEntity> getClassName();
    List<TEntity> getMany();
    List<TEntity> getList(TypedQuery<TEntity> typedQuery);
    void update(TEntity tEntity);
    void delete(TKey id);
}

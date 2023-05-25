package com.example.labojavadataweb.repositories;

import java.util.Optional;
import java.util.Set;

public interface BaseRepository<TKey, TEntity> {

    TEntity add(TEntity tEntity);
    Optional<TEntity> getOne(TKey id);
    Class<TEntity> getClassName(TEntity tEntity);
    Set<TEntity> getMany();
    void update(TEntity tEntity);
    void delete(TKey id);
}

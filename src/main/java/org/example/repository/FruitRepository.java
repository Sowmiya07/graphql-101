package org.example.repository;

import org.example.repository.entity.Fruit;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.graphql.data.GraphQlRepository;

@GraphQlRepository
public interface FruitRepository extends CrudRepository<Fruit, String>, QuerydslPredicateExecutor<Fruit> {}

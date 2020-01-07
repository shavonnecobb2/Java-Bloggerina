package com.shavonne;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogEntryRepository extends CrudRepository<BlogEntry, Integer> {
    List<BlogEntry> findAll();
}

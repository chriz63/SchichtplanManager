package com.github.chriz63.SchichtplanManager.repository;

import com.github.chriz63.SchichtplanManager.model.SpMgrUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SpMgrUserRepository extends JpaRepository<SpMgrUser, UUID> {
    boolean existsByName(String name);
}

package com.burgeranteux.repository;

import com.burgeranteux.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailRepository extends JpaRepository<Detail, Long> {
}

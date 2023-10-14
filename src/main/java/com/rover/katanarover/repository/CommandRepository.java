package com.rover.katanarover.repository;

import com.rover.katanarover.models.Commands;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandRepository extends JpaRepository<Commands, Long> {
}

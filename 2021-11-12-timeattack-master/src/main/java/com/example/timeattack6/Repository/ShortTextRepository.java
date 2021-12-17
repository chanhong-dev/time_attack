package com.example.timeattack6.Repository;

import com.example.timeattack6.model.ShortText;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortTextRepository extends JpaRepository<ShortText, Long> {
}

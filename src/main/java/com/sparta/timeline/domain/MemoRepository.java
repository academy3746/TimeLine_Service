package com.sparta.timeline.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {

    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
    // findAll By ModifiedAt Between Order By ModifiedAt Desc
    // -> SELECT * FROM TABLE ORDER BY ModifiedAt DESC;
    // BETWEEN: Time between yesterday & today

}

package com.sparta.timeline.controller;

import com.sparta.timeline.domain.Memo;
import com.sparta.timeline.domain.MemoRepository;
import com.sparta.timeline.domain.MemoRequestDto;
import com.sparta.timeline.service.MemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequiredArgsConstructor

public class MemoController {

    private final MemoRepository memoRepository;

    private final MemoService memoService;

    // READ
    @GetMapping("/api/memos")
    public List<Memo> getMemos(){
        LocalDateTime start = LocalDateTime.of
                (LocalDate.now().minusDays(1), LocalTime.of(0,0,0));
        // Yesterday: Before 24 Hour

        LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));
        // Today: Current Time

        return memoRepository.findAllByModifiedAtBetweenOrderByModifiedAtDesc(start, end);
    }

    // CREATE
    @PostMapping("/api/memos")
    public Memo createMemo(@RequestBody MemoRequestDto requestDto){
        Memo memo = new Memo(requestDto);

        return memoRepository.save(memo);
    }

    // UPDATE
    @PutMapping("/api/memos/{id}")
    public Long updateMemo(@PathVariable Long id, @RequestBody MemoRequestDto requestDto){
        // Memo memo = new Memo();
        return memoService.update(id, requestDto);
    }

    // DELETE
    @DeleteMapping("/api/memos/{id}")
    public Long DeleteMemo(@PathVariable Long id){
        memoRepository.deleteById(id);
        return id;
    }
}

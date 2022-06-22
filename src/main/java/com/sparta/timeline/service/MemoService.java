package com.sparta.timeline.service;

import com.sparta.timeline.domain.Memo;
import com.sparta.timeline.domain.MemoRepository;
import com.sparta.timeline.domain.MemoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor

public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, MemoRequestDto requestDto){
        Memo memo = memoRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다!")
        );

        memo.update(requestDto);
        return memo.getId();
    }


}

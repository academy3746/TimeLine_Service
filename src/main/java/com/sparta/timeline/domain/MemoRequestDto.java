package com.sparta.timeline.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter

public class MemoRequestDto {

    private final String username;
    private final String contents;

}

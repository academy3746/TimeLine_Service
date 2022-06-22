package com.sparta.timeline.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
// Auto Import using Lombok Lib
@NoArgsConstructor
// Public class (   ) Memo
@Entity
// Hey, Java! There is table on DB Server!

public class Memo extends TimeStamped{
    // Memo extends TimeStamped
    // 추상 클래스인 TimeStamped 클래스의 Time Data 를 상속받아 써야한다.
    // 여기서 몇 시간을 해맸으니 주의해라..

    @Id
    // CREATE TABLE, Primary Key
    @GeneratedValue(strategy = GenerationType.AUTO)
    // id ++;
    private Long id;
    // Table No.

    @Column(nullable = false)
    // This Column must have value
    private String username;

    @Column(nullable = false)
    // This Column must have value
    private String contents;

    public Memo(String username, String contents){
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

}

package com.sparta.timeline.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
// Time Date 에 각각 접근제한자를 생성해줫기 때문에 반드시 Get 으로 받아야 한다. 안그럼 컴파일 에러 뜸..
@MappedSuperclass
// Entity 가 자동으로 Column 을 인식
@EntityListeners(AuditingEntityListener.class)
// 타임라인 생성시간을 자동으로 Update

public abstract class TimeStamped {
    // Memo Class 의 Parent Class

    @CreatedDate
    private LocalDateTime createAt;
    // 타임라인 생성시간
    
    @LastModifiedDate
    private LocalDateTime modifiedAt;
    // 타임라인 수정시간

}

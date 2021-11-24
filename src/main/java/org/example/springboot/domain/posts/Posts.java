package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor // 기본생성자 자동추가
@Entity // 테이블과 링크될 클래스
public class Posts {
    @Id // PK필드
    @GeneratedValue(strategy=GenerationType.IDENTITY) // PK생성규칙
    private Long id;

    @Column(length = 500, nullable=false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable =false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}

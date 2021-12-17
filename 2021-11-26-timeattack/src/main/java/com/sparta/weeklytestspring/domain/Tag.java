package com.sparta.weeklytestspring.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.weeklytestspring.dto.ArticleCommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
public class Tag {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long idx;

    @Column(nullable = false)
    private String tag;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="article_idx")
    private Article article;

    public Tag(String  tag, Article article) {
        this.tag =tag;
        this.article = article;
    }
}

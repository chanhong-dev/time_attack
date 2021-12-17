package com.example.timeattack6.model;


import com.example.timeattack6.dto.ShortTextDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ShortText {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String text;

    public ShortText(ShortTextDto shortTextDto) {
        this.text = shortTextDto.getText();
    }
}

package com.example.timeattack6.Controller;

import com.example.timeattack6.Service.ShortTextService;
import com.example.timeattack6.dto.ShortTextDto;
import com.example.timeattack6.model.ShortText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShortTextController {

    private final ShortTextService shortTextService;

    @Autowired
    public ShortTextController(ShortTextService shortTextService) {
        this.shortTextService = shortTextService;
    }

    @GetMapping("/api/texts")
    public List<ShortText> getShortText() {
        return shortTextService.getShortTexts();
    }

    @PostMapping("/api/texts")
    public ShortText createShortText(@RequestBody ShortTextDto shortTextDto) {
        ShortText shortText = shortTextService.createShortText(shortTextDto);
        System.out.println("테스트 성공");
        return shortText;
    }
}

package com.example.timeattack6.Service;

import com.example.timeattack6.Repository.ShortTextRepository;
import com.example.timeattack6.dto.ShortTextDto;
import com.example.timeattack6.model.ShortText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ShortTextService {

    private final ShortTextRepository shortTextRepository;

    @Autowired
    public ShortTextService(ShortTextRepository shortTextRepository) {
        this.shortTextRepository = shortTextRepository;
    }

    public List<ShortText> getShortTexts() {
        return shortTextRepository.findAll();
    }

    @Transactional
    public ShortText createShortText(ShortTextDto shortTextDto) {
        ShortText shortText = new ShortText(shortTextDto);

        shortTextRepository.save(shortText);

        return shortText;
    }
}

package com.kt.shopping.service.faq;

import com.kt.shopping.domain.faq.FAQ;
import com.kt.shopping.dto.faq.FAQRequest;
import com.kt.shopping.repository.faq.FAQRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FAQService {
    private final FAQRepository fAQRepository;

    public void create(FAQRequest.Create request) {
        fAQRepository.save(
                new FAQ(
                        request.title(),
                        request.content(),
                        request.category()
                )
        );
    }
}
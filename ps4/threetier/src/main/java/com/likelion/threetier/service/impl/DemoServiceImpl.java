package com.likelion.threetier.service.impl;

import com.likelion.threetier.repository.MyRepository;
import com.likelion.threetier.service.DemoService;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    private final MyRepository repository;

    public DemoServiceImpl(MyRepository repository) {
        this.repository = repository;
    }

    public String getString() {
        return repository.getString();
    }
}

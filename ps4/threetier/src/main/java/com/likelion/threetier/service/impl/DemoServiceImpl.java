package com.likelion.threetier.service.impl;

import com.likelion.threetier.repository.MyRepository;
import com.likelion.threetier.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Qualifier("demoRepository")
    @Autowired
    private MyRepository repository;

//    public DemoServiceImpl(MyRepository repository) {
//        this.repository = repository;
//    }

    @Override
    public String getString() {
        return repository.getString();
    }
}

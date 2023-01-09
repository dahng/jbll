package com.likelion.threetier.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository implements MyRepository{
    @Override
    public String getString() {
        return "Hello World";
    }
}

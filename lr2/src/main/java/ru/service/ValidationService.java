package ru.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import ru.exception.ValidationFailedException;

@Service
public interface ValidationService {
    void isValid(BindingResult result) throws ValidationFailedException;
}

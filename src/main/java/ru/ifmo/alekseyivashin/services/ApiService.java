package ru.ifmo.alekseyivashin.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

/**
 * Creator: aleks
 * Date:    26.05.17
 */

@Service
public interface ApiService {
    String getJsonData(Integer userId) throws JsonProcessingException;
}

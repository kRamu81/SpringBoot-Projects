package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UrlRepository {

    private final Map<String, String> urlStore = new HashMap<>();

    public void saveUrl(String shortCode, String originalUrl) {
        urlStore.put(shortCode, originalUrl);
    }

    public String getOriginalUrl(String shortCode) {
        return urlStore.get(shortCode);
    }

    public boolean exists(String shortCode) {
        return urlStore.containsKey(shortCode);
    }

    public Map<String, String> getAllUrls() {
        return urlStore;
    }
}

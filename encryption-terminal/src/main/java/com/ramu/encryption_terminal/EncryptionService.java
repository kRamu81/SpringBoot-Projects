package com.ramu.encryption_terminal;

import org.springframework.stereotype.Service;

@Service   //  Mark this class as Spring Service
public class EncryptionService {
    private static final int SHIFT = 5;
    // Encrypt method
    public String encrypt(String text) {
        return process(text, SHIFT);
    }
    // Decrypt method
    public String decrypt(String text) {
        return process(text, 26 - (SHIFT % 26));
    }

    private String process(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                // Base ASCII depending on case
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                // Caesar Cipher formula
                char transformed = (char) ((character - base + shift) % 26 + base);
                result.append(transformed);

            } else {
                // Keep non-letters unchanged
                result.append(character);
            }
        }
        return result.toString();
    }
}
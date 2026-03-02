package com.ramu.encryption_terminal;

public class EncryptionResponse {

    private String originalText;
    private String transformedText;
    private String operation; // "encrypt" or "decrypt"

    // 1. CONSTRUCTOR
    public EncryptionResponse(String originalText, String transformedText, String operation) {
        this.originalText = originalText;
        this.transformedText = transformedText;
        this.operation = operation;
    }

    // 2. GETTERS
    
    public String getOriginalText() { 
        return originalText; 
    }

    public String getTransformedText() { 
        return transformedText; 
    }

    public String getOperation() { 
        return operation; 
    }
}
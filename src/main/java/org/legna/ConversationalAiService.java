package org.legna;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface ConversationalAiService {
    String chat(String userMessage, String knowledge);
}

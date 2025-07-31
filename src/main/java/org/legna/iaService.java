package org.legna;
import java.io.IOException;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;

interface ConversationalAI {
    String chat(String userMessage);
}

@ApplicationScoped
public class iaService {
    private final ConversationalAI assistant;

    @Inject
    public iaService(ChatLanguageModel chatModel, conhecimentoService conhecimentoService) throws IOException {
        String knowledge =  conhecimentoService.readKnowledge();
        Document document = new Document(knowledge);
        assistant = iaService.builder(ConversationalAI.class)
            .chatLanguageModel(chatModel)
            .contentRetriever(() -> document)
            .build();
    }

    public String processMessage(String message) {
        return assistant.chat(message);
    }

    public void addToKnowledgeBase(String knowledge) throws IOException {
        conhecimentoService.addKnowledge(knowledge);
    }
}

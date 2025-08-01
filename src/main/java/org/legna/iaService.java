package org.legna;

import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.service.AiServices;
import dev.langchain4j.service.SystemMessage;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.IOException;

interface ConversationalAI {
    @SystemMessage("Você é um assistente de IA que responde com base no conhecimento fornecido. Conhecimento: {{knowledge}}")
    String chat(String userMessage);
}

@ApplicationScoped
public class iaService {
    private final ConversationalAI assistant;

    @Inject
    public iaService(ChatLanguageModel chatModel, conhecimentoService conhecimentoService) throws IOException {
        String knowledge = conhecimentoService.readKnowledge();

        assistant = AiServices.builder(ConversationalAI.class)
            .chatLanguageModel(chatModel)
            .systemMessageProvider((memoryId) -> knowledge)
            .build();
    }

    public String processMessage(String message) {
        return assistant.chat(message);
    }

    public void addToKnowledgeBase(String knowledge) throws IOException {
        conhecimentoService.addKnowledge(knowledge);
    }
}
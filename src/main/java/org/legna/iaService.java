package org.legna;

import org.legna.ConversationalAiService;
import jakarta.inject.Inject;
import jakarta.enterprise.context.ApplicationScoped;
import java.io.IOException;

@ApplicationScoped
public class iaService {
    
    @Inject
    ConversationalAiService conversationalAiService;

    @Inject
    conhecimentoService conhecimentoService;

    public iaService() {
        // Construtor padrão para CDI
    }

    public String processMessage(String message) throws IOException {
        String knowledge = conhecimentoService.readKnowledge();
        return conversationalAiService.chat(message, knowledge);
    }

    public void addToKnowledgeBase(String knowledge) throws IOException {
        conhecimentoService.addKnowledge(knowledge);
    }
}
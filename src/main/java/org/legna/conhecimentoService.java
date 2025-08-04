package org.legna;

import jakarta.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

@ApplicationScoped
public class conhecimentoService {
    
        private static final String KNOWLEDGE_FILE = "src/main/resources/conhecimento.txt";

    public String readKnowledge() throws IOException {
        Path path = Paths.get(KNOWLEDGE_FILE);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        return Files.readString(path);
    }

    public static void addKnowledge(String newKnowledge) throws IOException {
        Path path = Paths.get(KNOWLEDGE_FILE);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
        Files.writeString(path, newKnowledge + "\n", StandardOpenOption.APPEND);
    }

}

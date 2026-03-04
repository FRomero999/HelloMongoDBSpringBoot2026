package org.example.hellomongodbspringboot2026.services;

import org.example.hellomongodbspringboot2026.repositories.NbaRepository;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.stereotype.Service;

@Service
class LLMService {
    private final OllamaChatModel chatModel;

    public LLMService(OllamaChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String generateHistory(String seed){
        var response = chatModel.call(
                new Prompt(
                        "Dime la historia el equipo "+seed+" de la NBA. Menos de 60 palabras.",
                        OllamaChatOptions.builder()
                                .model("llama3")
                                .temperature(1.0)
                                .build()
                ));
        return  response.getResult().getOutput().getText();
    }
}

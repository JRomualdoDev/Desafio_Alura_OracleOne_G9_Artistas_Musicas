package com.alura.desafio.desafioaluraoracleone.service;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Component;

@Component
public class ConsultaChatGPT {

    private final ChatModel chatModel;

    public ConsultaChatGPT(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String obterInformacaoArtista(String nomeArtista) {

        ChatResponse response = chatModel.call(
                new Prompt(
                        "Biografia do artista " + nomeArtista,
                    OpenAiChatOptions.builder()
                        .model("gpt-4o")
                        .temperature(0.7)
                        .build()
            )
        );

        return response.getResult().getOutput().getText();
    }
}

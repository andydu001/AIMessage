package org.example;

import dev.langchain4j.model.language.LanguageModel;

import dev.langchain4j.model.output.Response;
public class ChatMA01 implements LanguageModel {
    ChatMA01(){
        // Initialize the ChatMA-01 model here
    }


    @Override
    public Response<String> generate(String prompt) {
        return new Response<>(prompt);
    }
}

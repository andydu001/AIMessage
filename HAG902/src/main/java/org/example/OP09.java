/*

Andy D.
Building AI

 */

package org.example;

import dev.langchain4j.data.message.AiMessage;

import dev.langchain4j.data.message.ChatMessage;

import dev.langchain4j.model.chat.request.ChatRequest;

import dev.langchain4j.model.chat.request.DefaultChatRequestParameters;

import dev.langchain4j.model.chat.request.ToolChoice;

import dev.langchain4j.model.chat.request.json.JsonSchema;
import dev.langchain4j.model.output.Response;

import java.util.function.Consumer;

public class OP09 extends  ChatMA01{
    OP09(){
        Response<String> t  = generate("I want to send a chat message to you");

        ChatRequest request = ChatRequest.builder().

                messages(new AiMessage(t.content())).

                parameters(DefaultChatRequestParameters.

                        builder().modelName("Andy").maxOutputTokens(100).

                        toolChoice(ToolChoice.AUTO).responseFormat(JsonSchema.

                                builder().name("JSon").build()).build()).build();

        request.messages().iterator().forEachRemaining(new Consumer<ChatMessage>() {
            @Override
            public void accept(ChatMessage chatMessage) {
                System.out.println("OP09: " + chatMessage.type());
                System.out.println("OP09: " + chatMessage);
            }
        });


        String name =  request.parameters().modelName();
        System.out.println("OP09: " + name);
       // String done = t.finishReason().name();
        t.metadata().values().iterator().forEachRemaining(new Consumer<Object>() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });
     //   System.out.println("OP09: " + done);

    }
}


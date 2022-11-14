package com.basic.websocketraw;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@Log4j2
public class CustomWebSocketHandler extends TextWebSocketHandler {


    @Override
    public void handleTransportError(WebSocketSession session, Throwable throwable) throws Exception {
        log.error("error occured at sender " + session, throwable);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.printf("Session %s closed because of %s%n", session.getId(), status.getReason());
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("Connected.... " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage jsonTextMessage) throws Exception {
        System.out.println("message received: " + jsonTextMessage.getPayload());
        try {
            if(session.isOpen()) {
                session.sendMessage(jsonTextMessage);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

# Spring Boot WebSocket Raw Server

Spring WebSocket server without STOMP layer.

## Technologies

```text
Framework         : Spring Boot 2.7.5 + Java 11
Websocket library : Spring Boot Starter Websocket
```

## Usage

- Server : `mvn spring-boot:run`
- Client : `ws://localhost:8080/app`


## References

- [Spring websocket without stomp or sockjs](https://stackoverflow.com/a/32267452)
- [Send message to specific client](https://stackoverflow.com/questions/24073987/how-to-send-message-to-a-specific-device-by-spring-websocket)

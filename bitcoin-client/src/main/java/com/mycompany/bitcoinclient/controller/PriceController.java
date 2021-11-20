package com.mycompany.bitcoinclient.controller;

import com.mycompany.bitcoinclient.model.ChatComment;
import com.mycompany.bitcoinclient.model.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PriceController {

    private final SimpMessagingTemplate simpMessagingTemplate;


    @GetMapping("/")
    public String getPrices() {
        return "prices";
    }
    //收到信息自动响应
    @MessageMapping("/chat")
    public void addChatComment(@Payload Comment comment) {
        //ChatComment的静态构造方法（通过 @Value(staticConstructor = "of") 注解）
        ChatComment chatComment = ChatComment.of(comment.getFromUser(), comment.getMessage(), LocalDateTime.now());
        if (comment.getToUser().isEmpty()) {
            //封装@SendTo注解
            //需要配置Websocket
            simpMessagingTemplate.convertAndSend("/topic/comments", chatComment);
        } else {
            simpMessagingTemplate.convertAndSendToUser(comment.getToUser(), "/topic/comments", chatComment);
        }
    }
}

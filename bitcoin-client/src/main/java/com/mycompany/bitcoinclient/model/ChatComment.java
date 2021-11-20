package com.mycompany.bitcoinclient.model;

import lombok.Value;

import java.time.LocalDateTime;

//@Value(staticConstructor="of") feature, which will make the generated all-arguments constructor private,
// and generates a public static method named of which is a wrapper around this private constructor.
@Value(staticConstructor = "of")
public class ChatComment {

    String fromUser;
    String message;
    LocalDateTime timestamp;
}

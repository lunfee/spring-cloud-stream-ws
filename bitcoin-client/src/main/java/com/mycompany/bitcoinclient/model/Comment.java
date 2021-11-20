package com.mycompany.bitcoinclient.model;

import lombok.Value;
//@Value is shorthand for: final @ToString @EqualsAndHashCode @AllArgsConstructor @FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE) @Getter
//生成的是final的，只用getter没有setter
@Value
public class Comment {

    String fromUser;
    String toUser;
    String message;
}

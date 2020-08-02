package xyz.crearts.infra.chat.exception;

import lombok.Getter;

public enum ChatMessageCode {
    CHAT_MSG_CODE_INVALID_MSG_ID(1000, "Invalid message Id"),
    CHAT_MSG_CODE_INVALID_MSG_MAGIC(1001, "Invalid magic code"),
    CHAT_MSG_CODE_INVALID_MSG_FORMAT(1002, "Invalid message format"),
    CHAT_MSG_CODE_UNSUPPORTED_TYPE(1003, "Unsupported type"),
    CHAT_MSG_CODE_UNKNOWN(4000);

    ChatMessageCode(int code) {
        this.code = code;
    }
    ChatMessageCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Getter
    private int code;

    @Getter
    private String message;
}

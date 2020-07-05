package xyz.crearts.infra.chat.exception;

public class ChatMessageException extends RuntimeException {
    public ChatMessageException(ChatMessageCode code) {
    }

    public ChatMessageException(ChatMessageCode code, String message) {
        super(message);
    }

    public ChatMessageException(ChatMessageCode code, String message, Throwable cause) {
        super(message, cause);
    }

    public ChatMessageException(ChatMessageCode code, Throwable cause) {
        super(cause);
    }

    public ChatMessageException(ChatMessageCode code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

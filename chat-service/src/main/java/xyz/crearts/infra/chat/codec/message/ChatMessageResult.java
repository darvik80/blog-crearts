package xyz.crearts.infra.chat.codec.message;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.beanutils.ConvertUtils;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ChatMessageResult extends ChatMessage {
    private int code;
    private String message;

    @Setter(AccessLevel.NONE)
    private Map<String, Object> extraData = new HashMap<>();

    public void setExtra(String key, Object value) {
        if (value instanceof String) {
            extraData.put(key, value);
        } else {
            extraData.put(key, ConvertUtils.convert(value, Long.class));
        }
    }

    public <T> T getExtra(String key, Class<?> cls) {
        return (T)ConvertUtils.convert(extraData.get(key), cls);
    }
}

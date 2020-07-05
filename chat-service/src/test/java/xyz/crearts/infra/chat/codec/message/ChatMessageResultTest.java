package xyz.crearts.infra.chat.codec.message;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChatMessageResultTest {

    @Test
    void setExtra() {
    }

    @Test
    void getExtra() {
        ChatMessageResult res = new ChatMessageResult();
        res.setExtra("code", "test");
        var data = res.getExtra("code", String.class);
        assertEquals("test", data);

        res.setExtra("code", 1000);
        short sh = res.getExtra("code", Short.class);
        assertEquals(1000, sh);
    }
}
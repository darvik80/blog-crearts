package xyz.crearts.blog.jpa.enums;

public enum ContentStatus {
    CS_DRAFT("draft"),
    CS_PENDING("pending"),
    CS_PUBLISHED("published"),
    CS_DELETED("'deleted'");

    ContentStatus(String name) {
        this.name = name;
    }

    private String name;
}

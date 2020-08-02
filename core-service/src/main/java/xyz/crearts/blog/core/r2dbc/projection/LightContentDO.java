package xyz.crearts.blog.core.r2dbc.projection;

public interface LightContentDO {
    Long getId();
    String getTitle();
    String getContent();
    String getTags();
}

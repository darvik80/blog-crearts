package xyz.crearts.blog.core.r2dbc.repository;

public class ContentSql {
    public final static String GET_CONTENT_PAGE =
        "SELECT id, title, SUBSTRING(content, 1, 1024) as content, " +
            "(SELECT concat('[', group_concat(JSON_OBJECT('id', tag.id, 'name', tag.name, 'color', tag.color)), ']') " +
                "FROM link_content_tag JOIN tag ON tag.id = link_content_tag.tag_id WHERE content_id = content.id GROUP BY content_id) AS tags " +
        "FROM content LIMIT :page OFFSET :start";

    public final static String GET_CONTENT =
            "SELECT content.*, " +
                    "(SELECT concat('[', group_concat(JSON_OBJECT('id', tag.id, 'name', tag.name, 'color', tag.color)), ']') " +
                    "FROM link_content_tag JOIN tag ON tag.id = link_content_tag.tag_id WHERE content_id = content.id GROUP BY content_id) AS tags " +
                    "FROM content WHERE id=:id";
}

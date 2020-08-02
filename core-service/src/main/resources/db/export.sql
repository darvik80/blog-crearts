-- EXPLAIN

--- get content data
SELECT
	id,
    title,
    SUBSTRING(content, 1, 1024) as content,
    (
		SELECT
		    concat(
		        "[",
                group_concat(
                    JSON_OBJECT(
                        'tag_id', tag.id,
                        'tag_name', tag.name,
                        'tag_color', tag.color
                    )
                ),
                "]"
            )
		FROM
			link_content_tag
		JOIN
			tag
		ON
			tag.id = link_content_tag.tag_id
		WHERE
			content_id = content.id
		GROUP BY
			content_id
	) AS tag
FROM
	content
WHERE
	id = 1

	{"tag_id": 1, "tag_name": "dev", "tag_color": 8509648},{"tag_id": 2, "tag_name": "java", "tag_color": 9879787},{"tag_id": 7, "tag_name": "vietnam", "tag_color": 16711680}

import React from "react";
import {Container, Row} from "react-bootstrap";

import blogImg from "../assets/img/blog-trumb.jpg";
import articlesImg from "../assets/img/articles-trumb-rect.jpg";
import Blocks from "../components/Blocks";

export default function Main() {
    const data = {
        height: 512,
        context: [
            {
                href: "/blog",
                alt: "Blog",
                image: blogImg,
            }, {
                href: "/articles",
                alt: "Articles",
                image: articlesImg
            }
        ]
    }

    return (
        <Container>
            <Row>
                <Blocks data={data}/>
            </Row>
        </Container>
    )
}
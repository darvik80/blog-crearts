import React, {useEffect, useRef, useState} from "react";
import {Container, Col, Row} from "react-bootstrap";

import blogImg from "../assets/img/blog-trumb.jpg";
import articlesImg from "../assets/img/articles-trumb-rect.jpg";
import Image from "react-bootstrap/Image";

let idx = 0.00;

export default function Main(props) {
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

    const [sinPos, setSinPos] = useState(0);
    const [cosPos, setCosPos] = useState(0);

    useEffect(() => {
        let interval = setInterval(() => {
            setSinPos(128 + Math.sin(Math.PI * idx) * 64);
            setCosPos(128 + Math.cos(Math.PI * idx) * 64);

            idx += 0.01;
            if (idx > 2) idx = 0;
        }, 50);
        return () => clearInterval(interval);
    }, [setSinPos, sinPos, setCosPos, cosPos]);

    const style = {
        height: data.height + "px",
    }

    let blocks = data.context.map((item, idx) => {
        <Row key={idx}>
            <Col>
                <a href={item.href}>
                    <Image roundedCircle
                           src={item.imageg}
                           style={{position: "relative", top: sinPos + "px"}}
                           width={data.height/2}
                    />
                </a>
            </Col>
        </Row>
    })

    return (
        <Container style={style}>
            <Row>
                <Col className="text-center">
                    <a href={"/blog"}>
                        <Image roundedCircle
                               src={blogImg}
                               style={{position: "relative", top: sinPos + "px"}}
                               width={data.height/2}
                        />
                    </a>
                </Col>
                <Col className="text-center">
                    <a href={"/articles"}>
                        <Image roundedCircle
                               src={articlesImg}
                               style={{position: "relative", top: cosPos + "px"}}
                               width={data.height}
                        />
                    </a>
                </Col>
            </Row>
        </Container>
    )
}
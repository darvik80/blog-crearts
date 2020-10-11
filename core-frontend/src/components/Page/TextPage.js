import {Col, Container, Pagination, Row} from "react-bootstrap";
import TextBlock from "./TextBlock";
import React from "react";

export default function TextPage(props) {
    let cards = props.data.map((item, idx) =>
        (
            <Row key={idx}>
                <Col>
                    <TextBlock
                        state={(idx & 0x01 ? 'right' : 'left')}
                        image={item.image}
                        title={item.title}
                        text={item.text}
                        tags={item.tags}
                    />
                </Col>
            </Row>
        )
    )

    return (
        <Container>
            {cards}
            <Row>
                <Col>
                    <Pagination size='sm' className="justify-content-center">
                        <Pagination.First/>
                        <Pagination.Prev/>
                        <Pagination.Item>{1}</Pagination.Item>
                        <Pagination.Item>{2}</Pagination.Item>
                        <Pagination.Ellipsis/>
                        <Pagination.Item>{8}</Pagination.Item>
                        <Pagination.Item active>{9}</Pagination.Item>
                        <Pagination.Item>{10}</Pagination.Item>
                        <Pagination.Ellipsis/>
                        <Pagination.Item>{20}</Pagination.Item>
                        <Pagination.Item>{21}</Pagination.Item>
                        <Pagination.Next/>
                        <Pagination.Last/>
                    </Pagination>
                </Col>
            </Row>
        </Container>
    );
}
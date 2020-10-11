import React from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import Media from "react-bootstrap/Media";

export default function TextBlock(props) {
    let tags = props.tags.map((val, idx) =>
        (
            <Badge key={idx} variant={val.color}>{val.tag}</Badge>
        )
    )

    return (
        <Media border="0">
            <Media.Body>
                <h4 className={"text-" + props.state}>{props.title}</h4>
                <div>
                    <Row>
                        <Col className="text-justify">{props.text}</Col>
                        <Col md={1} className={"order-" + (props.state === 'left' ? "first" : "last")}>
                            <Image fluid rounded src={props.image} width={64}/>
                        </Col>
                    </Row>
                    <Row>
                        <Col md={1}/>
                        <Col className={"text-" + props.state}>{tags}</Col>
                        <Col md={1}/>
                    </Row>
                </div>
            </Media.Body>
        </Media>
    )
}

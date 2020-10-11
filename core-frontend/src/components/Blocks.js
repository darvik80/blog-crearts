import React, {useEffect, useState} from "react";
import {Col, Container, Row} from "react-bootstrap";
import Image from "react-bootstrap/Image";

function calcSin(idx) {
    return 128 + Math.sin(Math.PI * idx) * 64;
}

function calcCos(idx) {
    return 128 + Math.cos(Math.PI * idx) * 64;
}

export default function Blocks(props) {
    const [idx, setIdx] = useState(1.00);
    const [sinPos, setSinPos] = useState(calcSin(idx));
    const [cosPos, setCosPos] = useState(calcCos(idx));

    useEffect(() => {
        const interval = setInterval(() => {
            setSinPos(calcSin(idx));
            setCosPos(calcCos(idx));

            setIdx(idx + 0.005)
            if (idx > 2) setIdx(0);
        }, 25);

        return () => clearInterval(interval);
    }, [idx, sinPos, cosPos]);

    let blocks = props.data.context.map((item, idx) =>
        (
            <Col key={idx}>
                <a href={item.href}>
                    <Image roundedCircle
                           src={item.image}
                           style={{position: "relative", top: (idx & 0x01 ? sinPos : cosPos) + "px"}}
                           width={props.data.height / 2}
                    />
                </a>
            </Col>
        )
    )

    return (
        <Container style={{height: props.data.height + "px"}} className="text-center bg-dark rounded">
            <Row>
                {blocks}
            </Row>
        </Container>
    )

}
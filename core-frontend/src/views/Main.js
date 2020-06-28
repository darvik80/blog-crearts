import React from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import forest from "../assets/img/wallpapers/forest-nature.jpg";

export default function Main() {
    return (
        <div>
            <Row>
                <Col>
                        <img
                            width="100%"
                            height="100%"
                            className="mr-3"
                            src={forest}
                            alt="Generic placeholder"
                        />
                </Col>
            </Row>
        </div>
    );
}
import React from "react";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Media from "react-bootstrap/Media";
import logoArdiono from "../assets/img/logo-arduino.png";
import logoRaspberry from "../assets/img/logo-raspberry-pi.png";

export default function Articles() {
    return (
        <div>
            <Row>
                <Col className="text-justify">
                    <Media>
                        <img
                            width={64}
                            height={64}
                            className="mr-3"
                            src={logoArdiono}
                            alt="Generic placeholder"
                        />
                        <Media.Body>
                            <h5 className="text-left">Media Heading</h5>
                            <p>
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                                ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                                tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                                Donec lacinia congue felis in faucibus.
                            </p>
                        </Media.Body>
                    </Media>
                    <Media>
                        <Media.Body>
                            <h5 className="text-right">Media Heading</h5>
                            <p>
                                Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque
                                ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at,
                                tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla.
                                Donec lacinia congue felis in faucibus.
                            </p>
                        </Media.Body>
                        <img
                            width={64}
                            height={64}
                            className="ml-3"
                            src={logoRaspberry}
                            alt="Generic placeholder"
                        />
                    </Media>
                </Col>
            </Row>
        </div>
    );
}
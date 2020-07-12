import React, {useRef, useState} from "react";
import {Button, Col, Container, Form, InputGroup, Row} from "react-bootstrap";
import JoditEditor from "jodit-react";

export default function ContentEditor(props) {
    const editor = useRef(null)
    const [content, setContent] = useState('')

    const config = {
        readonly: false, // all options from https://xdsoft.net/jodit/doc/
        height: 480,
        toolbarButtonSize: "small"
    }
    return (
        <Container fluid>
            <Row>
                <Col md={12}>
                    <Form>
                        <Form.Group>
                            <Form.Row>
                                <Col md={8}>
                                    <InputGroup inline controlId="formTitle">
                                        <InputGroup.Prepend>
                                            <InputGroup.Text>Title</InputGroup.Text>
                                        </InputGroup.Prepend>

                                        <Form.Control type="text" placeholder="Enter some title"/>
                                    </InputGroup>
                                </Col>
                                <Col md={4}>

                                    <InputGroup inline controlId="formTitle">
                                        <InputGroup.Prepend>
                                            <InputGroup.Text>Link</InputGroup.Text>
                                        </InputGroup.Prepend>

                                        <Form.Control type="text" placeholder="Enter link"/>
                                    </InputGroup>
                                </Col>
                            </Form.Row>
                        </Form.Group>

                        <Form.Group controlId="formContent">
                            <JoditEditor
                                ref={editor}
                                value={content}
                                config={config}
                                tabIndex={1} // tabIndex of textarea
                                onBlur={newContent => setContent(newContent)} // preferred to use only this option to update the content for performance reasons
                                onChange={newContent => {
                                    console.log(newContent)
                                }}
                            />
                        </Form.Group>
                        <Button variant="primary" type="submit">
                            Submit
                        </Button>
                    </Form>
                </Col>
            </Row>
        </Container>
    )
}
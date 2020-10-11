import React from 'react';
import './App.css';
import Container from 'react-bootstrap/Container';
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Form from "react-bootstrap/Form";
import FormControl from "react-bootstrap/FormControl";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Button from "react-bootstrap/Button";
import logo from "./assets/img/logo.png"
import Image from "react-bootstrap/Image";
import Switch from "react-bootstrap/Switch";
import Route from "react-router-dom/es/Route";

import Blog from "./views/Blog";
import Articles from "./views/Articles";
import Main from "./views/Main";

function App() {

    return (
        <Container>
            <Row>
                <Col>
                    <Navbar expand="lg">
                        <Navbar.Brand href="#home">
                            <Image src={logo} alt="logo-" height="128"/>
                        </Navbar.Brand>
                        <Navbar.Toggle aria-controls="basic-navbar-nav"/>
                        <Navbar.Collapse id="basic-navbar-nav">
                            <Nav className="mr-auto">
                                <Nav.Item>
                                    <Nav.Link href="/">Home</Nav.Link>
                                </Nav.Item>
                                <Nav.Item>
                                    <Nav.Link href="/blog">Blog</Nav.Link>
                                </Nav.Item>
                                <Nav.Item>
                                    <Nav.Link href="/articles">Articles</Nav.Link>
                                </Nav.Item>
                            </Nav>
                            <Form inline>
                                <FormControl type="text" placeholder="Search" className="mr-sm-2"/>
                                <Button variant="outline-success">Search</Button>
                            </Form>
                        </Navbar.Collapse>
                    </Navbar>
                </Col>
            </Row>
            <Row>
                <Col>
                    <Switch>
                        <Route exact path='/' component={Main}/>
                        <Route path='/blog' component={Blog}/>
                        <Route path='/articles' component={Articles}/>
                    </Switch>
                </Col>
            </Row>
            <Row>
                <Col className="text-right"><small>Copyright 2020</small></Col>
            </Row>

        </Container>
    );
}

export default App;

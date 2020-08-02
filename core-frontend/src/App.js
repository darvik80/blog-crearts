import React from 'react';
import './App.css';
import Container from 'react-bootstrap/Container';
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import Main from "./views/Main";
import Route from "react-router-dom/es/Route";
import Switch from "react-bootstrap/cjs/Switch";
import Articles from "./views/Articles";
import logo from "./assets/img/logo.png"
import ContentEditor from "./views/admin/ContentEditor";

function App() {

    return (
        <Container fluid>
            <Row>
                <Col>
                    <h1>
                        <a href="/">
                            <img src={logo} alt="logo-" height="128"/>
                        </a>
                    </h1>
                </Col>
            </Row>
            <Row>
                <Col md={2} className="text-left">
                    <Row>
                        <Col>
                            <Navbar expand="lg" variant="light">
                                <Navbar.Collapse>
                                    <Nav className="mr-auto flex-column">
                                        <Nav.Link href="/">Home</Nav.Link>
                                        <Nav.Link href="/articles">Статьи</Nav.Link>
                                        <Nav.Link href="/blog">Блог</Nav.Link>
                                    </Nav>
                                </Navbar.Collapse>
                            </Navbar>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <Navbar expand="lg" variant="light">
                                <Navbar.Collapse>
                                    <Nav className="mr-auto flex-column">
                                        <Nav.Link href="/admin/content">Add Content</Nav.Link>
                                    </Nav>
                                </Navbar.Collapse>
                            </Navbar>
                        </Col>
                    </Row>
                </Col>
                <Col md={8} className="text-justify">
                    <Switch>
                        <Route exact path='/' component={Main}/>
                        <Route path='/articles' component={Articles}/>
                        <Route path='/blog' component={Main}/>

                        <Route path='/admin/content' component={ContentEditor}/>
                    </Switch>
                </Col>
                <Col md={2}></Col>
            </Row>
            <Row>
                <Col className="text-right"><small>Copyright 2020</small></Col>
            </Row>
        </Container>
    );
}

export default App;

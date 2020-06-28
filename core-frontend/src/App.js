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
import logoGear from "./assets/img/logo-gear.png"

function App() {

    return (
        <Container fluid>
            <Row>
                <Col>
                    <h1>
                        <a href="/">
                            <img src={logoGear} alt="logo-gear" width={48}/>
                            <b style={{color: 'red'}}>C</b>
                            <b style={{color: 'blue'}}>r</b>
                            <b style={{color: 'green'}}>e</b>
                            <b style={{color: 'black'}}>A</b>
                            <b style={{color: 'teal'}}>r</b>
                            <b style={{color: 'orange'}}>t</b>
                            <b style={{color: 'lime'}}>S</b>
                            <b>.xyz</b>
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
                </Col>
                <Col md={8} className="text-justify">
                    <Switch>
                        <Route exact path='/' component={Main}/>
                        <Route path='/articles' component={Articles}/>
                        <Route path='/blog' component={Main}/>
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

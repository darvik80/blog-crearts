import React from 'react';
import logo from './logo.svg';
import './App.css';
import HelloWorld from './components/HelloWorld';
import Letter from './components/Letter';

import Jumbotron from 'react-bootstrap/Jumbotron';
import Container from 'react-bootstrap/Container';
import {Button,Alert} from "react-bootstrap";


function App() {
    return (
        <Container className="p-3">
            <Jumbotron>
                <h1 className="header">Welcome To React-Bootstrap</h1>
                <img src={logo} className="App-logo" alt="logo"/>
                <HelloWorld mainTarget="Ivan"/>
                <div>
                    <Letter bgcolor="#58b3ff">H</Letter>
                    <Letter bgcolor="#ff605f">e</Letter>
                    <Letter bgcolor="#ffd52e">l</Letter>
                    <Letter bgcolor="#49dd8e">l</Letter>
                    <Letter bgcolor="#ae99ff">o</Letter>
                </div>
                <div><Button size="lg" variant="info">Submit</Button></div>

                <Alert variant="info">
                    Just a message
                </Alert>
            </Jumbotron>
        </Container>
    );
}

export default App;

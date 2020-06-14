import React from "react";

export default class HelloWorld extends React.Component {
    constructor(props, context) {
        super(props, context);
    }

    render() {
        return <p>Hello, {this.props.mainTarget}</p>;
    }
}

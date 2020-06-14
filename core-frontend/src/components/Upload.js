import React, { Component } from 'react'
import './Upload.css'

class Upload extends Component {
    constructor(props) {
        super(props)
    }

    render() {
        return (
            <div className="upload">
                <span className="title">Upload Files</span>
                <div className="content">
                    <div />
                    <div className="files" />
                </div>
                <div className="actions" />
            </div>
        )
    }
}
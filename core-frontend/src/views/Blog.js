import React from "react";
import raspberry from "../assets/img/logo-raspberry-pi.png";
import arduino from "../assets/img/logo-arduino.png";
import TextPage from "../components/Page/TextPage";

export default function Blog() {
    let data = [
        {
            image: raspberry,
            title: "Raspberry playbook",
            text: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            tags: [
                {tag: "dev", color: "primary"},
                {tag: "c++", color: "danger"},
                {tag: "raspberry", color: "dark"}
            ]
        }, {
            image: arduino,
            title: "Arduino & Led Button",
            text: "Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
            tags: [
                {tag: "dev", color: "primary"},
                {tag: "tools", color: "info"}
            ]
        }
    ]

    return (
        <TextPage data = {data}/>
    )
}
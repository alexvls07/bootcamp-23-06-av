import {useEffect, useState} from "react";
import Tweet from "./Tweet";

function NewTweet(props) {

    const formData = new FormData();
    formData.append('user_id','text');

    let [newTweet, setNewTweet] = useState(props.newTweet)

}

let formData;
fetch(`http://localhost:8080/tweet`, {
        method: "POST",
        body: formData
    })
        .then(response => response.json());

export default NewTweet;
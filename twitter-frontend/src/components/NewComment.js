import {useEffect, useState} from "react";
import Tweet from "./Tweet";

function NewComment(props) {

    const formData = new FormData();
    formData.append('twit_id','comment_text');

    let [newComment, setNewComment] = useState(props.newComment)

}

let formData;
fetch(`http://localhost:8080/comments`, {
    method: "POST",
    body: formData
})
    .then(response => response.json());

export default NewComment;


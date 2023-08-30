
import {useEffect, useState} from "react";
import Comment from "./Comment";

function Comments(props) {


    let [comments, setComments] = useState([])


    useEffect(() => {
        console.log("prop.comments", props.comments)
        setComments(props.comments)
    }, [props])



    return (
        <div className="comment-list-container">
            <h3>Comments:</h3>
            {comments.map((comment)=> {
                return <Comment comment={comment} />
            })}


        </div>
    );
}

export default Comments;
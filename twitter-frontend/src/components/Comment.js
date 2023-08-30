import {useEffect, useState} from "react";

function Comment(props) {



    let [comment, setComment] = useState({})


    useEffect(() => {
        setComment(props.comment)
    }, [props])


    return (
        <div className="comment-container">
            <div className="profile-image-container">
                <img src="https://via.placeholder.com/50" alt="follower image"></img>
            </div>
            <div className="comment-text">
                <h2>{comment.commentText}</h2>
            </div>
        </div>
    );
}

export default Comment;
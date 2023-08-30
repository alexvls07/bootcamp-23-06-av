import {useEffect, useState} from "react";
import comment from "./Comment";
import Comments from "./Comments";

function Tweet(props) {


    let [tweet, setTweet] = useState(props.tweet)
    let [user, setUser] = useState({})
    let [comments, setComments] = useState([])
    let authCredentials = localStorage.getItem("authToken");

    useEffect(() => {
        fetch(`http://localhost:8080/user/${tweet.userId}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            }

        })
            .then(response => response.json())
            .then(user => {
                setUser(user);
            });
    }, [])

    useEffect(() => {
        fetch(`http://localhost:8080/tweet/${tweet.tweetId}/comments`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            }

        })
            .then(response => response.json())
            .then(comments => {
                setComments(comments);
            });
    }, [])
    //fetch user that created this tweet
    // fetch comments of this tweet


    return (
        <div className="tweet-container">
            <div className={"user-info"}>
                <div className="profile-name-container">
                    <img src="https://via.placeholder.com/50" alt="follower image"></img>
                </div>
                <div className="user-name-container">
                    <h2>{user.name}</h2>
                </div>
            </div>
            <div className="tweet-text">
                <h2>Tweet:</h2>
                <p>{tweet.text}</p>
            </div>
            <div className="comments-container">
                {/*this is list of comments*/}
                <Comments comments={comments}/>
            </div>

        </div>
    );
}

export default Tweet;
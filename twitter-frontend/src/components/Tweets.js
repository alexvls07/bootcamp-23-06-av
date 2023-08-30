import Follower from "./Follower";
import {useEffect, useState} from "react";
import Tweet from "./Tweet";

function Tweets(prop) {


    let [tweets, setTweets] = useState([])

    let authCredentials = localStorage.getItem("authToken");

    useEffect(() => {
        let getTweetsURL=`http://localhost:8080/tweet`
        if (prop.userId) {
            // the bellow endpoint needs to be created in the Backend
            getTweetsURL = `http://localhost:8080/user/${prop.userId}/tweets`
        }
        fetch(getTweetsURL, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            }

        })
            .then(response => response.json())
            .then(tweets => {
                setTweets(tweets);


            });
    }, [prop])



    return (
        <div className={"news-feed-container"}>

            {tweets.map((tweet)=> {
                return <Tweet tweet={tweet} />

            })}


        </div>
    );
}

export default Tweets;
import Followers from "../components/Followers";
import Tweets from "../components/Tweets";
import Comments from "../components/Comments";
import {useSearchParams} from "react-router-dom";
import {useEffect, useState} from "react";
import TwitterNewsFeed from "../components/TwitterNewsFeed";

function UserPage(props) {

    const [searchParams, setSearchParams] = useSearchParams();

    let userId = searchParams.get("userId")

    let [user, setUser] = useState({});
    let [newTweet, setNewTweet] = useState({text: ""});
    let [reloadData, setReloadData] = useState(false);


    let authCredentials = localStorage.getItem("authToken");
    let loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));


    //on component mount
    // on component create
    // on page load
    useEffect(() => {

        console.log("UserPage mounted");

        fetch(`http://localhost:8080/user/${userId}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            }

        })
            .then(response => response.json())
            .then(data => {
                setUser(data);
            });

        fetch(`http://localhost:8080/tweet`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            }


        })
            .then(response => response.json())
            .then(data => {
                setUser(data);
            });
        setReloadData(false);


    }, [reloadData])

    const handleNewTweetChange = (event) => {
        setNewTweet({...newTweet, [event.target.name]: event.target.value});
    }
    const handleNewTweetSubmit = (event) => {
        event.preventDefault();


        fetch(`http://localhost:8080/tweet`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            },
            body: JSON.stringify({
                "userId": loggedInUser.id,
                "text": newTweet.text
            })
        })
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                }

                throw new Error("Error creating tweet")

            })
            .then(data => {

                setReloadData(true);
                setNewTweet({text: ""})

            })
            .catch(e => {
                alert("Error creating tweet");
            })

    }


    return (
        <main className="content-wrapper">
            <aside className="aside-container">

                <Followers/>

            </aside>


            <div className="main-container">

                <div>
                    <Tweets userId={userId}>
                    </Tweets>
                </div>
                <div>


                    <form className="new-tweet" onSubmit={handleNewTweetSubmit}>
                        <label htmlFor="Tweets">Post a tweet:</label>
                        <textarea id="Tweetpost" name="text" rows="4" cols="50"
                                  value={newTweet.text}
                                  onChange={handleNewTweetChange}>
                            <button className="post-button" type="submit">Login</button>
                        </textarea>


                        <button className="new-tweet-button" type="submit">Post</button>
                    </form>

                </div>

            </div>

        </main>
    );
}

export default UserPage;

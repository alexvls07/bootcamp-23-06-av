import Followers from "../components/Followers";
import TwitterNewsFeed from "../components/TwitterNewsFeed";
import Tweets from "../components/Tweets";
import Comments from "../components/Comments";
import {useEffect, useState} from "react";

function HomePage(props) {

    let [authToken, setAuthToken] = useState("");

    useEffect(() => {
        setAuthToken(localStorage.getItem("authToken"));
    })


    return (
        <main className="content-wrapper">
            <aside className="aside-container">

                <Followers />

            </aside>



            <div className="main-container">

                <TwitterNewsFeed />

            </div>

        </main>
    );
}

export default HomePage;
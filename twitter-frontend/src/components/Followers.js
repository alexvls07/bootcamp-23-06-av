import Follower from "./Follower";
import {useEffect, useState} from "react";

function Followers() {


    let [followers, setFollowers] = useState([])

    let authCredentials = localStorage.getItem("authToken");

    useEffect(() => {
        fetch(`http://localhost:8080/user`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + authCredentials
            }

        })
            .then(response => response.json())
            .then(data => {
                setFollowers(data);
            });
    }, [])



    return (
        <div className="follower-list-container">

            {followers.map((follower)=> {
                return <Follower follower={follower} />
            })}


        </div>
    );
}

export default Followers;
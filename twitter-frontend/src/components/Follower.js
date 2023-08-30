function Follower(props) {



    let follower = props.follower;

    return (
        <div className="follower-container">
            <div className="profile-image-container">
                <img src="https://via.placeholder.com/50" alt="follower image"></img>
            </div>
            <div className="follower-name-container">
                <h2>{follower.name}</h2>
            </div>
        </div>
    );
}

export default Follower;
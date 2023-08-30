import {Link, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import userPage from "../pages/UserPage";


function Header(props) {

    const navigate = useNavigate();


   // let profileURL = `/users?userId=${props.user.id}`;

    let logout = () => {
        props.setLogoutTriggered(true);

        navigate('/auth');
    }

    //
     let [profileURL, setProfileURL] = useState('')
     useEffect(() =>{
         let loggedInUser = props.user;
         setProfileURL(`/user?userId=${loggedInUser.id}`);
     }, [])




    return (
        <header className="header-container">
            <h1 className="site-title">My Site</h1>
            <div></div>
            <nav>
                <Link className="menu-item" to="/">Home</Link>

                {props.user.email ?
                    <div>
                        <Link className="menu-item" to={profileURL}>Profile</Link>
                        <a onClick={logout}>Logout</a>
                    </div>
                    :
                    <Link className="menu-item" to="/auth">Login/Sign Up</Link>}

                <Link className="menu-item" to="/error">Error Page</Link>
            </nav>
        </header>
    );
}

export default Header;
import Followers from "../components/Followers";
import TwitterNewsFeed from "../components/TwitterNewsFeed";
import {useState} from "react";
import {json, useNavigate} from "react-router-dom";

function LoginPage(props) {

    let [loginForm, setLoginForm] = useState({email: "", password: ""});

    const navigate = useNavigate();

    const handleLoginSubmit = (event) => {
        event.preventDefault();



        // Encode the username and password in the Base64 auth format
        const basicAuth = btoa(`${loginForm.email}:${loginForm.password}`);

        fetch(`http://localhost:8080/user?email=${loginForm.email}`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Basic " + basicAuth
            }
        })
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                }

                throw new Error("Invalid credentials")

            })
            .then(data =>{

                localStorage.setItem("authToken", basicAuth);
                localStorage.setItem("loggedInUser", JSON.stringify(data[0]));

                props.setLoginTriggered(true);

                navigate('/users?userId=1');

            })
            .catch(e=>{
            alert("Invalid credentials");
        })




    }

    const handleLoginChange = (event) => {
        setLoginForm({...loginForm, [event.target.name]: event.target.value});
    }


    return (
        <main className="content-wrapper">
            <aside className="aside-container">


            </aside>

            <div className="main-container">

                <div className="login-signup-form-container">

                    <div className="login-container">

                        <form className="login-form" onSubmit={handleLoginSubmit}>

                            <label htmlFor="login-email-id">Email:</label><br></br>
                            <input className="login-input"
                                   type="text"
                                   id="login-email-id"
                                   name="email"
                                   value={loginForm.email}
                                   onChange={handleLoginChange}>

                            </input><br></br>

                            <label htmlFor="login-password-id">Password:</label><br></br>
                            <input className="login-input"
                                   type="password"
                                   id="login-password-id"
                                   name="password"
                                   value={loginForm.password}
                                   onChange={handleLoginChange}></input><br></br>

                            <button className="login-button" type="submit">Login</button>

                        </form>

                    </div>

                    <div className="signup-container">
                        TBD...
                    </div>

                </div>


            </div>

        </main>
    );
}

export default LoginPage;
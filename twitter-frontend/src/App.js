import './App.css';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import HomePage from "./pages/HomePage";
import NoPage from "./pages/NoPage";
import UserPage from "./pages/UserPage";
import LoginPage from "./pages/LoginPage";
import "./assets/styles.css"
import {useEffect, useState} from "react";

let fname = (x) => 2 * x;

function App() {

    let [user, setUser] = useState({});
    let [loginTriggered, setLoginTriggered] = useState(false);
    let [logoutTriggered, setLogoutTriggered] = useState(false);


    useEffect(() => {
        let loggedInUser = (localStorage.getItem("loggedInUser"))
        if (loggedInUser) {
            setUser(loggedInUser);
        }
    }, [])

    useEffect(() => {
        if (loginTriggered) {
            let loggedInUser = (localStorage.getItem("loggedInUser"))
            if (loggedInUser) {
                setUser(loggedInUser);
            }
            setLoginTriggered(false);
        }
        if (logoutTriggered) {
            setUser({});
            localStorage.removeItem("loggedInUser");
            localStorage.removeItem("authToken");
            setLogoutTriggered(false);
        }
    }, [loginTriggered, logoutTriggered])



  return (
      <BrowserRouter>

        <div className="page-container">
            <Header user={user} setLogoutTriggered = {setLogoutTriggered}/>
          <Routes>
            <Route index element={<HomePage />} />
            <Route path="/users" element={<UserPage />} />
            <Route path="*" element={<NoPage />} />
              <Route path="/auth" element={<LoginPage setLoginTriggered = {setLoginTriggered}/>} />

          </Routes>

          <Footer/>

        </div>

      </BrowserRouter>
  );
}

export default App;

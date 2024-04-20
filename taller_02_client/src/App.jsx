import './App.css'
import {Link, Outlet} from "react-router-dom";
function App() {

  return (
    <>
      <Link to={"/register"}>Register</Link>
      <Outlet />
    </>
  )
}

export default App;

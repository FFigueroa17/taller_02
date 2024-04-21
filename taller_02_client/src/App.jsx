import './App.css'
import {createBrowserRouter, RouterProvider} from "react-router-dom";

import {LOGIN, PRIVATE, SIGNUP} from "@/routes/path.jsx";
import PrivateRoute from "@/routes/PrivateRoute.jsx";
import Private from "@/views/Private.jsx";
import PublicRoute from "@/routes/PublicRoute.jsx";
import Home from "@/views/Home.jsx";
import Login from "@/views/Login.jsx";
import {SignUp} from "@/views/SignUp.jsx";

const router = createBrowserRouter([
    {
        path: PRIVATE,
        element: <PrivateRoute />,
        children: [
            {
                index: true,
                element: <Private />
            }
        ]
    },
    {
        path: '/',
        element: <PublicRoute />,
        children: [
            {
                index: true,
                element:<Home/>
            },
            {
                path: LOGIN,
                element: <Login />
            },
            {
                path: SIGNUP,
                element: <SignUp/>
            }
        ]
    }
]);

function App() {
  return (
          <RouterProvider router={router} />
  )
}

export default App;

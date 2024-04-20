import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'

import {UserContextProvider} from './contexts/UserContext.jsx';
import { Toaster } from "@/components/ui/toaster";
import {createBrowserRouter, RouterProvider} from "react-router-dom";
import Home from "@/views/Home.jsx";
import {LOGIN, LOGOUT, PRIVATE, SIGNUP} from "@/routes/path.jsx";
import PublicRoute from "@/routes/PublicRoute.jsx";
import PrivateRoute from "@/routes/PrivateRoute.jsx";
import Login from "@/views/Login.jsx";
import Logout from "@/views/Logut.jsx";
import Private from "@/views/Private.jsx";
import {SignUp} from "@/views/SignUp.jsx";

import axios from "axios";

axios.defaults.baseURL = import.meta.env.VITE_APIENDPOINT || "http://localhost:8080/api/user";

const router = createBrowserRouter([
    {
        path: PRIVATE,
        element: <PrivateRoute />,
        children: [
            {
                index: true,
                element: <Private />
            },
            {
                path: LOGOUT,
                element: <Logout />
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

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
      <UserContextProvider>
          <Toaster />
          <RouterProvider router={router} />
      </UserContextProvider>
  </React.StrictMode>,
)

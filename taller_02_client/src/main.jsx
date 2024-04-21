import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'

import {UserContextProvider} from './contexts/UserContext.jsx';
import { Toaster } from "@/components/ui/toaster";

import axios from "axios";
import App from "@/App.jsx";

axios.defaults.baseURL = import.meta.env.VITE_APIENDPOINT || "http://localhost:8080/api/user";

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
          <UserContextProvider>
              <Toaster />
              <App/>
          </UserContextProvider>
  </React.StrictMode>,
)

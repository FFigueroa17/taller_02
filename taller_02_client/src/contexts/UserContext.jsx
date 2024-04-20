import React, { useState } from "react";
import axios from "axios";
import {toast} from "@/components/ui/use-toast.js";
import {ToastAction} from "@/components/ui/toast.jsx";

const UserContext = React.createContext();

export const UserContextProvider = (props) => {

    const [user, setUser] = useState(null);

    //Función para register
    const login = async (identifier, password) => {
        try {

            //await axios.post("/auth/signin", { identifier, password });
            setUser({ identifier, password })
            toast(
                {
                    variant: "success",
                    title: "Welcome back",
                    description: "You have successfully logged in",
                    action: <ToastAction altText="Dismiss">Dismiss</ToastAction>
                }
            )
        } catch (error) {

            const {status} = error.response || {status: 500};
            const msgs = {
                "404": "User not found",
                "400": "Email o contraseña incorrectos",
                "500": "Unexpected error"
            };

            toast(
                {
                    variant: "destructive",
                    title: "Error",
                    description: msgs[String(status)],
                    action: <ToastAction altText="Dismiss">Dismiss</ToastAction>
                }
            )
        }
    }

    const logout = () => {
        setUser(null);
        //toast.success("Haz cerrado sesión");
    }

    const register = async (username, email, password) => {

        try {
            await axios.post("/auth/signup", { username, email, password });
            //toast.success("Signup successful");

        } catch (error) {
            const { status } = error.response || { status: 500 };
            const msgs = {
                "400": "Wrong Fields",
                "409": "User already exists",
                "500": "Unexpected error"
            }

            //toast.error(msgs[String(status)]);
        }
    }

    const state = {
        user,
        login,
        logout,
        register,
    }

    return <UserContext.Provider value={state} {...props} />
}

export const UseUserContext = () => {
    const context = React.useContext(UserContext);

    if (!context) {
        throw new Error("useUserContext must be call inside of a UserContextProvider component");
    }

    return context;
}
import {Navigate, Outlet} from 'react-router-dom';
import {LOGIN} from "@/routes/path.jsx";
import {UseUserContext} from "@/contexts/UserContext.jsx";

export default function PrivateRoute() {
    const {user} = UseUserContext();

    if (!user) {
        return <Navigate to={LOGIN} />;
    }

    return (
        <div>
            <Outlet />
        </div>
    );
}
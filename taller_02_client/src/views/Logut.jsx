
import {UseUserContext} from "@/contexts/UserContext.jsx";
import {Button} from "@/components/ui/button.jsx";
export default function Logout() {

    const {logout} = UseUserContext();

    return (
        <div>
            <h1>👋 Hasta pronto</h1>
            <Button
                onClick={logout}
            >
                Cerrar sesión
            </Button>
        </div>
    );
}
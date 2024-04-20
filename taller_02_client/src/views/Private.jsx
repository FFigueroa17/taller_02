import {Link} from 'react-router-dom';
import {LOGOUT} from "@/routes/path.jsx";
import {Button} from "@/components/ui/button.jsx";

function Private() {
    return (
        <div className={"flex flex-col gap-8 justify-center items-center"}>
            Mi ruta privada
            <Button>
                <Link to={LOGOUT}>Cerrar sesión</Link>
            </Button>
        </div>
    );
}

export default Private;
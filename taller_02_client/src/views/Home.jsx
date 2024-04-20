import {Link} from 'react-router-dom';

import {UseUserContext} from "@/contexts/UserContext.jsx";
import {LOGIN} from "@/routes/path.jsx";
import {Button} from "@/components/ui/button.jsx";

export default function Home() {

    const {user} = UseUserContext();

    return (
        <div className={"flex flex-col gap-8 justify-center items-center"}>
            <h1>💛 Let's get the party started</h1>
            <p>
                {user ? (
                    <Link to={"privateRoute"}>Sección privada</Link>
                ) : (
                    <Button>
                        <Link to={LOGIN}>Iniciar sesión</Link>
                    </Button>
                )}
            </p>
        </div>
    );
}
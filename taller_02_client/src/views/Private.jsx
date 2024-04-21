
import {Button} from "@/components/ui/button.jsx";
import {UseUserContext} from "@/contexts/UserContext.jsx";
import TableComponent from "@/views/Table.jsx";

function Private() {

    const {logout} = UseUserContext();

    return (
        <div className={"flex flex-col gap-8 justify-center items-center"}>
            Admin Dashboard
            <Button
                onClick={logout}
            >
                Cerrar sesión
            </Button>
            <TableComponent/>
        </div>
    );
}

export default Private;
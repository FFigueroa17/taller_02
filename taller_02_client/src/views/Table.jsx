import {
    Table,
    TableBody,
    TableCaption,
    TableCell,
    TableFooter,
    TableHead,
    TableHeader,
    TableRow,
} from "@/components/ui/table"

import { Badge } from "@/components/ui/badge"

const users = [
    {
        ID: "1",
        userName: "Carlos Gomez",
        rol: "admin",
        addedDate: "16/10/2024",
    },
    {
        ID: "2",
        userName: "Maria Rodriguez",
        rol: "user",
        addedDate: "17/10/2024",
    },
    {
        ID: "3",
        userName: "Juan Perez",
        rol: "admin",
        addedDate: "18/10/2024",
    },
    {
        ID: "4",
        userName: "Ana Morales",
        rol: "user",
        addedDate: "19/10/2024",
    },
    {
        ID: "5",
        userName: "Pedro Sanchez",
        rol: "admin",
        addedDate: "20/10/2024",
    },
]
function TableComponent() {
    return (
        <Table>
            <TableCaption>List of registered users</TableCaption>
            <TableHeader>
                <TableRow>
                    <TableHead className="w-[70px]">ID</TableHead>
                    <TableHead className="w-[200px]">User name</TableHead>
                    <TableHead className="w-[100px]">Rol</TableHead>
                    <TableHead>Added date</TableHead>
                </TableRow>
            </TableHeader>
            <TableBody>
                {users.map((user) => (
                    <TableRow key={user.ID}>
                        <TableCell className="font-medium">{user.ID}</TableCell>
                        <TableCell className="hidden sm:table-cell">{user.userName}</TableCell>
                        <TableCell className="hidden sm:table-cell">
                            <Badge className="text-xs" variant="secondary">
                                {user.rol}
                            </Badge>
                        </TableCell>
                        <TableCell>{user.addedDate}</TableCell>
                    </TableRow>
                ))}
            </TableBody>
            <TableFooter>
                <TableRow>
                    <TableCell colSpan={3}>Total</TableCell>
                    <TableCell className="text-right">{users.length}</TableCell>
                </TableRow>
            </TableFooter>
        </Table>
    )
}

export default TableComponent;
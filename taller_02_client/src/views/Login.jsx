import {Link} from 'react-router-dom';
import {Button} from "@/components/ui/button.jsx";
import {
    Card,
    CardContent,
    CardDescription,
    CardFooter,
    CardHeader,
    CardTitle,
} from "@/components/ui/card";
import {Input} from "@/components/ui/input.jsx";
import {Label} from "@/components/ui/label.jsx";
import {useState} from "react";
import {UseUserContext} from "@/contexts/UserContext.jsx";
import {toast} from "@/components/ui/use-toast.js";
import {ToastAction} from "@/components/ui/toast.jsx";

function useFormInput(initialValue) {
    const [value, setValue] = useState(initialValue);

    function handleChange(event) {
        setValue(event.target.value);
    }

    return {
        value,
        onChange: handleChange
    };
}

export default function Login() {

    const identifier = useFormInput("");
    const password = useFormInput("");

    const {login} = UseUserContext();

    const cleanInputs = () => {
        identifier.onChange({target: {value: ""}})
        password.onChange({target: {value: ""}})
    };

    const onSubmit = (event) => {
        event.preventDefault();
        login(identifier.value, password.value);
        cleanInputs();
    }


    return (
        <Card className="mx-auto max-w-sm">
            <CardHeader
                className={"gap-2"}
            >
                <CardTitle>Sign in</CardTitle>
                <CardDescription>Write your user name | email and your password</CardDescription>
            </CardHeader>
            <CardContent>
                <form
                    onSubmit={onSubmit}
                    className="flex flex-col gap-4"
                >
                    <div className="grid w-full text-left gap-6">
                        <div className="flex flex-col space-y-1.5">
                            <Label htmlFor="identifier">User name or email</Label>
                            <Input id="identifier"
                                   type="email"
                                   placeholder="m@example.com"
                                   required
                                   {...identifier}
                            />
                        </div>
                        <div className="flex flex-col space-y-1.5">
                            <Label htmlFor="password">Password</Label>
                            <Input
                                type={"password"}
                                id="password"
                                placeholder="Password"
                                required
                                {...password}
                            />
                        </div>
                    </div>
                    <Button type="submit" className="w-full">
                        Create an account
                    </Button>
                </form>
            </CardContent>
            <CardFooter
            >
                <div className="text-center text-sm">
                    {"Don't have an account?"} {" "}
                    <Link to={"/signup"} className="underline">
                        Sign up
                    </Link>
                </div>
            </CardFooter>
        </Card>
    );
}
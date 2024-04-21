import {Button} from "@/components/ui/button"
import {
    Card,
    CardContent,
    CardDescription,
    CardHeader,
    CardTitle,
} from "@/components/ui/card"
import {Input} from "@/components/ui/input"
import {Label} from "@/components/ui/label"
import {LOGIN} from "@/routes/path.jsx";
import {Link, redirect} from "react-router-dom";
import {useState} from "react";
import {UseUserContext} from "@/contexts/UserContext.jsx";

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

export function SignUp() {

    const userName = useFormInput("");
    const email = useFormInput("");
    const password = useFormInput("");

    const {register} = UseUserContext();

    const cleanInputs = () => {
        email.onChange({target: {value: ""}})
        password.onChange({target: {value: ""}})
        userName.onChange({target: {value: ""}})
    };

    const onSubmit = (event) => {
        event.preventDefault();

        register(
            userName.value.toString().toLowerCase(),
            email.value.toString().toLowerCase(),
            password.value
        );

        cleanInputs();

        return redirect(LOGIN);
    }

    return (
        <Card className="mx-auto max-w-sm">
            <CardHeader>
                <CardTitle className="text-xl">Sign Up</CardTitle>
                <CardDescription>
                    Enter your information to create an account
                </CardDescription>
            </CardHeader>
            <CardContent>
                <form
                    onSubmit={onSubmit}
                    className="grid gap-4">
                    <div className="grid gap-2">
                        <Label htmlFor="first-name">User name</Label>
                        <Input id="first-name"
                               placeholder="Max"
                               {...userName}
                               required
                        />
                    </div>
                    <div className="grid gap-2">
                        <Label htmlFor="email">Email</Label>
                        <Input
                            id="email"
                            type="email"
                            placeholder="m@example.com"
                            {...email}
                            required
                        />
                    </div>
                    <div className="grid gap-2">
                        <Label htmlFor="password">Password</Label>
                        <Input
                            id="password"
                            type="password"
                            {...password}
                        />
                    </div>
                    <Button type="submit" className="w-full">
                        Create an account
                    </Button>
                </form>
                <div className="mt-4 text-center text-sm">
                    Already have an account?{" "}
                    <Link to={LOGIN} className="underline">
                        Sign in
                    </Link>
                </div>
            </CardContent>
        </Card>
    )
}

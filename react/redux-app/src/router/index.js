import { createBrowserRouter } from "react-router-dom";
import Home from "../pages/Home";
import Login from "../pages/Login";
import Signup from "../pages/Signup";

const router = createBrowserRouter([
	{
		path: "/",
		Component: Home,
	},
	{
		path: "/login",
		Component: Login,
	},
	{
		path: "/signup",
		Component: Signup,
	},
]);
export default router;

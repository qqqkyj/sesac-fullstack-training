import PATHS from "../../constants/paths";
import DummyLayout from "../../layout/DummyLayout";
import Carts from "../../pages/DummyPages/Carts";
import DummyHome from "../../pages/DummyPages/DummyHome";
import Posts from "../../pages/DummyPages/Posts";
import ProductDetail from "../../pages/DummyPages/ProductDetail";
import Products from "../../pages/DummyPages/Products";
import NotFound from "../../pages/NotFound";

const dummyRoutes = [
	{
		// 모든 주소에 매핑되는 path
		path: "*", // * : 모든 것에 매핑(일치)되는 특수문자
		Component: NotFound,
	},
	{
		path: "/dummy",
		Component: DummyLayout,
		children: [
			{
				index: true,
				Component: DummyHome,
			},
			{
				path: "carts",
				Component: Carts,
			},
			{
				path: "posts",
				Component: Posts,
			},
			{
				path: "products",
				Component: Products,
			},
			{
				path: "products/:productId",
				Component: ProductDetail,
			},
		],
	},
];

export default dummyRoutes;

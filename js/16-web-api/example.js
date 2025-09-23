import axios from "axios";

// 도메인 주소
const BASE_URL = "https://dummyjson.com";

// async 화살표 함수
const testRoute = async () => {
	// fetch("https://dummyjson.com/test")
	// 	.then(res => res.json())
	// 	.then(console.log); //.then(data => console.log(data))와 같음

	const data = await axios.get(`${BASE_URL}/test`);
	console.log(data["data"]);
};
testRoute();

async function getAllProducts() {
	const response = await axios.get(`${BASE_URL}/products`);
	// console.log(response["data"]);
	const data = response["data"];
	const products = data["products"];
	console.log(products);
}
//getAllProducts();

// const searchProducts = async () => {
// 	const res = await axios.get(`${BASE_URL}/products/search?q=phone`);
// 	const data = res["data"];
// 	const products = data["products"];
// 	console.log(
// 		products.map((product) => {
// 			return {
// 				// [key(이름)] : 객체의 속성명을 변수로 활용
// 				[product["title"]]: product["price"],
// 			};
// 		})
// 	);
// };
// searchProducts();

// 특정 상품 조회
const searchProducts = async (search) => {
	const queryParams = new URLSearchParams({ q: search });
	const res = await axios.get(`${BASE_URL}/products/search?${queryParams}`);
	const data = res["data"];
	console.log(
		data["products"].map((product) => {
			return { [product["title"]]: product["price"] };
		})
	);
};
//searchProducts("phone");

// 상품의 특정 속성 추출
const getProductProperty = async (propertyName) => {
	const res = await axios.get(`${BASE_URL}/products`);
	const data = res["data"];
	const values = data["products"].map((product) => {
		return product[propertyName];
	});

	console.log(values);
};
//getProductProperty("title");

// 여러 속성 추출
const getProductProperties = async (propertyNames) => {
	const res = await axios.get(`${BASE_URL}/products`);
	const data = res["data"];
	const extractedData = data["products"].map((product) => {
		const result = {};

		propertyNames.forEach((propertyName) => {
			result[propertyName] = product[propertyName];
		});

		return result;
	});

	console.log(extractedData);
};
//getProductProperties(["title", "price"]);

// 특정 속성이 특정 값 미만인 상품 추출
const getFilteredProducts = async (propertyName, value) => {
	const res = await axios.get(`${BASE_URL}/products`);
	const data = res["data"];
	const filteredProducts = data["products"].filter((product) => {
		return product[propertyName] < value;
	});

	console.log(
		filteredProducts.map((product) => {
			return { [product["title"]]: product["stock"] };
		})
	);
};
getFilteredProducts("price", 10);

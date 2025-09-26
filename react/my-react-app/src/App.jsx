import React from "react";
// import Header from "./components/Header";
// import Footer from "./components/Footer";
// import Rule from "./components/JSX/Rule";
// import InterPlation from "./components/JSX/InterPlation";

import MyButton from "./components/Component/MyButton";
import MyList from "./components/Component/MyList";

// App 컴포넌트는 Header 컴포넌트와 InterPolation 컴포넌트를 포함한다
// App 컴포넌트는 Header 컴포넌트와 InterPolation 컴포넌트가 중첩됐다
export default function App() {
	return (
		<div>
			{/* 컴포넌트 사용 */}
			<MyList />
			<MyButton />
		</div>
	);

	// return (
	// 	<>
	// 		{/* <Rule></Rule> */}
	// 		{/* <Header/> 추가 */}
	// 		<Header></Header>

	// 		<InterPlation></InterPlation>

	// 		{/* <Footer/> 추가 */}
	// 		<Footer></Footer>
	// 	</>
	// );
}

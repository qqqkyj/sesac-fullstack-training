import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
import App from "./App.jsx";

// Provider 컴포넌트 불러오기
// Redux 스토어 설정을 주입(제공)하는 컴포넌트
import { Provider } from "react-redux";
// 스토어 설정
import { store } from "./store";

createRoot(document.getElementById("root")).render(
	<StrictMode>
		<Provider store={store}>
			<App />
		</Provider>
	</StrictMode>
);

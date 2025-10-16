import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import "./index.css";
// Provider 컴포넌트 불러오기
// Redux 스토어 설정을 주입(제공)하는 컴포넌트
import { Provider } from "react-redux";
// 스토어(store) 설정
import { store } from "./store";
import { RouterProvider } from "react-router-dom";
import router from "./router";
// persist 스토어 적용
import { PersistGate } from "redux-persist/integration/react";
import { persistor } from "./store";

createRoot(document.getElementById("root")).render(
	<StrictMode>
		<Provider store={store}>
			{/* Persist Gate 적용 */}
			<PersistGate persistor={persistor}>
				{/* Router는 반드시 Persist Gate 사이에 추가할 것 */}
				<RouterProvider router={router}></RouterProvider>
			</PersistGate>
		</Provider>
	</StrictMode>
);

import React from "react";

import PATHS from "../constants/paths";
import { Link } from "react-router-dom";

export default function NotFound() {
	return (
		<div>
      404 Error!! 페이지를 찾을 수 없습니다.<br>
      </br>
			<Link className="border-2" to={PATHS.ROOT.INDEX}>
				홈페이지로 이동
			</Link>
		</div>
	);
}

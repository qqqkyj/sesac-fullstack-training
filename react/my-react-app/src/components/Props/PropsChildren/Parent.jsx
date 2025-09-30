import Child from "./Child";

// Child 컴포넌트를 불러와서
// <div> 태그 사이에 Child 컴포넌트를 배치
export default function Parent() {
	return (
		<div>
			<Child>
				<div>
					<h1>나는 영희</h1>
					<h1>I'm 30</h1>
				</div>
			</Child>
			<Child>
				<div>
					<h1>나는 짱구</h1>
					<h1>I'm 5</h1>
				</div>
			</Child>
			<Child>
				<div>
					<h1>나는 희동</h1>
					<h1>I'm 45</h1>
				</div>
			</Child>
		</div>
	);
}

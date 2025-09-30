// components/PropsFunction/FormContainer.jsx
import Form from "./Form";

function handleSubmit(event) {
	event.preventDefault();
	const { name, email, password } = event["target"]["elements"];

	alert(
		`이름: ${name["value"]}, 이메일: ${email["value"]}, 비밀번호: ${password["value"]}`
	);
}

function handleChange(event) {
	console.log(event.target.value);
}

export default function FormContainer() {
	return (
		<>
			<h1 className="text-2xl font-bold">FormContainer</h1>
			{/* Form 컴포넌트 배치 */}
			<Form onSubmit={handleSubmit} onChange={handleChange} />
		</>
	);
}

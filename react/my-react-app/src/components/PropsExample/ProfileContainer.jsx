import Profile from "./Profile";

export default function ProfileContainer() {
	const name = "주영";
	const age = 30;
	const isAdmin = true;

	return (
		<div>
			<Profile name="현우" age={22} isAdmin={true} />
			<Profile name="수진" age={21} isAdmin={false} />
			{/* <Profile user={{ name: "동원", age: 30, isAdmin: true }} />
			<Profile user={{ name: "경식", age: 26, isAdmin: false }} /> */}
			<Profile name={name} age={age} isAdmin={isAdmin} />
		</div>
	);
}

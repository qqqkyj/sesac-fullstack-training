export default function MemoCard({ memo, onConfirm, onCancel }) {
	return (
		<div className="bg-white shadow-lg rounded-lg p-6 my-4 border border-blue-200">
			<h3 className="text-xl font-bold mb-4">AI가 생성한 메모</h3>
			<div className="space-y-3">
				<p>
					<strong className="font-semibold">내용:</strong> {memo.content}
				</p>
				<p>
					<strong className="font-semibold">마감일:</strong> {memo.dueDate}
				</p>
				{memo.priority && (
					<p>
						<strong className="font-semibold">우선순위:</strong> {memo.priority}
					</p>
				)}
				{memo.category && (
					<p>
						<strong className="font-semibold">카테고리:</strong> {memo.category}
					</p>
				)}
			</div>
			<div className="flex justify-end space-x-4 mt-6">
				<button
					onClick={onCancel}
					className="px-4 py-2 rounded-md text-gray-600 bg-gray-100 hover:bg-gray-200"
				>
					취소
				</button>
				<button
					onClick={onConfirm}
					className="px-4 py-2 rounded-md text-white bg-blue-500 hover:bg-blue-600"
				>
					메모 생성
				</button>
			</div>
		</div>
	);
}

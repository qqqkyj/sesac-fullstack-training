# git branch

### 브랜치 명령어

### `git branch`

- git 프로젝트의 브랜치 목록 출력

### `git branch <브랜치명>`

- 새로운 브랜치 생성
- 작업 공간을 생성

### `git switch <브랜치명>`

- 브랜치 전환
- 작업 공간을 변경
- checkout 명령어를 사용한 전환 방법이 있으나 권장하지 않는다

## 서브(가능) 브랜치 워크플로우

1. 브랜치 생성 `git branch <브랜치명>`
2. 브랜치 전환 `git switch <브랜치명>`
3. 작업
4. `git add`
5. `git commit -m "커밋 메시지"`
6. 브랜치 전환 `git switch main`
7. 브랜치 병합 `git merge <브랜치명>`
8. 브랜치 삭제 `git branch -d <브랜치명>`

- 추후 문제 발생 가능성 : 동일한 브랜치명을 못 사용한다는 문제

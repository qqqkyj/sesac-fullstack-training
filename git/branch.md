# 💡 Git 브랜치 (Branch)

## 📌 브랜치란?

- Git 프로젝트에서 **독립적으로 작업을 진행하기 위한 작업 공간**
- 각 브랜치는 서로 영향을 받지 않아 **여러 작업을 동시에 진행 가능**
- **메인(main/master) 브랜치** : 모든 브랜치의 최상위가 되는 중심 브랜치

---

## 📚 브랜치 명령어

### 🔍 브랜치 조회

- `git branch` : 로컬 브랜치 목록 출력
- `git branch -a` : 원격 브랜치까지 모두 표시
- `git branch -v` : 각 브랜치의 마지막 커밋 메시지 함께 표시

---

### ✨ 브랜치 생성 & 삭제

- `git branch <브랜치 명>` : 새 브랜치 생성
- `git branch -d <브랜치 명>` : 브랜치 삭제
    - `d` : 안전 삭제 (병합된 브랜치만 삭제)
    - `D` : 강제 삭제 (병합되지 않은 브랜치도 삭제)
- 💡 **일반적인 흐름** : 작업 후 `main` 브랜치에 merge → 서브 브랜치 삭제 → 깔끔한 관리

---

### 🔄 브랜치 전환

- `git switch <브랜치 명>` : 다른 브랜치로 전환
    - ⚠️ 전환 전에 반드시 변경사항을 **commit/stash** 해야 함

---

### 🔗 브랜치 병합

- `git merge <브랜치 명>` : 다른 브랜치의 변경사항을 **현재 브랜치에 병합**

---

## 🛠 실습 예시

```bash
# 1. 브랜치 확인
git branch -a

# 2. 새 브랜치 생성
git branch git-branch

# 3. 브랜치 이동
git switch git-branch

# 4. 파일 수정 및 커밋
# (예: git/branch.md 작성)
git add .
git commit -m "브랜치 명령어"

# 5. main으로 이동 후 병합
git switch main
git merge git-branch

# 6. 작업이 끝난 브랜치 삭제
git branch -d git-branch
```
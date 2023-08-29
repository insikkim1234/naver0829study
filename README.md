# naver0829study
네이버 클라우드 과정3기 수업


git-bash

처음에 한번만 이메일과 유저명 확인
1.git config --global user.name "kiminsik"
2.git config --global user.email "insikkim1234@gmail.com"

3.git init     git과 연동할 폴더 초기화(마스터)생김
4.git remote add origin https://github.com/insikkim1234/naver0829study.git      
  git 원격저장소에 새로 연결
  만약 오류나서 저장소와 연결이 안될 경우
  git remote set-url origin  https://github.com/insikkim1234/naver0829study.git

5.git branch -M main
 (메인)으로 바뀜
6. git pull origin main
<결과>
  remote: Enumerating objects: 9, done.
  remote: Counting objects: 100% (9/9), done.
  remote: Compressing objects: 100% (6/6), done.
  remote: Total 9 (delta 2), reused 0 (delta 0), pack-reused 0
  Unpacking objects: 100% (9/9), 2.21 KiB | 9.00 KiB/s, done.
  From https://github.com/insikkim1234/naver0829study
   * branch            main       -> FETCH_HEAD
   * [new branch]      main       -> origin/main

cat README.md
 하면 깃허브 내용 블러오기


 
 
3.git branch    branch조회
4.git add . 또는 git add 파일명 : 해당 파일들을 로컬 저장소에 추가
5.git commit -m메시지 해당 메세지와 함께 파일들을 로컬저장소에 커밋
6.git push origin 브랜치명 - 원격저장소의 해당 브랜치에 소스 보내기
  반대로 원격 저장소의 수정된 내용을 가져올경우
    git pull origin 브랜치명

처음에 한번만 이메일과 유저명 확인
git config --global user.name "[사용자명]"
git config --global user.email "[사용자이메일]"

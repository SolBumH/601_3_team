/**
 *  문의하기 게시판 관련 스크립트 파일
 */
const editor = new toastui.Editor({
  el: document.querySelector('#editor'),
  previewStyle: 'tab',
  height: '500px',
  initialEditType: 'markdown',
  placeholder: "원하는 내용을 작성해주세요.",
  usageStatistics: false,
  language: 'ko-KR',
  // theme: 'dark', // 테마 변경하기
});

function boardWrite(id) {
	// alert("알림");
	if (id == 'anonymousUser') {
		alert("로그인을 해주세요.");
		location.href="/login";
	} else {
		location.href="/write";
	}
}

function writeComplete() {
	let i = $('#editor');
	console.log();
}
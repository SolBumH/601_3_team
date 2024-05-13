/**
 *  문의하기 게시판 관련 스크립트 파일
 */

// csrf 토큰
const header = $("meta[name='_csrf_header']").attr('content');
const token = $("meta[name='_csrf']").attr('content');

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

function writeComplete(user) {
	const board_title = $("#writeForm")[0][0].value;
	const board_content = editor.getHTML();
	console.log(board_title + board_content);
	
	if (user.role == 'ROLE_ANONYMOUS') {
		alert('로그인을 해주세요.');
		location.href="/login";
	}
	
	$.ajax({
		url: '/writeComplete',
		type: 'post',
		dataType: 'text',
		data: { 
			'board_title': board_title,
			"board_content": board_content,
		},
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		success: function(result) {
			alert("작성이 완료되었습니다.");
			location.href="/board";
		},
		error: function(error) {
		}
	});
}
// const id = ${ user.username };

function loginCheck(id) {
	if (id == 'anonymousUser') {
		alert('로그인이 필요합니다.');
		location.href = '/login';
	} else {
		location.href = '/srconsulting';
	}
}

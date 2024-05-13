const header = $("meta[name='_csrf_header']").attr('content');
const token = $("meta[name='_csrf']").attr('content');

document.addEventListener('DOMContentLoaded', function() {
	let calendarEl = document.getElementById('calendar')
	let calendar = new FullCalendar.Calendar(calendarEl, {

		initialView: 'dayGridMonth', // 초기화면에 보이는 캘린더 화면
		contentHeight: 180, //캘린더 크기 설정
		locale: 'ko', // 한국어로 변경
		// aspectRatio: 1.35, // 가로세로 비율
		selectable: true, // 달력 드래그 설정
		// dayMaxEventRows: false, // for all non-TimeGrid views
		nowIndicator: true, // 현재 시간 마크
		editable: false, // 기존 예약을 옮길수 있음
		fixedWeekCount: false, // 해당 달의 마지막 주 까지만 보여줌, 다음 달의 미리보기 X
		validRange: {
				start: Date.now(),
				end: Date.now() + 2592000000,
		},
		select: function(arg) {
			click(arg.startStr);
			let moda = arg.startStr;
			$.ajax({
				type: 'post',
				url: '/scmenu',
				dataType: 'json',
				beforeSend: function(xhr) {
					xhr.setRequestHeader(header, token);
				},
				data: { 'moda': moda },
				success: function(data) {
				},
				error: function(error) {
				}
			})
			// calendar.unselect();
		} //달력 빈칸클릭시 event 추가 가능
	});
	calendar.render();
});

function click(arg) {
	$.ajax({
		type: 'post',
		url: '/SrController',
		dataType: 'json',
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		data: { 'start': arg, },
		success: function(data) {
		},
		error: function(error) {
		}
	});
}
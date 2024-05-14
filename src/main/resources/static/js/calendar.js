const header = $("meta[name='_csrf_header']").attr('content');
const token = $("meta[name='_csrf']").attr('content');

let date;

document.addEventListener('DOMContentLoaded', function() {
	let calendarEl = document.getElementById('calendar')
	let calendar = new FullCalendar.Calendar(calendarEl, {

		initialView: 'dayGridMonth', // 초기화면에 보이는 캘린더 화면
		contentHeight: 180, //캘린더 크기 설정
		locale: 'ko', // 한국어로 변경
		// aspectRatio: 1.35, // 가로세로 비율
		selectable: false, // 달력 드래그 설정
		// dayMaxEventRows: false, // for all non-TimeGrid views
		editable: false, // 기존 예약을 옮길수 있음
		fixedWeekCount: false, // 해당 달의 마지막 주 까지만 보여줌, 다음 달의 미리보기 X
		validRange: {
				start: Date.now(),
				end: Date.now() + 2592000000,
		},
		dateClick: function(info) {
			date = info.dateStr;
			// info.dayEl.style.backgroundColor = '#E8ADAD';
			let days = document.querySelectorAll(".selectedDate");
			days.forEach(function(day) {
			  day.classList.remove("selectedDate");
			});
			info.dayEl.classList.add("selectedDate");
  		},
	});
	// calendar.unselect();
	calendar.render();
});

function click(arg) {
	$.ajax({
		type: 'post',
		url: '/SrController',
		dataType: 'json',
		data: { 'start': arg, },
		beforeSend: function(xhr) {
			xhr.setRequestHeader(header, token);
		},
		success: function(data) {
		},
		error: function(error) {
		}
	});
}

function sangdamSign() {
	let selectTime = document.querySelector('input[name="time"]:checked');
	if (date == null || selectTime == null) {
		alert("날짜와 시간을 모두 선택해주세요.");
		return false;
	}
	
	if(confirm("신청하시겠습니까?\n신청 날짜 : " + date + "\n선택 시간 : " + selectTime.value + "시")) {
		location.href="/jcCounselingForm?date=" + date + "&time=" + selectTime.value;
	}	
}
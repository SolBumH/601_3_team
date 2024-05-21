const header = $("meta[name='_csrf_header']").attr('content');
const token = $("meta[name='_csrf']").attr('content');

let date;
let datasave = [];
let parentElement = document.getElementById("jkschedule");

document.addEventListener('DOMContentLoaded', function() {
	let calendarEl = document.getElementById('jkcalendar')
	let calendar = new FullCalendar.Calendar(calendarEl, {

		initialView: 'dayGridMonth', // 초기화면에 보이는 캘린더 화면
		contentHeight: 180, //캘린더 크기 설정
		// contentWidth: 400,
		locale: 'ko', // 한국어로 변경
		// aspectRatio: 1.35, // 가로세로 비율
		selectable: false, // 달력 드래그 설정
		// dayMaxEventRows: false, // for all non-TimeGrid views
		editable: false, // 기존 예약을 옮길수 있음
		fixedWeekCount: false, // 해당 달의 마지막 주 까지만 보여줌, 다음 달의 미리보기 X
		weekends: false, // 주말은 안보이게 설정
		validRange: {
				start: Date.now() + 86400000, // 하루 뒤 부터 예약할 수 있게
				end: Date.now() + 2592000000, // 한달 뒤 까지 예약할 수 있게
		},
		dateClick: function(info) {
			date = info.dateStr;
				$.ajax({
					type: 'post',
					url: '/jkconsult',
					dataType: 'json',
					data: { 'date': date },
					beforeSend: function(xhr) {
					xhr.setRequestHeader(header, token);
					},
					success: function(data) {
						for(var i=0; i<data.length; i++){
							datasave.push(data[i].cd_TM);

							$('#jkschedule').append('<input type="radio" class="btn-check" value="' + data[i].cd_TM +'" name="time" id="'+data[i].cd_TM+'"/>');
							$('#jkschedule').append('<label class="btn btn-outline-danger" for="'+ data[i].cd_TM +'" value="'+ data[i].cd_TM +'">'+data[i].cd_TM+"시"+'</label>');
						}
					},
					error: function(error) {
					}
				});
				$('div #jkschedule').empty();
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
	

function jksangdamSign() {
	let selectTime = document.querySelector('input[name="time"]:checked');
	if (date == null || selectTime == null) {
		alert("날짜와 시간을 모두 선택해주세요.");
		return false;
	}
	
	if(confirm("신청하시겠습니까?\n신청 날짜 : " + date + "\n선택 시간 : " + selectTime.value + "시")) {
		location.href="/jcCounselingForm?date=" + date + "&time=" + selectTime.value;
	}	
}
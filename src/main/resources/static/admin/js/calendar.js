const header = $("meta[name='_csrf_header']").attr('content');
const token = $("meta[name='_csrf']").attr('content');

$(function(){
	$("#jkselectdate").on("change",function(){
		      
        var dateInput = document.getElementById('jkselectdate'); // 날짜 입력(input) 요소 가져오기
        var selectedDate = dateInput.value; // 선택된 날짜 가져오기
		
		let valueToRemove = [];
		
		$.ajax({
			type: 'get',
			url: '/admin/jkselect',
			dataType: 'json',
			data: { 'jkselectdate' : selectedDate },
			success: function(data) {
				
				for (var i=0; i < data.length; i++){
					valueToRemove.push(data[i].cd_TM);
					$("select[name=jkoption] option[value='" + data[i].cd_TM + "']").remove();
				}
				
			},
			error: function(error) {
				console.error("err:",error);
			}
		});
	});
});

function datechange(){
		$("select[name='jkoption'] option").remove();
		$('#jkoption').append('<option value="">상담 가능 시간을 선택하세요</option>');
		$('#jkoption').append('<option value="SC0110">10:00 ~ 10:50</option>');
		$('#jkoption').append('<option value="SC0111">11:00 ~ 11:50</option>');
		$('#jkoption').append('<option value="SC0113">13:00 ~ 13:50</option>');
		$('#jkoption').append('<option value="SC0114">14:00 ~ 14:50</option>');
		$('#jkoption').append('<option value="SC0115">15:00 ~ 15:50</option>');
		$('#jkoption').append('<option value="SC0116">16:00 ~ 16:50</option>');
}
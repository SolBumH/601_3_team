const header = $("meta[name='_csrf_header']").attr('content');
const token = $("meta[name='_csrf']").attr('content');

	function jkselectdt(){
		      
        var dateInput = document.getElementById('jkselectdate'); // 날짜 입력(input) 요소 가져오기
        var selectedDate = dateInput.value; // 선택된 날짜 가져오기

		$.ajax({
			type: 'get',
			url: '/admin/jkselect',
			dataType: 'json',
			data: { 'jkselectdate' : selectedDate },
			success: function(data) {
				for(var i=0; i< data.length;i++){
				console.log(data[i].cd_TM);
				
				}
			},
			error: function(error) {
				console.error("err:",error);
			}
		});

        
		console.log('Selected date:', selectedDate); // 선택된 날짜 콘솔에 출력
        
	
	}
	




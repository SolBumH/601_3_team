/**
 *
 */
// csrf 토큰
const header = $("meta[name='_csrf_header']").attr("content");
const token = $("meta[name='_csrf']").attr("content");
let sangdamNo;

const grid = new tui.Grid({
  el: document.getElementById("grid"),
  rowHeaders: ["rowNum"],
  pageOptions: {
    useClient: true,
    perPage: 5,
  },
  scrollX: false,
  scrollY: false,
  contextMenu: ({ rowKey, columnName }) => [[
	{
		label: '승인',
		action: () => {
			let row = grid.getRow(rowKey);
			let no = 0;
			if (sangdamNo == 10) {
				no = row.jks_NO;
			} else if (sangdamNo == 20){
				no = row.jms_NO;
			} else if (sangdamNo == 30) {
				no = row.sr_NO;
			} else if (sangdamNo == 40) {
				no = row.jc_NO;
			}
			
			$.ajax({
				type : 'post',
				url : '/admin/approval',
				data : { sangdamNo : sangdamNo, no : no, rsvt_YN : "2",
						 RS_DATE: row.rs_DATE, RS_TIME: row.rs_TIME,},
				dataType : 'text',
				beforeSend: function (xhr) {
			    	xhr.setRequestHeader(header, token);
			    },
				success : function(result){
					if (result == 1) {
						console.log("승인 완료 : " + no + "번");
					}
				}
			});
		}
	},
	{
		label: '취소하기',
		action: () => {
			let row = grid.getRow(rowKey);
			let no = 0;
			
			if (sangdamNo == 10) {
				no = row.jks_NO;
			} else if (sangdamNo == 20){
				no = row.jms_NO;
			} else if (sangdamNo == 30) {
				no = row.sr_NO;
			} else if (sangdamNo == 40) {
				no = row.jc_NO;
			}
			
			$.ajax({
				type : 'post',
				url : '/admin/cancel',
				data : { sangdamNo : sangdamNo, no : no, rsvt_YN : "3", },
				dataType : 'text',
				beforeSend: function (xhr) {
			    	xhr.setRequestHeader(header, token);
			    },
				success : function(result){
					if (result == 1) {
						console.log("취소 완료 : " + no + "번");
					}
				}
			});
		}
	}
	]
  ],
  columns: [
    {
      header: "신청 학생",
      name: "name",
      align: "center",
    },
    {
      header: "예약 신청일",
      name: "rs_DATE",
	  filter: 'select',
      align: "center",
    },
    {
      header: "신청 시간 (시)",
      name: "rs_TIME",
	  filter: 'select',
      align: "center",
    },
    {
      header: "예약 확정일",
      name: "rs_CF",
      align: "center",
    },
    {
      header: "예약 확정 시간",
      name: "rs_CF_TIME",
      align: "center",
    },
    {
      header: "상담 진행일",
      name: "cs_DATE",
      align: "center",
    },
    {
      header: "상담 진행 시간",
      name: "cs_TIME",
      align: "center",
    },
    {
      header: "승인 여부",
      name: "rsvt_YN",
      align: "center",
      filter: "select", // 필터
      formatter: "listItemText",
      editor: {
        type: "select",
        options: {
          listItems: [
            { text: "미승인", value: "1" },
            { text: "승인", value: "2" },
            { text: "취소", value: "3" },
            { text: "상담완료", value: "4" },
          ],
        },
      },
    },
  ],
});


grid.on("click", (ev) => {
    let row = grid.getRow(ev.rowKey);
    if (row !== null) {
	    // console.log(row);
		let date;
		let time;
		// 예약 확정 시간이 있으면 확정된 시간을 넣고, 아니면 신청일을 집어넣음
		if (row.rs_CF == null) {
			date = row.rs_DATE;
			time = row.rs_TIME;
		} else {
			date = row.rs_CF;
			time = row.rs_CF_TIME;
		}
		
		let no = 0;
		if (sangdamNo == 10) {
			no = row.jks_NO;
		} else if (sangdamNo == 20){
			no = row.jms_NO;
		} else if (sangdamNo == 30) {
			no = row.sr_NO;
		} else if (sangdamNo == 40) {
			no = row.jc_NO;
		}
		  $('#responseNo').val(no);
		  $('#responseName').val(row.name);
		  $('#content').text(row.content);
		  $("#before_sangdamNo").val(row.bf_NO);
		  $("#rs_cf").val(date);
		  $("#rs_cf_time").val(time).prop("selected", true);
		  $('#adminAnswer').text(row.cs_TEXT);
    }
});


$(document).ready(function () {
  // $.ajax({
  //   url: "/admin/jmsangdamList",
  //   type: "get",
  //   dataType: "JSON",
  //   contentType: "application/json; charset=UTF-8",
  //   success: function (result) {
  //     // console.log(result);
  //     grid.resetData(result);
  //   },
  // });

	$("#selectSangdamBtn").on("click", function () {
	    sangdamNo = $("#sangdamList option:selected").val();
	
	    $.ajax({
	      url: "/admin/sangdamList",
	      type: "post",
	      data: { sangdamNo: sangdamNo },
	      dataType: "json",
	      //contentType: "application/json; charset=UTF-8",
	      beforeSend: function (xhr) {
	        xhr.setRequestHeader(header, token);
	      },
	      success: function (result) {
	        grid.resetData(result);
	      },
	      error: function () {
	        alert("통신 에러 발생");
	      },
	    });
  	});

  $("#changeScheduleBtn").on("click", function () {
    // sangdamNo = $("#sangdamList option:selected").val();
	let no = $("#responseNo").val();
	let date = $("#rs_cf").val();
	let time = $("#rs_cf_time option:selected").val();
	
    $.ajax({
      url: "/admin/updateDateAndTime",
      type: "post",
      data: { sangdamNo: sangdamNo, no:no, rs_cf:date, rs_cf_time:time },
      dataType: "json",
      //contentType: "application/json; charset=UTF-8",
      beforeSend: function (xhr) {
        xhr.setRequestHeader(header, token);
      },
      success: function (result) {
        if (result == 1) {
			alert("저장 완료");
		}
      },
      error: function () {
        alert("통신 에러 발생");
      },
    });
  });

	$('#saveSangdamBtn').on('click', function() {
		let no = $("#responseNo").val();
		let date = $("#rs_cf").val();
		let time = $("#rs_cf_time option:selected").val();
		let content = $("#adminAnswer").val();
		
		$.ajax({
			url: "/admin/finishedSangdam",
			type: "post",
			dataType: "text",
			beforeSend: function (xhr) {
		        xhr.setRequestHeader(header, token);
		    },
			data: {sangdamNo : sangdamNo, no : no, 
				rs_cf : date, rs_cf_time : time, content : content},
			success: function(result) {
				if (result == 1) {
					alert("저장 완료");
				}
			},
		});
	});
});
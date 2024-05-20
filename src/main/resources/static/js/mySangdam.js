// csrf 토큰
const header = $("meta[name='_csrf_header']").attr("content");
const token = $("meta[name='_csrf']").attr("content");

let sangdamOption = 0;

const grid = new tui.Grid({
  el: document.getElementById("grid"),
  // rowHeaders : [ 'rowNum' ],
  pageOptions: {
    useClient: true,
    perPage: 10,
  },
  scrollX: false,
  scrollY: false,
  contextMenu: ({ rowKey, columnName }) => [[
	{
		label: '취소하기',
		action: () => {
			let sangdam = grid.getRow(rowKey);
			console.log(sangdam);
			$.ajax({
				url: '/mypage/boardDelete',
				type: 'post',
				dataType: 'text',
				data: {board_no : board.board_no},
				beforeSend: function (xhr) {
			        xhr.setRequestHeader(header, token);
			    },
				success: function (result) {
					if (result == 1) {
						location.href="/mypage/board"
					}
				}
			});
		}
	}
	]
  ],
  columns: [
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
            { text: "상담 완료", value: "4" },
          ],
        },
      },
    },
  ],
});


$(document).ready(function () {
  $.ajax({
    url: "/mypage/sangdamList",
    type: "get",
    dataType: "JSON",
    contentType: "application/json; charset=UTF-8",
    success: function (result) {
      grid.resetData(result);
    },
  });
});

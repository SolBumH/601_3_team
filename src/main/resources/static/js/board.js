// csrf 토큰
const header = $("meta[name='_csrf_header']").attr("content");
const token = $("meta[name='_csrf']").attr("content");


const grid = new tui.Grid({
  el: document.getElementById("grid"),
  // rowHeaders : [ 'rowNum' ],
  pageOptions: {
    useClient: true,
    perPage: 15,
  },
  scrollX: false,
  scrollY: false,
  contextMenu: ({ rowKey, columnName }) => [[
	{
		label: '이동하기',
		action: () => {
			let board = grid.getRow(rowKey);
			location.href = "/detail?no=" + board.board_no;
		}
	},
	{
		label: '삭제하기',
		action: () => {
			let board = grid.getRow(rowKey);
			console.log(board);
			// location.href = "/detail?no=" + board.board_no;
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
      header: "번호",
      name: "board_no",
      align: "center",
      width: 50,
    },
    {
      header: "제목",
      name: "board_title",
      width: 350,
    },
    {
      header: "내용",
      name: "board_content",
      // width: 400,
    },
    {
      header: "작성일",
      name: "board_date",
      align: "center",
      width: 300,
	},	  
    {
      header: "답변",
      name: "ans_yn",
      filter: "select",
      // filter: {type : 'select',
      // showApplyBtn: true,
      // showClearBtn: true},
      align: "center",
      width: 130,
      formatter: "listItemText",
      editor: {
        options: {
          listItems: [
            { text: "미답변", value: "1" },
            { text: "답변완료", value: "2" },
            { text: "답변불필요", value: "3" },
          ],
        },
      },
    },
  ],
});


$(document).ready(function () {
  $.ajax({
    url: "/mypage/boardList",
    type: "get",
    dataType: "JSON",
    contentType: "application/json; charset=UTF-8",
    success: function (result) {
      grid.resetData(result);
    },
  });
});

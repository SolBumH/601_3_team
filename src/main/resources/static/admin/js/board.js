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
      header: "작성자",
      name: "name",
      align: "center",
      width: 100,
    },
    {
      header: "삭제 여부",
      name: "del_yn",
      filter: "select", // 필터
      align: "center",
      width: 100,
      formatter: "listItemText",
      editor: {
        type: "select",
        options: {
          listItems: [
            { text: "미삭제", value: "1" },
            { text: "삭제", value: "2" },
          ],
          useViewMode: true,
        },
      },
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
            { text: "답변게시글", value: "4" },
          ],
          // useViewMode: true
        },
      },
    },
  ],
});

grid.on("afterChange", (ev) => {
  let board_no = grid.getElement(ev.changes[0].rowKey, "board_no").firstChild.innerText;
  let del_yn = ev.changes[0].value;

  $.ajax({
    url: "/admin/updateBoardDel",
    type: "post",
    dataType: "text",
    data: { board_no: board_no, del_yn: del_yn },
    beforeSend: function (xhr) {
      xhr.setRequestHeader(header, token);
    },
    success: function (result) {
      console.log(board_no + "번 글 변경 완료");
    },
    error: function (xhr, status, error) {
      alert("통신 에러 발생");
    },
  });
});

$(document).ready(function () {
  $.ajax({
    url: "/admin/boardList",
    type: "get",
    dataType: "JSON",
    contentType: "application/json; charset=UTF-8",
    success: function (result) {
      grid.resetData(result);
    },
  });
});

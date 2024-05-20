/**
 *
 */
// csrf 토큰
const header = $("meta[name='_csrf_header']").attr("content");
const token = $("meta[name='_csrf']").attr("content");

const grid = new tui.Grid({
  el: document.getElementById("grid"),
  rowHeaders: ["rowNum"],
  pageOptions: {
    useClient: true,
    perPage: 5,
  },
  scrollX: false,
  scrollY: false,
  columns: [
    {
      header: "신청 학생",
      name: "name",
      align: "center",
    },
    {
      header: "예약 신청일",
      name: "rs_DATE",
      align: "center",
    },
    {
      header: "신청 시간 (시)",
      name: "rs_TIME",
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
          ],
        },
      },
    },
  ],
});

grid.on("afterChange", (ev) => {
  let no = grid.getRow(ev.changes[0].rowKey);
  console.log(no);
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
    let sangdamNo = $("#sangdamList option:selected").val();

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
});

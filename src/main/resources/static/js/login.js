function test() {
  let id = document.getElementById("id");
  alert(id.value);
}

const editor = new toastui.Editor({
  el: document.querySelector("#content"),
  height: "600px",
  initialEditType: "markdown",
  previewStyle: "vertical",
  initailValue: "",
  usageStatistics: false,
});

function allorder(){
	document.getElementById("order_input_1").value = "0";   /*0 表示该店铺的所有订单 包括未发货 以及发货了的*/
	document.getElementById("order_form").submit();
}
function beforeorder(){
	document.getElementById("order_input_1").value = "2";   /*2 表示 未发货*/
	document.getElementById("order_form").submit();
}
function finishorder(){
	document.getElementById("order_input_1").value = "3"; /*3 表示 已发货*/
	document.getElementById("order_form").submit();
}
function changeTitle(storename) {
	document.title = storename; /* 页面加载就改变 页面的title */
}
function isselected(){
	var myselect = document.getElementById("category2");
	var index = myselect.selectedIndex;
	var values = myselect.options[index].value;
	if(values=="0"){
		alert("请选择商品类型");
		return false;
	}
	return true;
}
function isInput(value){
	if(value==''){
		alert("12");
		var span = document.getElementById("error_name");
		span.value = "请输入食品名称";
	}
}
function checkoutfilename(){
	/*var goodfilename = document.getElementById("images");*/
/*	var goodfilename = document.getElementsByName("images");*/
	/*elementList.*/
	/*goodfilename.gete*/
	/*var filename = goodfilename.value;
	if(!filename || !(filename.endsWith('.jpg') || filename.endsWith('.png') || filename.endsWith('.gif') || filename.endsWith('.jpeg'))){
		alert("只能上传 jpg jpeg gif 以及 png 的图片文件");
		return false;
	}
	return true;*/
	var goodfilename = document.getElementsByName("images");
	var filename;
	for(var i=0;i<goodfilename.length;i++){
		filename = goodfilename[i].value;
		if(!filename || !(filename.endsWith('.jpg') || filename.endsWith('.png') || filename.endsWith('.gif'))){
			alert("请上传图片(只能上传 jpg,gif,以及 png的图片文件)");
			return false;
		}
	}
	var submit = document.getElementById("submit");
	submit.disable = "disable";
	return true;
}

function fileadd(){
	var filediv = document.getElementById("addfile"); //拿到那个div
	var div2 = document.createElement("div");
	//生成input button等元素
	var input = document.createElement("input");
	input.type = "file";
	input.name = "images";
	input.id = "images";
	var btn = document.createElement("input");
	btn.type = "button";
	btn.value = "删除";
	
	div2.appendChild(input);
	div2.appendChild(btn);
	
	filediv.appendChild(div2);
	btn.onclick = function del(){
		this.parentNode.parentNode.removeChild(this.parentNode);
	}
}
function isdelete(path,goodtype,good_id){
	if(goodtype=='cloth_id'){
		var b = window.confirm("你确定下架该类衣服吗？");
		if(b==true){
			window.location.href = path+"?"+goodtype+"="+good_id;
		}
	}
	
	if(goodtype=='book_id'){
		var b = window.confirm("你确定下架该类书籍吗？");
		if(b==true){
			window.location.href = path+"?"+goodtype+"="+good_id;
		}
	}
	if(goodtype=='food_id'){
		var b = window.confirm("你确定下架该类食品吗？");
		if(b==true){
			window.location.href = path+"?"+goodtype+"="+good_id;
		}
	}
}
function checkoutinput_key(){
	var inputkey = document.getElementById("input_search_key");
	var value = inputkey.value;
	if(value==""){
		alert("请输入搜索关键字");
		return false;
	}
	return true;
}


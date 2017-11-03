/**
 * 
 */
// 数量输入框限制输入只能为整数
function checkit() {
	if (!(event.keyCode == 46) && !(event.keyCode == 8)
			&& !(event.keyCode == 37) && !(event.keyCode == 39))
		if (!((event.keyCode >= 48 && event.keyCode <= 57) || (event.keyCode >= 96 && event.keyCode <= 105)))
			event.returnValue = false;
}
// 数量增加按钮
function add_num(str) {
	var num = document.getElementById("cart_single_num_text" + str);
	num.value = num.value * 1 + 1;// 类型默认字符串，必须*1转换为数值？
	cart_ajax(num,str);
}
// 数量减少按钮
function dec_num(str) {
	var t = document.getElementById("cart_single_num_text" + str);
	if (t.value * 1 > 1) {
		t.value -= 1;
		cart_ajax(num,str);
	}
}
// 数量输入框拾取焦点时检查，空时设为1
function checknum() {
	var tt = document.getElementById("cart_single_num_text");
	if (tt.value == null || tt.value == "") {
		tt.value += 1;
	}
}
// 删除购物项弹窗
function deleteit(str,str2) {
	if (confirm("确定删除该订单吗？")) {
		document.getElementById("cart_delete" + str).click();
		window.replace(str2);
	}
}
// 检查购物车项的选择情况
function checkselected() {
	var c = document.getElementsByName("cart_single_checkbox_c");
	var b = document.getElementById("cart_pay_b");
	var count = 0;
	for (var i = 0; i < c.length; i++) {
		if (c.item(i).checked) {
			count++;
		}
	}
	if (count == 0) {
		b.disabled = true;
		b.value = "结算()";
		b.style.backgroundColor = "white";
		b.style.color = "black";
	} else {
		b.value = "结算(" + count + ")";
		b.style.backgroundColor = "red";
		b.style.color = "white";
		b.disabled = false;
	}
}
//全选
function allselect(){
	var c=document.getElementsByName("cart_single_checkbox_c");
	for(var i=0;i<c.length;i++){
		c[i].click();
	}
}
//结算
function submitit(){
	document.getElementById("cart_form").submit();
}
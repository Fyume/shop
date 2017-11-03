//颜色选择
function color_selected(str){
	var color=document.getElementById("Goods_good_type_c_color"+str);
	document.getElementById("Goods_good_type_c_color"+str).className="Goods_good_type_c_color_selected";
	for(var i=1;i<10;i++){
		if(i!=str){
			document.getElementById("Goods_good_type_c_color"+i).className="Goods_good_type_c_color";
		}
	}
	color.click();
}
//套餐选择
function version_selected(str){
	var version=document.getElementById("Goods_good_type_v_version"+str);
	document.getElementById("Goods_good_type_v_version"+str).className="Goods_good_type_v_version_selected";
	for(var i=1;i<10;i++){
		if(i!=str){
			document.getElementById("Goods_good_type_v_version"+i).className="Goods_good_type_v_version";
		}
	}
	version.click();
}
//大图随小图选择而切换
function img_change(str1,str2){
	document.getElementById("Goods_good_i_cimg_img").src=str1;
	for(var id=0;id<5;id++){
		if(id!=str2){
			document.getElementById("Goods_good_simg"+id).className="Goods_good_simg";
		}else{
			document.getElementById("Goods_good_simg"+str2).className="Goods_good_simg_selected";
		}
	}
}
//数量输入框限制输入只能为整数
function checkit(){
	if(!(event.keyCode==46)&&!(event.keyCode==8)&&!(event.keyCode==37)&&!(event.keyCode==39))
	if(!((event.keyCode>=48&&event.keyCode<=57)||(event.keyCode>=96&&event.keyCode<=105)))
	event.returnValue=false;
}
//数量增加按钮
function add_num(){
	var num=document.getElementById("Goods_good_type_num_text");
	num.value=num.value*1+1;//类型默认字符串，必须*1转换为数值？
}
//数量减少按钮
function dec_num(){
	var t=document.getElementById("Goods_good_type_num_text");
	if(t.value*1>1){
	t.value-=1;
	}
}
//数量输入框拾取焦点时检查，空时设为1
function checknum(){
	var tt=document.getElementById("Goods_good_type_num_text");
	if(tt.value==null||tt.value==""){
		tt.value+=1;
	}
}
//进入店铺
function intoStore(){
	document.getElementById("Goods_shop_s_storename").click();
}
//支付方式
//衣服的
function payit_c(){
	var paytype=document.getElementsByName("BusinessType");
	for(var i=0;i<paytype.length;i++){
		paytype.item(i).value="pay";
	}
	document.getElementById("Goods_good_type_form_c").submit();
}
function intoCart_c(){
	var paytype=document.getElementsByName("BusinessType");
	for(var i=0;i<paytype.length;i++){
		paytype.item(i).value="intocart";
	}
	document.getElementById("Goods_good_type_form_c").submit();
}
//书本的
function payit_b(){
	var paytype=document.getElementsByName("BusinessType");
	for(var i=0;i<paytype.length;i++){
		paytype.item(i).value="pay";
	}
	document.getElementById("Goods_good_type_form_b").submit();
}
function intoCart_b(){
	var paytype=document.getElementsByName("BusinessType");
	for(var i=0;i<paytype.length;i++){
		paytype.item(i).value="intocart";
	}
	document.getElementById("Goods_good_type_form_b").submit();
}
//食物的
function payit_f(){
	var paytype=document.getElementsByName("BusinessType");
	for(var i=0;i<paytype.length;i++){
		paytype.item(i).value="pay";
	}
	document.getElementById("Goods_good_type_form_f").submit();
}
function intoCart_f(){
	var paytype=document.getElementsByName("BusinessType");
	for(var i=0;i<paytype.length;i++){
		paytype.item(i).value="intocart";
	}
	document.getElementById("Goods_good_type_form_f").submit();
}

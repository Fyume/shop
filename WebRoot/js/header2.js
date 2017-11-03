/**
 * 
 */
function Goodselect() {
	var g=document.getElementById("header2_center_top_Goods");
	var s=document.getElementById("header2_center_top_Shop");
	var gr=document.getElementById("header2_center_top_Goods_radio");
	g.className = "header2_center_top_Goods_selected";
	s.className = "header2_center_top_Shop";
	gr.click();
}
function Shopselect() {
	var sr=document.getElementById("header2_center_top_Shop_radio");
	document.getElementById("header2_center_top_Shop").className = "header2_center_top_Shop_selected";
	document.getElementById("header2_center_top_Goods").className = "header2_center_top_Goods";
	sr.click();
}

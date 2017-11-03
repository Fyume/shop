/**
 * 
 */
function type_change1() {
	document.getElementById("body_type_b1").className="body_type_b1_action";
	document.getElementById("body_type_b2").className="body_type_b2";
	document.getElementById("body_type_b3").className="body_type_b3";
	document.getElementById("body_type_selected").value = "Cloth";
	document.getElementById("body_type_form").submit();
}
function type_change2() {
	document.getElementById("body_type_b1").className="body_type_b1";
	document.getElementById("body_type_b2").className="body_type_b2_action";
	document.getElementById("body_type_b3").className="body_type_b3";
	document.getElementById("body_type_selected").value = "Book";
	document.getElementById("body_type_form").submit();
}
function type_change3() {
	document.getElementById("body_type_b1").className="body_type_b1";
	document.getElementById("body_type_b2").className="body_type_b2";
	document.getElementById("body_type_b3").className="body_type_b3_action";
	document.getElementById("body_type_selected").value = "Food";
	document.getElementById("body_type_form").submit();
}

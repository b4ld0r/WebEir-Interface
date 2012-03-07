function evaluateMessage(jsonObject){
	if(jsonObject.status=="success"){
		$("#successMsg").text(jsonObject.message);
		$("#successMsg").show("clip");
	}
}

var procesaRespuesta=function(response, postdata) {
	var json = eval("(" + response.responseText + ")");
	evaluateMessage(json);
	return [json.status=="success",json.message];
}

$.extend($.jgrid.defaults, {
	datatype: "json",
	jsonReader : {
	repeatitems:false,
	id:0,
	total: function(result) {
	  //Total number of pages
	  return Math.ceil(result.total / result.max);
	},
	records: function(result) {
	  //Total number of records
	  return result.total;
	}
	},
	prmNames: {rows: "max", search: null},
	height: "auto",
	width:750,
	viewrecords: true,
	rowList: [10, 20, 50, 100],
	altRows: true,
	rowNum:10,
	loadError: function(xhr, status, error) {
		alert(error);
	}
});

$.extend($.jgrid.edit, {
  ajaxEditOptions: { contentType: "application/json" },
  mtype: "POST",
  modal:true,
  resize:false,
  drag:false,
  width: 670,
  jqModal:true,
  closeAfterEdit:true,
  afterSubmit:procesaRespuesta,
  serializeEditData: function(data) {
	if(data.oper=="edit")
		asignaIdCorrecto(data);
	delete data.oper;
	delete data.id;
	return JSON.stringify(data);
  }
});

$.extend($.jgrid.del, {
  mtype: "POST",
  resize:false,
  drag:false,
  width: 500,
  afterSubmit:procesaRespuesta,
  serializeDelData: function() {
	return "";
  }
});

$.extend($.jgrid.add, {
	mtype: "POST",
	closeAfterAdd:true,
	clearAfterAdd:true,
	afterSubmit:procesaRespuesta
});

$.extend($.jgrid.view, {
	resize:false,
	drag:false,
	width: 670,
});

$(document).ready(function(){
	
	$("#successMsg").click(function(){
		$(this).hide("fold");
	});
	
});

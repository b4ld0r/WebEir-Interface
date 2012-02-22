$.extend($.jgrid.defaults, {
	datatype: "json",
	jsonReader : {
	repeatitems:false,
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


//////////////
$.extend($.jgrid.edit, {
  ajaxEditOptions: { contentType: "application/json" },
  mtype: "POST",
  width: 400,
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
  width: 400,
  serializeDelData: function() {
	return "";
  }
});
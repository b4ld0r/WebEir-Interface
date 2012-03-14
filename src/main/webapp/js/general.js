function Validaciones(){}
Validaciones.trim = function(value){
	return value.replace(/\s+$/, "").replace(/^\s+/, "");
}
Validaciones.esAlfabetico = function(value, colname){
	value = Validaciones.trim(value);
	var regExp = /^[a-zA-Z \u00E1\u00E9\u00ED\u00F3\u00FA\u00C1\u00C9\u00CD\u00D3\u00DA\u00F1\u00D1]+$/;
	var valido = regExp.test(value);
	
	if(colname != null){
		return [valido, (valido?"":colname + ": Campo alfab\u00E9tico")];
	}
	else{
		return valido;
	}
}
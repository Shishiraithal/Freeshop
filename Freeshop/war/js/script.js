function changeProdImage(el) {
	var src = el.childNodes[0].src;
	document.getElementById("prod_imagem").childNodes[0].src = src;
}

function number_only(myfield, e, dec) {
	var key;
    var keychar;
    var field = myfield;

    if (window.event) {
        key = window.event.keyCode;
    } else if (e) {
        key = e.which;
    } else {
        return true;
	}
                   
    if ((key == null) || (key==37) || (key==39) || (key==8) || (key==46) || (key==27) ) {
        if (((key==46) || (key==8))) {
            if (field.value.indexOf("0") > 0) {
                field.value = "1";
                return false;
            }
        }
        return true;
    }
	
   if ((key > 47 && key < 58) || (key > 95 && key < 106)) {
        if ((key == 48 || key == 96) && field.value > 0) {
            if (field.value > 998) {
                return false;
            }
            field.value += "0";
            return false;
        } else if ((key == 48 || key == 96) && field.value == "") {
            return false;
        }
        return true;

		} else {
        return false;
    }
}

function changeUFFrete(frete_local_entrega, frm) {
	var frete = frete_local_entrega[frete_local_entrega.selectedIndex].value;
	var div = document.getElementById("divPrecoFrete");
	if( frete == "" ) {
		div.innerHTML = "";
	} else if( frete == "0,00" ) {
		div.innerHTML = "Frete Grátis";
	} else {
		div.innerHTML = "+ Frete: R$ " + frete;
	}
	frm.frete.value = frete.replace(",","");
}

function writeEmail(user, host) {
	document.write(user + "@" + host);
}

function validarCompra(frm) {
	var regex = /[1][0][0-9]+/;
	var frete = frm.frete_local_entrega[frm.frete_local_entrega.selectedIndex].value;
	if( frete == "" ) {
		alert("Informe o local de entrega.");
		return false;
	}
	var id = trim(frm.codigo.value);
	if( id.length == 0 ) {
		alert("Informe o código da reserva, por favor.");
		return false;
	} else {
		
		if( id.length == 4 ) {
			frm.item_id.value = id;
		} else if( id.length == 9 ) {
			frm.item_id.value = id.substring(0,4);
			frm.item_valor.value = id.substring(4);
		} else if( id.length == 13 ) {
			frm.item_id.value = id.substring(0,4);
			frm.item_valor.value = id.substring(4,9);
			frm.frete.value = id.substring(9);
		} else {
			alert("Código da reserva inválido.");
			return false;
		}
		
		if( !isInteger(id) ) {
			alert("Código da reserva inválido.");
			return false;
		}
	}
	return true;
}

function calcularFrete(el) {
	el.form.action = "shop/frete.asp";
	el.form.submit();
}

/****************************************************************/
/****************************************************************/

function Ajax(method, url, onSuccess, onError) {
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		} else {
			// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		
		xmlhttp.onreadystatechange=function() {
			if (xmlhttp.readyState==4) {
				if(xmlhttp.status==200) {
					alert(xmlhttp.responseText);
				} else {
					alert("erro: "+xmlhttp.status);
				}
			}
		}
		xmlhttp.open(method,url,true);
		xmlhttp.send();
	
}

/****************************************************************/
/****************************************************************/

function trim( value ) {
    return rtrim(ltrim(value));
}

function ltrim( value ) {
    if( isNull(value) ) {
        return null;
    }
    return value.replace(/^\s+/,"");
}

function rtrim( value ) {
    if( isNull(value) ) {
        return null;
    }
    return value.replace(/\s+$/,"");
}

function isNull( obj ) {
    return (obj == null);
}

function isEmpty( value ) {
    return (value == "");
}

function isBlank( value ) {
    if( isNull(value) ) {
        return true;
    }
    for( var i=0; i<value.length; i++ ) {
        if ((value.charAt(i)!=" ") && (value.charAt(i)!="\t") &&
            (value.charAt(i)!="\n")&&(value.charAt(i)!="\r")) {
            return false;
        }
    }
    return true;
}

function isDigit( value ) {
    if( value.length != 1 ) {
        return false;
    }
    var string = "1234567890";
    return (string.indexOf(value) > -1);
}

function isInteger( value ) {
    re = /^-{0,1}\d+$/;
    return re.test(value);
}

function isNumeric( value ) {
    re = /^-{0,1}\d*\.{0,1}\d+$/;
    return re.test(value);
}
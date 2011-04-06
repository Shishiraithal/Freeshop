function changeProdImage(el) {
	var src = el.childNodes[0].src;
	document.getElementById("prod_imagem").childNodes[0].src = src;
}

function writeEmail(user, host) {
	document.write(user + "@" + host);
}

/****************************************************************/
/****************************************************************/
var idxTags = 0;

function addNewTag(tags) {
	addTag(tags.value);
	tags.value = "";
}

function addTag(tag) {
	tags = tag.split(",");

	for( i=0; i<tags.length; i++ ) {
		var newDiv = document.createElement("div");
		newDiv.setAttribute("id","divTag"+idxTags);
		
		var newTag = document.createElement("input");
		newTag.setAttribute("type","hidden");
		newTag.setAttribute("name","product.tags["+idxTags+"]");
		newTag.setAttribute("value",tags[i]);
		newDiv.appendChild(newTag);
	
		var newTagLabel = document.createTextNode(" "+tags[i]+" ");
		newDiv.appendChild(newTagLabel);
	
		var newTagLink = document.createElement("a");
		var newTagLinkText = document.createTextNode("[x]");
		newTagLink.appendChild(newTagLinkText);
		newTagLink.setAttribute("idxTag",idxTags); 
		newTagLink.setAttribute("title","excluir tag"); 
		newTagLink.setAttribute("href","javascript:void(0);"); 
		newTagLink.onclick = function() {
			var idx = this.getAttribute("idxTag");
			var remDiv = document.getElementById("divTag"+idx);
			var theDiv = document.getElementById("divTags");
			theDiv.removeChild(remDiv);
		};
		newDiv.appendChild(newTagLink);
	
		var divTags = document.getElementById("divTags");
		divTags.appendChild(newDiv);
		
		idxTags++;
	}
}

/****************************************************************/
/****************************************************************/

function Ajax(method, url, onSuccess, onError) {
		if (window.XMLHttpRequest) {
			// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp = new XMLHttpRequest();
		} else {
			// code for IE6, IE5
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
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
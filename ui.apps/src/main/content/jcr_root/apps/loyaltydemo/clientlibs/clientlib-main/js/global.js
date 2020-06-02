const PROFILE_ID_CK_NAME = 'loyaltyProfileIDCookie';
const USERNAME_CK_NAME = 'userName';
const USER_FIRST_NAME_CK_NAME = 'userFirstName';
const POINTS_CK_NAME = 'userPoints';
const CARDNUM_CK_NAME = 'cardNumber';
const TIER_CK_NAME = 'userTier';
const LINKEDPOOL_CK_NAME = 'inLinkedPool';

function isObject(obj) {
   return Object.prototype.toString.call(obj) === '[object Object]';
}
var ckprefix;
var queryParams = [];
function getQueryParameterValue(param){
	if (queryParams.length <= 0) {
		var hash;
	    var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
	    for(var i = 0; i < hashes.length; i++)
	    {
	        hash = hashes[i].split('=');
	        queryParams.push(hash[0]);
	        queryParams[hash[0]] = hash[1];
	    }
	}
    return ($.inArray(param,queryParams) != -1) ? queryParams[param] : "";
}

function setCookie(name,value,days) {
    var expires = "";
    if (days) {
        var date = new Date();
        date.setTime(date.getTime() + (days*24*60*60*1000));
        expires = "; expires=" + date.toUTCString();
    }
    name = ckprefix + name;
    document.cookie = name + "=" + (value || "")  + expires + "; path=/";
}
function getCookie(name) {
	name = ckprefix + name;
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

function eraseCookie(name) {   
	name = ckprefix + name;
	document.cookie = name + '=; Path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
}

function setSessionStorageItem(name,value) {
	name = ckprefix + name;
    sessionStorage.setItem(name,value);
}

function getSessionStorageItem(name) {
	name = ckprefix + name;
	return sessionStorage.getItem(name)
}

function removeSessionStorageItem(name) {   
	name = ckprefix + name;
	sessionStorage.removeItem(name);
}

function clearLoyaltyCookies(){
	var cookieNames = document.cookie.split(/=[^;]*(?:;\s*|$)/);
	for (var i = 0; i < cookieNames.length; i++) {
		var name = cookieNames[i];
	    if (name.startsWith(ckprefix)) {
	    	document.cookie = name + '=; Path=/;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
	    }
	}
}

function clearLoyaltySessionStorage(){
	for (var i = 0; i < sessionStorage.length; i++){
		var name = sessionStorage.key(i);
	    if (name.startsWith(ckprefix)) {
	    	sessionStorage.removeItem(name);
	    }
	}
}

function updateUserDetails(){
	if (getCookie(PROFILE_ID_CK_NAME) != null) {
		if ($(".userFirstName").length > 0 && getCookie(USER_FIRST_NAME_CK_NAME) != null) {
			$(".userFirstName").text(getCookie(USER_FIRST_NAME_CK_NAME));
		}
		if ($(".userPoints").length > 0 && getCookie(POINTS_CK_NAME) != null) {
			$(".userPoints").text(getCookie(POINTS_CK_NAME));
	    	$(".userPoints").digits();
		}
		if ($(".userTier").length > 0 && getCookie(TIER_CK_NAME) != null) {
			$(".userTier").text(getCookie(TIER_CK_NAME));
		}
	} else if (getCookie(USER_FIRST_NAME_CK_NAME) != null) {
		clearLoyaltyCookies();	
		//clearLoyaltySessionStorage();
	}
}

$('button.linkBtn').click(function() {
	var url = $(this).data("url");
	var target = $(this).data("target") ? $(this).data("target") : "_self";
	window.open(url, target);
});

$(document).ready(function() {
	ckprefix = $("#cookiePrefix").val() ?  $("#cookiePrefix").val() : "";
	updateUserDetails();
});
use(function() {
    var prefix = request.getAttribute("cookiePrefix") ? request.getAttribute("cookiePrefix") : "";
    var profileIdCookie = request.getCookie(prefix + "loyaltyProfileIDCookie");
    var userFirstName = request.getAttribute("userFirstName");
    var userPoints = request.getAttribute("userPoints");
    var userTier = request.getAttribute("userTier");
    var cardNum = request.getAttribute("cardNumber");
    var inLinkedPool = request.getAttribute("inLinkedPool");
    var cookieFound = false;
    if (profileIdCookie != null) {
        cookieFound = true;
    }
    return {
        userFirstName: userFirstName != null ? userFirstName : '',
        userPoints: userPoints != null ? userPoints : '',
        userTier: userTier != null ? userTier : '',
        cardNum: cardNum != null ? cardNum : '',
        inLinkedPool: inLinkedPool != null ? inLinkedPool : '',
        cookieFound: cookieFound
    };

});
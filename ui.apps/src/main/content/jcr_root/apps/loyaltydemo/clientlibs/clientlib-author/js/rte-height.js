(function(document, $) {
    "use strict";

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        $(document).on("foundation-contentloaded", function(e) {
        	
        var rtelist = ["./desc1", "./desc3", "./adddesc", "./editdesc", "./autoenabledesc", "./autodisableddesc",
                       "./autodisableddesc", "./allocdesc", "./autoreviewdesc", "./autonotification",
                       "./autotydesc", "./rewardError", "./incrementError", "./howdesc", "./ondemandreviewdesc",
                       "./ondemandnotification", "./ondemandtydesc", "./modaldesc", "./inactiveInfo", "./fidAccInfo",
                       "./fundInfo", "./tickerInfo"];

        var $this =  $(this);
        $(rtelist).each(function(index, item){
        	var $item = $this.find("[name='"+item+"']");
        	$item.css("height", "180px");
        });
       
    });

    });
})(document,Granite.$);
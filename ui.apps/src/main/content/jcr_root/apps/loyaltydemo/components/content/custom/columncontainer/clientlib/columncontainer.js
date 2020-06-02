(function(document, $, ns) {
    $(document).on("click", ".cq-dialog-submit", function(ev) {

        var $form = $(this).closest("form.foundation-form");

        if ($form.find(".column-width-validation").length > 0) {
            var text = 0;
            $form.find(".column-width-validation").each(function() {
                var val = $(this).val();
                text = parseInt(text) + parseInt(val);
            });
            var message, clazz = "coral-Button ";
            if (text > 12) {
                ev.preventDefault();
                ns.ui.helpers.prompt({
                    title: Granite.I18n.get("Invalid Input"),
                    message: "please enter column layout within 100%",
                    actions: [{
                        id: "CANCEL",
                        text: "CANCEL",
                        className: "coral-Button"
                    }],
                    callback: function(actionId) {
                        if (actionId === "CANCEL") {}
                    }
                });

            } else {
                $(this).closest("form").submit();
            }
        }

    });
})(document, Granite.$, Granite.author);		
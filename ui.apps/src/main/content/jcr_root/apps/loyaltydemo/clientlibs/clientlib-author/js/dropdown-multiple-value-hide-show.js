(function (document, $) {
    "use strict";

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function (e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-hidefor", e.target));
    });

    $(document).on("selected", ".cq-dialog-dropdown-hidefor", function (e) {
        showHideHandler($(this));
    });

    function showHideHandler(el) {
        el.each(function (i, element) {
            if($(element).is("coral-select")) {
                // handle Coral3 base drop-down
                Coral.commons.ready(element, function (component) {
                    showHide(component, element);
                    component.on("change", function () {
                        showHide(component, element);
                    });
                });
            } else {
                // handle Coral2 based drop-down
                var component = $(element).data("select");
                if (component) {
                    showHide(component, element);
                }
            }
        })
    }

    function showHide(component, element) {
        // get the selector to find the target elements. its stored as data-.. attribute
        var target = $(element).data("cqDialogDropdownHideforTarget");
        var $target = $(target);

        if (target) {
            var value;
            if (component.value) {
                value = component.value;
            }/* else if(component.getValue()) {
                value = component.getValue();
            }*/
            
            var hideFor = $(target).data('hidefortargetvalue').split(',');

            $target.not(".hide").addClass("hide");

            // unhide the target element that contains the selected value as
 			// data-showhidetargetvalue attribute
            if (hideFor.indexOf(value) == -1) {
                $target.removeClass("hide");
            }
        }
    }

})(document, Granite.$);
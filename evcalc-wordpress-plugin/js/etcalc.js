//jQuery(".etcalc-window").hide()

jQuery(document).ready(function () {
    jQuery("#etcalc-window__close-button").click(function () { // Если нажали на кнопку "закрыть"
        jQuery(".etcalc-window").animate({
            opacity: "hide"
        }, 300)
    })
    var openButton = document.getElementById("etcalc-open-calculator-button")
    openButton.onclick = displayCalculator
    jQuery("a#etcalc-open-calculator-button").on("click", function(){
        jQuery(".etcalc-window").show()
    })
})

function displayCalculator(device) {
    
    console.log("Pressed")
    jQuery(".etcalc-window").animate({
        opacity: 100
    }, 300)
}
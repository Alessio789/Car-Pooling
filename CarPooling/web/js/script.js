var APP = {

    showDriver: function () {
        document.getElementById("driver-form").style.display = "block"
        document.getElementById("passenger-form").style.display = "none"
    },

    showPassenger: function () {
        document.getElementById("driver-form").style.display = "none"
        document.getElementById("passenger-form").style.display = "block"
    },

    init_showDriver: function () {
        $("#driver").change(APP.showDriver);
    },

    init_showPassenger: function () {
        $("#passenger").change(APP.showPassenger)
    }
}


$(document).ready(function () {
    APP.init_showDriver();
    APP.init_showPassenger();
});
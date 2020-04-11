var APP = {

    showDriver: function () {
        document.getElementById("driver-form").style.display = "block";
        document.getElementById("passenger-form").style.display = "none";
    },

    showPassenger: function () {
        document.getElementById("driver-form").style.display = "none";
        document.getElementById("passenger-form").style.display = "block";
    },

    showTravels : function () {
        var arrivalCity = $("#arrivalCity").val();

        $.post("/CarPooling/travels.htm", {arrivalCity: arrivalCity},
            function (data) {
                var travels = JSON.parse(data);
                for (var i = 0; i < travels.length; i++) {

                    var travel = travels[i];

                    var text = document.getElementById("travelsContainer").innerHTML;
                    if (text == undefined) {
                        text = "";
                    }

                    document.getElementById("travelsContainer").innerHTML = "<br>" + text +
                        "<div class='card'>" +
                            "<div class='card-header'> From " + travel.departureCity + " to " + travel.arrivalCity + " by " + travel.driver.username + "</div>" +
                            "<div class='card-body'>" +
                                "<h5 class='card-title'>" + travel.departureCity + " - " + travel.arrivalCity + "</h5>" +
                                "<p class='card-text'> Date: " + travel.date + "<br>Travel Time: " + travel.travelTime + "</p>" +
                                "<a href='#' class='btn btn-primary'>More details and book</a>" +
                            "</div>" +
                        "</div>";
                }
            }).fail(function () {
                document.getElementById("travelsContainer").innerHTML = "Nobody organized a trip to that destination";
        });
    },



    init_showDriver: function () {
        $("#driver").change(APP.showDriver);
    },

    init_showPassenger: function () {
        $("#passenger").change(APP.showPassenger);
    },

    init_showTravels: function () {
       $("#go").on("click", APP.showTravels);
    }
}

$(document).ready(function () {
    APP.init_showDriver();
    APP.init_showPassenger();
    APP.init_showTravels();
});
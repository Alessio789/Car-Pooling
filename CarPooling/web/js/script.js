var APP = {
    getBookingByTravelId: function (travelId) {

        $.post("/CarPooling/bookingbytravel.htm", {travelId: travelId},
            function (data) {
                var bookings = JSON.parse(data);

                var requestedSeats = bookings.length

                document.getElementById(booking[0].travel.id).innerHTML = "Requested Seats: " + requestedSeats;
            });
    },

    showDriver: function () {
        document.getElementById("driver-form").style.display = "block";
        document.getElementById("passenger-form").style.display = "none";
    },

    showPassenger: function () {
        document.getElementById("driver-form").style.display = "none";
        document.getElementById("passenger-form").style.display = "block";
    },

    showTravels: function () {
        var arrivalCity = $("#arrivalCity").val();

        $.post("/CarPooling/travels.htm", {arrivalCity: arrivalCity},
            function (data) {
                var travels = JSON.parse(data);
                for (var i = 0; i < travels.length; i++) {

                    var travel = travels[i];

                    if (travel.luggage == true) {
                        var luggage = "Luggage are not accepted";
                    } else {
                        var luggage = "Luggage are accepted";
                    }

                    if (travel.additionalNotes == undefined) {
                        var additionalNotes = "";
                    } else {
                        var additionalNotes = travel.additionalNotes;
                    }

                    var text = document.getElementById("travelsContainer").innerHTML;
                    if (text == undefined) {
                        text = "";
                    }
                    document.getElementById("travelsContainer").innerHTML = "<br>" + text +
                        "<div class='card'>" +
                        "<div class='card-header'> From " + travel.departureCity + " to " + travel.arrivalCity + " by " + travel.driver.username + "</div>" +
                        "<div class='card-body'>" +
                        "<h5 class='card-title'>" + travel.departureCity + " - " + travel.arrivalCity + "</h5>" +
                        "<p class='card-text'> Date: " + travel.date + "<br> Travel Time: " + travel.travelTime + "</p><br>" +
                        "<p>" +
                        "<button class='login100-form-btn' data-toggle=\"collapse\" href=\"#collapse\" aria-expanded=\"false\" aria-controls=\"collapse\">" +
                        "More Details" +
                        "</button>" +
                        "</p>" +
                        "<div class=\"collapse\" id=\"collapse\">" +
                        "<div class=\"card card-body\">" +
                        "Contribution requested: " + travel.contribution + "<br>" +
                        luggage + "<br>" +
                        additionalNotes +
                        "<span id='" + travel.id + "'> Booked Seats: 0 </span>" +
                        "<div class='container-login100-form-btn'> <button class='login100-form-btn'> Book </button> </div>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>";

                    APP.getBookingByTravelId(travel.id);
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
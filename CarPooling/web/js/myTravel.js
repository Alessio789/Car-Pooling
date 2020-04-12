var APP = {

    getBookingByTravelId: function (travelId) {

        $.post("/CarPooling/bookingbytravel.htm", {travelId: travelId},
            function (data) {
                var bookings = JSON.parse(data);

                var requestedSeats = bookings.length

                document.getElementById(bookings[0].travel.id).innerHTML = "Requested Seats: " + requestedSeats;
            });
    },

    showTravels: function () {

        document.getElementById("travelsContainer").innerHTML = "";

        $.ajax({

            url: "/CarPooling/travels.htm",
            method: "GET",
            contentType: "application/json; charset=utf-8",
            accepts: {json: "application/json, text/javascript"},
            cache: false,
            timeout: 1000000,
            success: function (data) {
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
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>";

                    APP.getBookingByTravelId(travel.id);
                }
            },
            error: function () {
                document.getElementById("travelsContainer").innerHTML = "An error occurred, please try again later";
            }
        });
    }
}

$(document).ready(function () {
    APP.showTravels();
});
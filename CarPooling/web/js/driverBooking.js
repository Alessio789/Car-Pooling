var APP = {

    acceptBooking : function (event) {

        var buttonId = event.target.id;
        var s = buttonId.split("accept");
        var bookingId = s[1];

        $.post("/CarPooling/acceptbooking.htm", {bookingId: bookingId},
            function (data) {
                var booking = JSON.parse(data);

                document.getElementById(booking.id).innerHTML = "The reservation was successfully accepted";
            });
    },

    declineBooking : function (event) {
        var buttonId = event.target.id;
        var s = buttonId.split("accept");
        var bookingId = s[1];

        $.post("/CarPooling/declinebooking.htm", {bookingId: bookingId},
            function (data) {
                var booking = JSON.parse(data);

                document.getElementById(booking.id).innerHTML = "The reservation was successfully declined";
            });
    },
    getBookingByTravelId: function (travelId) {

        $.post("/CarPooling/bookingbytravel.htm", {travelId: travelId},
            function (data) {
                var bookings = JSON.parse(data);

                var requestedSeats = bookings.length
                for (var i = 0; i < requestedSeats; i++) {
                    document.getElementById("seats" + bookings[i].id).innerHTML = "Requested Seats: " + requestedSeats;
                }
            });
    },
    showDriverBooking: function () {
        $.ajax({

            url: "/CarPooling/driverbooking.htm",
            method: "GET",
            contentType: "application/json; charset=utf-8",
            accepts: {json: "application/json, text/javascript"},
            cache: false,
            timeout: 1000000,
            success: function (data) {
                var reservations = JSON.parse(data);

                for (var i = 0; i < reservations.length; i++) {
                    var reservation = reservations[i];

                    switch (reservation.accepted) {

                        case true:
                            var accepted = "You have already accepted this reservation";
                            break;

                        case false:
                            var accepted = "You have already declined this booking";
                            break;

                        default:
                            var accepted = "<div class=\"limiter\" id='" + reservation.id + "'>" +
                                "<div class=\"container-login100\" style='background-color: white'>" +
                                "<div class=\"container-login100-form-btn\">" +
                                "<button class=\"login100-form-btn\" id='accept" + reservation.id + "'>" +
                                "Accept" +
                                "</button>" +
                                "</div>" +
                                "<div class=\"container-login100-form-btn\" >" +
                                "<button class=\"login100-form-btn\" id='decline" + reservation.id + "'>" +
                                "Decline" +
                                "</button>" +
                                "</div>" +
                                "</div>" +
                                "</div>";
                            break;
                    }

                    var travel = reservation.travel;


                    var text = document.getElementById("driverBookingContainer").innerHTML;
                    if (text == undefined) {
                        text = "";
                    }
                    document.getElementById("driverBookingContainer").innerHTML = "<br>" + text +
                        "<div class='card'>" +
                        "<div class='card-header'> From " + travel.departureCity + " to " + travel.arrivalCity + " by " + travel.driver.username + "</div>" +
                        "<div class='card-body'>" +
                        "<h5 class='card-title'>Reservation of: " + reservation.passenger.username + "</h5>" +
                        "<p class='card-text'> Date: " + travel.date + "<br> Travel Time: " + travel.travelTime + "<br>" + accepted + "</p><br>" +
                        "<p>" +
                        "<button class='login100-form-btn' data-toggle=\"collapse\" href=\"#collapse" + travel.id + "\"aria-expanded=\"false\" aria-controls=\"collapse\">" +
                        "More Details" +
                        "</button>" +
                        "</p>" +
                        "<div class=\"collapse\" id=\"collapse" + travel.id + "\">" +
                        "<div class=\"card card-body\">" +
                        "Contribution requested: " + travel.contribution + "<br>" +
                        "<span id='seats" + reservation.id + "'> Booked Seats: 0 </span>" +
                        "</div>" +
                        "</div>" +
                        "</div>" +
                        "</div>";

                    APP.getBookingByTravelId(travel.id);
                    $("#accept" + reservation.id).on("click", APP.acceptBooking);
                    $("#decline" + reservation.id).on("click", APP.declineBooking);
                }
            },
            error: function () {
                document.getElementById("bookingContainer").innerHTML =
                    "<form action='/carPooling/findtravel.htm' method='GET'>" +
                    "<div class=\"login100-form validate-form\">" +
                    "<span class=\"login100-form-title\">" +
                    "You have not made any reservations" +
                    "</span>" +
                    "<div class=\"container-login100-form-btn\">" +
                    "<button class=\"login100-form-btn\" id=\"findTravel\">" +
                    "Find Travels" +
                    "</button>" +
                    "</div>" +
                    "</div>" +
                    "</form>";
            }
        });
    }
}
$(document).ready(function () {
    APP.showDriverBooking();
});

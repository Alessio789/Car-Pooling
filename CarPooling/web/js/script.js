var APP = {
    getBookingByTravelId: function (travelId) {

        $.post("/CarPooling/bookingbytravel.htm", {travelId: travelId},
            function (data) {
                var bookings = JSON.parse(data);

                var requestedSeats = bookings.length

                APP.getNumberSeats(requestedSeats, bookings[0].travel.id);
            });
    },

    getNumberSeats: function (requestedSeats, travelId) {
        $.post("/CarPooling/cars.htm/carbytravel.htm", {travelId: travelId, requestedSeats: requestedSeats},
            function (data) {
                var s = data.split(" ");
                var availableSeats = s[0];
                var travelId = s[1];

                if (availableSeats == 0) {
                    var seats = "This travel cannot be booked, it is full.";
                } else {
                    var seats = "<div class='container-login100-form-btn' id='container" + travelId + "'> <button class='login100-form-btn' id='button" + travelId + "'> Book </button> </div>";
                }
                document.getElementById(travelId).innerHTML = "Requested Seats: " + requestedSeats + "<br>Available Seats: " + availableSeats + "<br>" + seats;
                $("#button" + travelId).on("click", APP.ifAlreadyBooked);
            });
    },

    book: function (travelId) {

        $.post("/CarPooling/book.htm", {travelId: travelId},
            function (data) {
                var booking = JSON.parse(data);
                var travelId = booking.travel.id;

                document.getElementById("container" + travelId).innerHTML = "Booking made";

            });
    },

    ifAlreadyBooked: function (event) {

        var id = event.target.id;
        var s = id.split("button");
        var travelId = s[1];

        $.post("/CarPooling/alreadybooked.htm", {travelId: travelId},
            function (data) {

                if (data.length < 5) {
                     APP.book(data);

                } else {
                    var booking = JSON.parse(data);
                    var container = document.getElementById("container" + booking.travel.id);
                    switch (booking.accepted) {

                        case true:
                            container.innerHTML = "Your booking has been accepted";
                            break;

                        case false:
                            container.innerHTML = "Your booking has been declined";
                            break;

                        default:
                            container.innerHTML = "Your reservation has not yet been answered";
                            break;
                    }
                }
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

        document.getElementById("travelsContainer").innerHTML = "";

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
                        "<span id='" + travel.id + "'> Booked Seats: 0"  +
                        "<div class='container-login100-form-btn' id='container" + travel.id + "'> <button class='login100-form-btn' id='button" + travel.id + "'> Book </button> </div>" +
                        "</span>" +
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

    showBooking: function () {
        $.ajax({

            url: "/CarPooling/bookingmade.htm",
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
                            var accepted = "Your booking has been accepted";
                            break;

                        case false:
                            var accepted = "Your booking has been declined";
                            break;

                        default:
                            var accepted = "Your reservation has not yet been answered";
                            break;
                    }

                    var travel = reservation.travel;

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

                    var text = document.getElementById("bookingContainer").innerHTML;
                    if (text == undefined) {
                        text = "";
                    }
                    document.getElementById("bookingContainer").innerHTML = "<br>" + text +
                        "<div class='card'>" +
                        "<div class='card-header'> From " + travel.departureCity + " to " + travel.arrivalCity + " by " + travel.driver.username + "</div>" +
                        "<div class='card-body'>" +
                        "<h5 class='card-title'>" + travel.departureCity + " - " + travel.arrivalCity + "</h5>" +
                        "<p class='card-text'> Date: " + travel.date + "<br> Travel Time: " + travel.travelTime + "<br>" + accepted + "</p><br>" +
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
    APP.showBooking();
});
var APP = {

    showTravels: function () {

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
                    var text = document.getElementById("travelsContainer").innerHTML;
                    if (text == undefined) {
                        text = "";
                    }
                    document.getElementById("travelsContainer").innerHTML = "<br>" + text +
                        "<div class='card'>" +
                        "<div class='card-header'> From " + travel.departureCity + " to " + travel.arrivalCity + " by " + travel.driver.username + "</div>" +
                        "<div class='card-body'>" +
                        "<h5 class='card-title'>" + travel.departureCity + " - " + travel.arrivalCity + "</h5>" +
                        "<p class='card-text'> Date: " + travel.date + "<br> Travel Time: " + travel.travelTime + "</p>" +
                        "<a href='#' class='btn btn-primary'>More details</a>" +
                        "</div>" +
                        "</div>";
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
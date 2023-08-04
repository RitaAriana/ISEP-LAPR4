function getData() {

    var request = new XMLHttpRequest();
    var vBoard=document.getElementById("agvInformation");

    request.onload = function() {
        vBoard.innerHTML = this.responseText;
        vBoard.style.color="black";
        setTimeout(getData, 2000);
    };

    request.ontimeout = function() {
        vBoard.innerHTML = "Server timeout, still trying ...";
        vBoard.style.color="red";
        setTimeout(getData, 100);
    };

    request.onerror = function() {
        vBoard.innerHTML = "No server reply, still trying ...";
        vBoard.style.color="red";
        setTimeout(getData, 5000);
    };

    request.open("GET", "/dashboardData", true);
    request.timeout = 15000;
    request.send();
}


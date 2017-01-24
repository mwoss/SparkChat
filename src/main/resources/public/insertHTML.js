function insert(targetId, message) {
    id(targetId).insertAdjacentHTML("afterbegin", message);
}

//Helper function for selecting element by id
function id(id) {
    return document.getElementById(id);
}

function httpGet(theUrl)
{
    var xhttp = new XMLHttpRequest();
    var temp;
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            temp = xhttp.responseText;
        }
    };
    xhttp.open("GET", theUrl, false);
    xhttp.send();
    return temp;
}
function joinChannel(channelName){
    if(channelName !== ""){
        setCookie("channelName",channelName);
        document.location.href="/chat.html";
    }
}

function updateChannelList() {
    var data = JSON.parse(httpGet('http://' + location.hostname + ":" + location.port + "/channels"));
    id("channelList").innerHTML = "";
    data.channelList.forEach(function (channel) {
        insert("channelList", '<li><button id="' + channel + '" onclick="joinChannel(' + "'" + channel + "'" + ')">' + channel  + "</button></li>");
    });
}

//Send message if enter is pressed in the input field
id("message").addEventListener("keypress", function (e) {
    if (e.keyCode === 13) { joinChannel(e.target.value); }
});

id("send").addEventListener("click", function () {
    joinChannel(id("message").value);
});

id("log out").addEventListener("click", function () {
    logOut();
});

id("updateChannel").addEventListener("click", function () {
    updateChannelList();
});
function validateForm() {
    var username = document.forms["login_form"]["username"].value;
    if (username == "") {
        alert("Username must be filled out");
        return false;
    }
    else{
        setCookie("username",username);
    }
}
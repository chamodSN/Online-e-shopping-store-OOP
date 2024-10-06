function checkPassword() {
    var password = document.getElementById("pw").value;
    var cnfrmpassword = document.getElementById("rpw").value;

    if (password != cnfrmpassword) {
        alert('Password Missmatch');
        return false;
    }

    else {
        return true;
    }

}
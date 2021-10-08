$(document).ready(function () {
    restrictCopyPaste();
    restrictChars();
});

function restrictCopyPaste() {
    $('#phone-number').bind('copy paste cut',function(e) {
        e.preventDefault();
        alert('Cut/Copy/Paste options are disabled');
    });
}

function restrictChars() {
    $('#phone-number').keypress(function (e) {
        if (e.which !== 8 && e.which !== 0 && (e.which < 48 || e.which > 57)) {
            return false;
        }
    });
}

function checkPhoneNumberLength(phoneNumber) {
    if (phoneNumber.length < 7) {
        alert('Invalid length');
        return false;
    }
    return true;
}

function ajaxCall(phoneNumber) {
    var endpoint = 'http://localhost:8080/find-country/' + phoneNumber;
    $.ajax({
        url: endpoint,
        type: 'GET',
        success: function(res) {
            alert(res.countryName);
        },
        error: function (request, status, error) {
            alert(status);
        }
    });
}

function handleRequest() {
    var phoneNumber = document.getElementById('phone-number').value;
    if (checkPhoneNumberLength(phoneNumber)) {
        ajaxCall(phoneNumber);
    }
}

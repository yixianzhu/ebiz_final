$(document).ready(function(){
    $('[data-toggle="tooltip"]').tooltip();   
});

function checkCardName() {
    var inputNameOnCard = $("#inputNameOnCard").val();
    if (/^[a-zA-Z\s]*$/.test(inputNameOnCard)) {
        $(".status1").html("");
    } else {
        $(".status1").html("Wrong name input");
    }
}

function checkCardNumber() {
    var inputCardNumber = $("#inputCardNumber").val();
    if (!/[^0-9]/.test(inputCardNumber)) {
        $(".status2").html("");
    } else {
        $(".status2").html("Wrong card number");
    }
}

function checkSecurityNumber() {
    var inputSecurityCode = $("#inputSecurityCode").val();
    if (inputSecurityCode.length == 3) {
        if (!/[^0-9]/.test(inputSecurityCode)) {
            $(".status3").html("");
        } else {
            $(".status3").html("Wrong security code");
        }
    }else{
    	$(".status3").html("Security code should be 3-digit");
    }
}


function checkZipCode() {
    var inputBillingZipCode = $("#inputBillingZipCode").val();
    if (inputBillingZipCode.length == 5) {
        if (!/[^0-9]/.test(inputBillingZipCode)) {
            $(".status4").html("");
        } else {
            $(".status4").html("Wrong zip code");
        }
    }else{
    	$(".status4").html("Billing zip code should be 5-digit");
    }
}

function checkFirstName() {
    var inputFirstName = $("#inputFirstName").val();
    if (!/[^a-zA-Z]/.test(inputFirstName)) {
        $(".status5").html("");
    } else {
        $(".status5").html("First name should only contain letters");
    }
}


function checkLastName() {
	var inputLastName = $("#inputLastName").val();
    if (!/[^a-zA-Z]/.test(inputLastName)) {
        $(".status6").html("");
    } else {
        $(".status6").html("Last name should only contain letters");
    }
}


function checkEmail() {
    var inputEmail = $("#inputEmail").val();
    if (inputEmail.length <= 50) {
        if (/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i.test(inputEmail)) {
            $(".status7").html("");
        } else {
            $(".status7").html("Invalid email address");
        }
    }else{
        $(".status7").html("Invalid email address");
    }        
}

function checkTogoDate() {
    var inputDateTime = $("#inputDateTime").val();
    // if (inputDateTime.length < 10) {
    if (/^([0-9]{2})\/([0-9]{2})\-([0-9]{2})\:([0-9]{2})\/(AM|PM|am|pm)$/.test(inputDateTime)) {
        $(".status8").html("");
    } else {
        $(".status8").html("Invalid time. Please follow: mm/dd-hh:mm/AM");
    }
    // }else{
    //     $(".status8").html("Invalid date");
    // }       
}

function checkPhoneNumber() {
    var inputPhoneNumber = $("#inputPhoneNumber").val();
    if (inputPhoneNumber.length == 10) {
        if (!/[^0-9]/.test(inputPhoneNumber)) {
            $(".status9").html("");
        } else {
            $(".status9").html("Invalid phone number");
        }
    }else{
    	$(".status9").html("Phone number code should be 10-digit");
    }
}

function checkReceiverName() {
    var inputReceiverName = $("#inputReceiverName").val();
    if (inputReceiverName.length <= 20) {
        if (/^[a-zA-Z\s]*$/.test(inputReceiverName)) {
            $(".status10").html("");
        } else {
            $(".status10").html("Wrong name input");
        }
    }else{
        $(".status10").html("Wrong name input");
    }        
}


function checkSenderName() {
    var inputSenderName = $("#inputSenderName").val();
    if (inputSenderName.length <= 20) {
        if (/^[a-zA-Z\s]*$/.test(inputSenderName)) {
            $(".status11").html("");
        } else {
            $(".status11").html("Wrong name input");
        }
    }else{
        $(".status11").html("Wrong name input");
    }        
}


function checkSenderEmail() {
    var inputSenderEmail = $("#inputSenderEmail").val();
    if (inputSenderEmail.length <= 50) {
        if (/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i.test(inputSenderEmail)) {
            $(".status12").html("");
        } else {
            $(".status12").html("Invalid email address");
        }
    }else{
        $(".status12").html("Invalid email address");
    }       
}


function checkReceiverEmail() {
    var inputReceiverEmail = $("#inputReceiverEmail").val();
    if (inputReceiverEmail.length <= 50) {
        if (/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i.test(inputReceiverEmail)) {
            $(".status13").html("");
        } else {
            $(".status13").html("Invalid email address");
        }
    }else{
        $(".status13").html("Invalid email address");
    }        
}

function checkrFirstName() {
    var inputFirstName = $("#inputFirstName").val();
    if (!/[^a-zA-Z]/.test(inputFirstName)) {
        $(".status14").html("");
    } else {
        $(".status14").html("First name should only contain letters");
    }
}


function checkrLastName() {
    var inputLastName = $("#inputLastName").val();
    if (!/[^a-zA-Z]/.test(inputLastName)) {
        $(".status15").html("");
    } else {
        $(".status15").html("Last name should only contain letters");
    }
}

function checkrPhoneNumber() {
    var inputrPhoneNumber = $("#inputrPhoneNumber").val();
    if (inputrPhoneNumber.length == 10) {
        if (!/[^0-9]/.test(inputrPhoneNumber)) {
            $(".status16").html("");
        } else {
            $(".status16").html("Invalid phone number");
        }
    }else{
        $(".status16").html("Phone number code should be 10-digit");
    }
}

function checkrEmail() {
    var inputrEmail = $("#inputrEmail").val();
    if (inputrEmail.length <= 50) {
        if (/^[-a-z0-9~!$%^&*_=+}{\'?]+(\.[-a-z0-9~!$%^&*_=+}{\'?]+)*@([a-z0-9_][-a-z0-9_]*(\.[-a-z0-9_]+)*\.(aero|arpa|biz|com|coop|edu|gov|info|int|mil|museum|name|net|org|pro|travel|mobi|[a-z][a-z])|([0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}))(:[0-9]{1,5})?$/i.test(inputrEmail)) {
            $(".status17").html("");
        } else {
            $(".status17").html("Invalid email address");
        }
    }else{
        $(".status17").html("Invalid email address");
    }       
}

function checkrDate() {
    var inputrDate = $("#inputrDate").val();
    if (inputrDate.length < 10) {
        if (/^([0-9]{2})\/([0-9]{2})$/.test(inputrDate)) {
            $(".status18").html("");
        } else {
            $(".status18").html("Invalid date");
        }
    }else{
        $(".status18").html("Invalid date. Please follow: mm/dd");
    }       
}

function checkWalkinPhoneNumber() {
    var inputrPhoneNumber = $("#inputWalkinPhoneNumber").val();
    if (inputrPhoneNumber.length == 10) {
        if (!/[^0-9]/.test(inputrPhoneNumber)) {
            $(".status19").html("");
        } else {
            $(".status19").html("Invalid phone number");
        }
    }else{
        $(".status19").html("Phone number code should be 10-digit");
    }
}
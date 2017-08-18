
function validare(){
			
			
			var nume = $("#nume").val();
			var cnp = $("#cnp").val();
			var telefon = $("#telefon").val();
			var email = $("#email").val();
			
			if(nume == ""){
				alert("Nu ai introdus nimic la nume!");
				$("#nume").focus();
				return false;
			}
			
			if(cnp.length != 13 || isNaN(cnp)){
				alert("CNP-ul nu are lungimea corespunzatoare sau nu contine doar caractere numerice!");
				$("#cnp").focus();
				return false;
			}
			
			if(telefon == "" || telefon.length !=10){
				alert("Numarul de telefon nu are 10 cifre!");
				$("#telefon").focus();
				return false;	
			}
			
			if(!validateEmail(email) || email == ""){
				alert("Email-ul nu este valid!");
				$("#email").focus();
				return false;
			}
			
		
		submitForm();
		
		return true;
		
}


function validateEmail(mail) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(mail);
}

function validateNumber(event) {
    var key = window.event ? event.keyCode : event.which;
    if (event.keyCode === 8 || event.keyCode === 46) {
        return true;
    } else if ( key < 48 || key > 57 ) {
        return false;
    } else {
        return true;
    }
}

function submitForm(){
  
	if($("#nume").val() == "Selir"){
		document.formular.action = "Selir.html";
	}
	else{
		document.formular.action = "Hello.html";
	}
	document.forms["formular"].submit();
	return true;
	}





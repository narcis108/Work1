
function validare(){
	
	/*
	Am initializat variabilele pe baza informatiilor din formular si dupa am aplicat diferite teste pe ele.
	*/
	var nume = document.forms["formular"]["nume"].value;
	var cnp = document.forms["formular"]["cnp"].value;
	var telefon = document.formular.telefon.value;
	var email = document.formular.email.value;
	
	if(nume == ""){
		alert("Numele este camp obligatoriu!");
		document.formular.nume.focus();
		return false;
		}
		
	if(cnp.length != 13 || isNaN(cnp)){
		alert("CNP-ul trebuie sa cotina 13 cifre si toate sa fie caractere numerice!");
		document.formular.cnp.focus();
		return false;
		}
		
	if(telefon == "" || telefon.length != 10){
		alert("Numar de telefon nu are 10 cifre");
		document.formular.telefon.focus();
		return false;
	}
	
	if(!validateEmail(email)){
		alert("Email-ul nu este valid!");
		document.formular.email.focus();
		return false; 
		}
	
	Submit();	
}

function validateEmail(mail) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(mail);
}

function Submit(){
	
		if(document.formular.nume.value == "Selir"){
			document.formular.action = "Selir.html";
		}
		else{
			document.formular.action = "Hello.html";
		}
		document.forms["formular"].submit();
		return true;
		}
	

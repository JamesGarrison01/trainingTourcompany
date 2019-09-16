function verName(name)
  {
   var letters = /^[A-Za-z]+$/;
   if(name.value.match(letters))
     {
      return true;
     }
   else
     {
	   document.getElementById("validation").innerHTML = "Name must contain Letters only";
     return false;
     }
}

function verLicense(licenseNo) {
    var licenseLen = licenseNo.value.length;
    var letters = /^[0-9-A-Za-z]+$/;
    
    if (licenseLen.value.match(letters)) {
        document.getElementById("validation").innerHTML = "License Number Invalid";
        phonenum.focus();
        return false;
    }
    return true;
}

function formValidation(event) {
    document.getElementById("validation").innerHTML = "";
    event.preventDefault();
    
    var licenseNo = document.testDriveClass.bodyClass.tableClass.driveNoText;
    var name = document.testDriveClass.bodyClass.tableClass.customerNameText;
    
    if(verName(name)) {
        if(verLicense(licenseNo)) {
        	 document.loginform.submit();
        }
    }
    
    return false;
}
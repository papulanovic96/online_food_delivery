/**
 * 
 */

function validacija_adminLogin(forma){
	let username = document.getElementsByName('username').value;
	let password = document.getElementsByName('password').value;
	let back = true
	
	if(!username)
	{
		document.getElementsByName('username').style.background = 'red';
		back = false;
	}
	
	if(!password)
		{
			document.getElementsByName('password').style.background = 'red';
			back = false;
		}
	
	return back;	
}

function phonenumber(inputtxt, emajl)
{
  var phoneno = /^\(?([0-9]{3})\)?[/. ]?([0-9]{3})[-. ]?([0-9]{3})$/;
  if((inputtxt.value.match(phoneno)))
        {
      		
        }
      else
        {
        alert("Porgrešan format telefonskog broja!");
        return false;
        }
  
  var email = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
  if(emajl.value.match(email) && inputtxt.value.match(phoneno))
        {
      return true;
        }
      else
        {
        alert("Pogrešan format email-a!");
        return false;
        }
}



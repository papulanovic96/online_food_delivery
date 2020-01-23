function registration_plate(inputtxt, emajl)
{
  var xxx = /^\(?([0-9]{3})\)?[-. ]?([A-Za-z]{1})[-. ]?([0-9]{3})$/;
  if((inputtxt.value.match(xxx)))
        {
      		
        }
      else
        {
        alert("Porgrešan format registracije!");
        return false;
        }
  var email = /^[0-9]+$/;
  if(emajl.value.match(email) && inputtxt.value.match(xxx))
        {
      return true;
        }
      else
        {
        alert("Polje za godište prihvata samo brojeve!");
        return false;
        }
}

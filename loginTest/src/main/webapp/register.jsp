<html>
<script>
function ValidateForm()
{
    var firstname = document.getElementById("firstname");
    var lastname = document.getElementById("lastname");
    var email = document.getElementById("email");
    var password = document.getElementById("password");
    var confirmation = document.getElementById("confirmation");

    if (firstname.value == "")
    {
        window.alert("Please enter your first name.");
        name.focus();
        return false;
    }

    if (lastname.value == "")
    {
        window.alert("Please enter your last name");
        comment.focus();
        return false;
    }
    
    if (email.value == "")
    {
        window.alert("Please enter a valid e-mail address.");
        email.focus();
        return false;
    }
    if (email.value.indexOf("@", 0) < 0)
    {
        window.alert("Please enter a valid e-mail address.");
        email.focus();
        return false;
    }
    if (email.value.indexOf(".", 0) < 0)
    {
        window.alert("Please enter a valid e-mail address.");
        email.focus();
        return false;
    }

    if (password.value == "")
    {
        window.alert("Password field can not be empty");
        comment.focus();
        return false;
    }

    if (confirmation.value == "")
    {
        window.alert("Confirmation password field can not be empty");
        comment.focus();
        return false;
    }
    
    if(password === confirmation)
    	{
    	window.alert("Passwords don't match.");
        comment.focus();
        return false;
    	}
    return true;
}
</script>
<FORM ACTION="AccountRegisterServlet" " METHOD="post" onsubmit="ValidateForm()">

	<h1>Create New Account</h1>

	<TABLE BORDER="0">
		<TR>
			<TD>First Name</TD>
			<TD>Last Name</TD>
		</TR>
		<TR>
			<TD ALIGN="left"><INPUT TYPE="text" NAME="firstname" ID="firstname">
			</TD>
			<TD ALIGN="left"><INPUT TYPE="text" NAME="lastname" ID="lastname">
			</TD>
		</TR>
		<TR>
			<TD>Email Address</TD>
		</TR>
		<TR>
			<TD ALIGN="left"><INPUT TYPE="text" NAME="email" ID="email">
			</TD>
		</TR>
		<TR>
			<TD ALIGN="left"><input type="checkbox" name="is_subscribed" id ="is_subscribed"/>Sign Up for Newsletter
			</TD>
		</TR>
		<TR>
			<TD>Password</TD>
			<TD>Confirm Password</TD>
			</TD>
		</TR>
		<TR>
			<TD ALIGN="left"><INPUT TYPE="password" NAME="password" ID="password">
			<TD ALIGN="left"><INPUT TYPE="password" NAME="confirmation" ID="confirmation">
			</TD>
		</TR>
	</TABLE>

	<INPUT TYPE="submit" VALUE="Submit"> <INPUT TYPE="reset"
		VALUE="Clear">

</FORM>
</html>
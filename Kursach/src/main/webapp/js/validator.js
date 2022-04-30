function validate() {
    var password = document.form.password.value;
    var confirmPassword = document.form.confirmPassword.value;


    if (password !== confirmPassword) {
        alert("Confirm Password should match with the Password");
        return false;
    }

}

(function () {
    var $usernameFld, $firstNameFld, $lastNameFld,
        $phoneFld, $emailFld, $roleFld, $dobFld;
    var $updateBtn, $logoutBtn;
    var uid;
    var userService = new UserServiceClient();
    $(main);

    function main() {

        var url = new URL(window.location.href);
        uid = url.searchParams.get("uid");

        $usernameFld = $('#username');
        $firstNameFld= $('#firstNameFld');
        $lastNameFld= $('#lastNameFld');
        $phoneFld = $('#phoneFld');
        $emailFld = $('#emailFld');
        $roleFld = $('#roleFld');
        $dobFld = $('#dobFld');

        $updateBtn = $('#updateBtn');
        $logoutBtn = $('#logoutBtn');

        $updateBtn.click(update);
        $logoutBtn.click(logout);

        userService
            .profile()
            .then(function (user) {
                try {
                    $usernameFld.val(user.username);
                    $firstNameFld.val(user.firstName);
                    $lastNameFld.val(user.lastName);
                    $phoneFld.val(user.phone);
                    $emailFld.val(user.email);
                    $roleFld.val(user.role);
                    $dobFld.val(user.dateOfBirth.substr(0,10));
                }
                catch(err) {}
            });
    }

    function update() {
        var user = {
            username: $usernameFld.val(),
            firstName: $firstNameFld.val(),
            lastName: $lastNameFld.val(),
            phone: $phoneFld.val(),
            email: $emailFld.val(),
            dateOfBirth: $dobFld.val(),
            role: $roleFld.val()
        };

        $('.alert').show();

        userService
            .updateProfile(uid, user);
    }

    function logout() {
        userService
            .logout()
            .then(logoutRedirect);
    }

    function logoutRedirect() {
        window.location.replace("../login/login.template.client.html");
    }
})();

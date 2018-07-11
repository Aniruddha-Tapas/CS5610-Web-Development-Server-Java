(function () {
    var $usernameFld, $passwordFld;
    var $loginBtn;
    var userService = new UserServiceClient();
    $(main);

    function main() {
        $usernameFld = $('#username');
        $passwordFld = $('#password');

        $loginBtn = $('#login');

        $loginBtn.click(login);
    }
    function login() {
        var uId;
        var user = new User($usernameFld.val(), $passwordFld.val());
        userService
            .login(user)
            .then(function (promise) {
                var status = promise.status;
                console.log(status);
                if(status === 200){
                    promise.json().then(function (response) {
                        uId = response.id;
                        window.location.replace("../profile/profile.template.client.html?uid=" + uId);
                    });
                }
                else
                    alert("Please check your username or password again.");
            });
    }
})();

(function () {

    var $tbody;
    var $template;
    var $usernameFld, $firstNameFld, $lastNameFld,
        $passwordFld, $roleFld;
    var $createBtn, $updateBtn;

    $(main);

    var userService = new UserServiceClient();

    function main() {
        $tbody = $('tbody');
        $template = $('.template');
        $usernameFld = $('#usernameFld');
        $passwordFld = $('#passwordFld');
        $firstNameFld = $('#firstNameFld');
        $lastNameFld = $('#lastNameFld');
        $roleFld = $('#roleFld');
        $createBtn = $('.wbdv-create');
        $updateBtn = $('.wbdv-update');

        $createBtn.click(createUser);
        $updateBtn.click(updateUser);

        userService.findAllUsers()
            .then(renderUsers);
    }

    function createUser() {

        var username = $usernameFld.val();
        var password = $passwordFld.val();
        var firstName = $firstNameFld.val();
        var lastName = $lastNameFld.val();
        var role = $roleFld.val();
        var user = new User(username, password, firstName, lastName, role);

        userService
            .createUser(user)
            .then(findAllUsers);
    }

    function findAllUsers() {
        userService
            .findAllUsers()
            .then(renderUsers);
    }

    function renderUsers(users) {
        $tbody.empty();
        for(var i=0; i<users.length; i++) {
            var user = users[i];
            var clone = $template.clone();

            clone.attr('id', user.id);
            clone.attr('username', user.username);
            clone.attr('password', user.password);
            clone.attr('firstName', user.firstName);
            clone.attr('lastName', user.lastName);
            clone.attr('role', user.role);

            clone.find('.wbdv-remove').click(deleteUser);
            clone.find('.wbdv-edit').click(selectUser);

            clone.find('.wbdv-username')
                .html(user.username);
            clone.find('.wbdv-first-name')
                .html(user.firstName);
            clone.find('.wbdv-last-name')
                .html(user.lastName);
            clone.find('.wbdv-role')
                .html(user.role);
            $tbody.append(clone);
        }
    }

    function selectUser(event) {
        var editBtn = $(event.currentTarget);
        var userId = editBtn.parent().parent().parent().attr('id');
        $('.wbdv-update').attr('id',userId);
        findUserById(userId);
    }

    function findUserById(userId) {
        userService
            .findUserById(userId)
            .then(renderUser)
    }

    function renderUser(user) {

        console.log(user);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
    }

    function updateUser() {
        var userId = $('.wbdv-update').attr('id');
        var username = $usernameFld.val();
        var password = $passwordFld.val();
        var firstName = $firstNameFld.val();
        var lastName = $lastNameFld.val();
        var role = $roleFld.val();

        var user = new User(username, password, firstName, lastName, role);

        userService
            .updateUser(userId, user)
            .then(findAllUsers);
    }

    function deleteUser(event) {
        var deleteBtn = $(event.currentTarget);
        var userId = deleteBtn.parent().parent().parent().attr('id');

        userService
            .deleteUser(userId)
            .then(findAllUsers);
    }
})();
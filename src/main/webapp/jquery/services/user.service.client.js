function UserServiceClient() {

    this.createUser = createUser;
    this.findAllUsers = findAllUsers;
    this.deleteUser = deleteUser;
    this.updateUser = updateUser;
    this.findUserById = findUserById;
    this.register = register;
    this.login = login;
    this.logout = logout;
    this.profile = profile;
    this.updateProfile = updateProfile;
    this.url = '/api/user';
    var self = this;

    function createUser(user) {
        return fetch(self.url, {
            method: 'post',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function findAllUsers() {
        return fetch(self.url)
            .then(function (response) {
                return response.json();
            });
    }

    function findUserById(userId) {
        return fetch(self.url + '/' + userId)
            .then(function (response) {
                return response.json();
            });
    }

    function updateUser(userId, user) {
        return fetch(self.url + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response){
                if(response.bodyUsed) {
                    return response.json();
                } else {
                    return null;
                }
            });
    }

    function deleteUser(userId) {
        return fetch(self.url + '/' + userId, {
            method: 'delete'
        });
    }

    function register(user) {
        return fetch('/api/register', {
            method: 'post',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
            'content-type': 'application/json'
            }
        });
    }
    
    function login(user) {
        return fetch('/api/login', {
            method: 'post',
            body: JSON.stringify(user),
            credentials: 'include',
            headers: {
                'content-type': 'application/json'
            }
        });
    }

    function logout() {
        return fetch('/api/logout', {
            method: 'post',
            credentials: 'include'
        });
    }

    function profile() {
        return fetch('/api/profile', {
          'credentials': 'include'
        })
            .then(function (response) {
              return response.json();
            });
     }

    function updateProfile(userId, user) {
        return fetch('/api/profile' + '/' + userId, {
            method: 'put',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        })
            .then(function(response){
                if(response.bodyUsed) {
                    return response.json();
                } else {
                    return null;
                }
            });
    }
}
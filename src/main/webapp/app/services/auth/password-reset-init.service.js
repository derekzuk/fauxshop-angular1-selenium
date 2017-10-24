(function() {
    'use strict';

    angular
        .module('jhipseleniumApp')
        .factory('PasswordResetInit', PasswordResetInit);

    PasswordResetInit.$inject = ['$resource'];

    function PasswordResetInit($resource) {
        var service = $resource('api/account/reset_password/init', {}, {});

        return service;
    }
})();

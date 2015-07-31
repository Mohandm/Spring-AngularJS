//Define a function scope, variables used inside it will NOT be globally visible.
(function () {

    var
        message, action,
    //Define the main module.
        app = angular.module('app',
            ['ngAnimate',
                'ngCookies',
                'ngResource',
                'ngRoute','ui.grid']);

    app.config(function ($routeProvider, $httpProvider) {
        //configure the rounting of ng-view
        $routeProvider
            .when('/', {
                templateUrl: 'app/index.html'
            })
            .when('/registerParam', {
                templateUrl: 'app/views/parameterRegister.html'
            })
      
             .otherwise({
                redirectTo: '/'
            });

        // Configure $http to catch authentication error responses
  /*      $httpProvider.interceptors.push(['$injector',function ($injector) {
            return $injector.get('AuthInterceptorService');
        }]);*/

        //configure $http to catch message responses and show them
/*        $httpProvider.responseInterceptors.push(function ($q, $timeout) {

            var setMessage = function (response) {
                //if the response hvsmApp a text and a type property, it is a message to be shown
                if (response.data && response.data.text && response.data.type) {
                    message = {
                        text: response.data.text,
                        type: response.data.type,
                        show: true
                    };
                }
                // Clear messages after some time
                $timeout(function(){message = {show: false};}, 5000);
            };
            return function (promise) {
                return promise.then(
                    //this is called after each successful server request
                    function (response) {
                        setMessage(response);
                        return response;
                    },
                    //this is called after each unsuccessful server request
                    function (response) {
                        setMessage(response);
                        return $q.reject(response);
                    }
                );
            };
        });*/
    });

   /* app.run(function ($rootScope,$http, AlertsService, $location,TourService, AuthService, AUTH_EVENTS,$timeout) {
        //make current message accessible to root scope and therefore all scopes
        $rootScope.message = function () {
            return message;
        };

        $rootScope.isAuthenticated = function () {
            return AuthService.isAuthenticated();
        };

        $rootScope.onPageLoad = function(floatingShareOptions){
            var alertsListPromise = AlertsService.getUserNotifications();
            alertsListPromise.then(function(data){
                $rootScope.alertsList = data.alertsList;
                $rootScope.notificationsList = data.notificationsList;
            });

            var title = ' Misys - Stock Market League'
                ,desc = '(A Game to Enthrall and Engage you on Stock Markets!).'
                , url = 'http://www.misys.com/';
            if(floatingShareOptions)
            {
                if(floatingShareOptions.title)
                {
                    title = floatingShareOptions.title;
                }
                if(floatingShareOptions.description)
                {
                    desc = floatingShareOptions.description;
                }
                if(floatingShareOptions.url)
                {
                    url = floatingShareOptions.url;
                }
            }
            $("body").floatingShare({
                place: "top-right",
                buttons: ["facebook","twitter","linkedin"],
                title : title,
                description : desc,
                url : url
            });
        };

        var setLogoutMessage = function ($timeout) {
            message = {
                text: "You have been successfully logged out.",
                type: "success",
                show: true
            };
        };

        $rootScope.$on(AUTH_EVENTS.logoutSuccess, setLogoutMessage);

        $rootScope.$on('$routeChangeStart', function(event, currRoute, prevRoute){
          
            // Sync the session with the server side and show login modal dialog if required
            AuthService.syncSession().then(function () {
                // If user is not logged in and the route needs login show the modal dialog
                if (!AuthService.isAuthenticated() && angular.isDefined(currRoute.needsLogin) && currRoute.needsLogin) {
                    $rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
                }
            });
            $rootScope.animateTransition = false;

            // Animate transitions if needed
            if (angular.isDefined(currRoute.needsTransition) && currRoute.needsTransition) {
                $rootScope.animateTransition = true;
            }

            // Clear messages after some time
            $timeout(function(){message = {};}, 5000);

        });
    });*/
}());
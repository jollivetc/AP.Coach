/**
 * Created by micka on 09/03/16.
 */
'use strict';
(function(window,angular){

  angular.module('header',[])
    .directive('apHeader',apHeaderDirective);

  angular.module('layout', ['header'])
    .config(['$stateProvider', '$provide', function ($stateProvider, $provide) {
      $stateProvider
        .state('layout', {
          abstract: true,
          views: {
            '@': {templateUrl: 'layout/page.html'}
          }
        });

      }]);



  function apHeaderDirective() {
    return {
      restrict: 'E',
      templateUrl: 'layout/header.html'
    };
  }

})(window,window.angular);

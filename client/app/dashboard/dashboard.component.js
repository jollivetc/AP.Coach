/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){


  angular.module('dashboard.component',  [])
    .directive('nextSessions', directiveNextSessions);

  function directiveNextSessions() {
    return {
      restrict: 'E',
      scope: {
        sessions: '='
      },
      controller: function() {

      },
      controllerAs: 'nextSessionsCtrl',
      bindToController: true,
      templateUrl: 'dashboard/listeNextSessions.html'
    }
  }

})(window,window.angular);

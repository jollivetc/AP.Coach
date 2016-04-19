/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){


  angular.module('session.module',  [
      'session.service','layout'
    ])
    .controller('controllerStateSessions',controllerStateSessions)
    .controller('detailsSessionController',controllerStateDetailSession)
    .config(['$stateProvider', function ($stateProvider) {
      $stateProvider
        .state('session', {
          parent: 'layout',
          url: '/session',
          resolve: {
            resolveSessions: ['sessionServiceResource',function(sessionRessource) {
              return sessionRessource.getAll();
            }]
          },
          views: {
            '@layout': {
              templateUrl: 'session/session.html',
              controller: 'controllerStateSessions',
              controllerAs: 'sessionCtlr'
            }
          }
        })
        .state('detailsSession', {
        data: {pageTitle: 'Détails d\'une session'},
        parent: 'session',
        resolve: {
          currentSession: ['$stateParams','sessionServiceResource', function ($stateParams,sessionServiceResource) {
            return sessionServiceResource.getById(parseInt($stateParams.idSession));
          }]
        },
        url: '/{idSession}',
        views: {
          '@layout': {
            templateUrl: 'session/detailSession.html',
            controller: 'detailsSessionController',
            controllerAs: 'detailSession'
          }
        }
      });
    }]);

  function  controllerStateSessions($state,resolveSessions) {
    var vm = this;
    vm.sessions = resolveSessions;
    vm.ouvrirDetails = function(session) {
      $state.go('detailsSession',{idSession: session.id});
    };
  }

  controllerStateSessions.$inject = ['$state','resolveSessions'];

  function  controllerStateDetailSession(currentSession,sessionServiceResource) {
    var vm = this;
    vm.session = angular.extend({},currentSession);
    vm.popupOpened = false;
    vm.edition = false;
    vm.editer = function() {
      vm.edition = true;
    };
    vm.openDate = function() {
      vm.popupOpened = true;
    };

    vm.save = function() {
      sessionServiceResource.enregistrer(vm.session);
    };
    vm.annuler = function() {
      vm.edition = false;
    };
  }
  controllerStateDetailSession.$inject = ['currentSession','sessionServiceResource'];

})(window,window.angular);

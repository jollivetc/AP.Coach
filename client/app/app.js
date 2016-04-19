/* global window: false */
'use strict';
(function (window, angular) {


  angular.module('apcoaching',  [
      'ui.router',
          'layout',
     'training.module',
     'agency.module',
     'dashboard.component',
     'ui.bootstrap',
     'session.module'

     ])
    .controller('dashboardStateController',dashboardStateController)
    .config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
      $urlRouterProvider.otherwise('/dashboard.html');
      $stateProvider
        .state('dashboard', {
          parent: 'layout',
          url: '/dashboard.html',
          resolve: {
            resolveCountTrainings: ['trainingServiceResource',function(trainingResource) {
              return trainingResource.getAll().then(function(data) {
                return data.length;
              });
            }],
            resolveCountTSessions: ['sessionServiceResource',function(sessionResource) {
              return sessionResource.getAll().then(function(data) {
                return data.length;
              });
            }],
            resolveCountAgency: ['agencyServiceResource',function(agencyResource) {
              return agencyResource.getAll().then(function(data) {
                return data.length;
              });
            }],

            resolveNextSessions: ['sessionServiceResource',function(sessionServiceResource) {
              return sessionServiceResource.getNextSessions();
            }]
          },
          views: {
            '@layout': {
              templateUrl: 'dashboard/dashboard.html',
            controller:'dashboardStateController',
              controllerAs: 'dashBoardCtlr'}
          }
        });
    }])

  function dashboardStateController(resolveCountAgency,resolveCountTSessions,resolveCountTrainings,resolveNextSessions) {
    var vm = this;
    vm.numberTrainings = resolveCountTrainings;
    vm.numberAgencies = resolveCountAgency;
    vm.numberSessions = resolveCountTSessions;
    vm.numberEtudiants = 20;
    vm.nextSessions = resolveNextSessions;
  }
  dashboardStateController.$inject = ['resolveCountAgency','resolveCountTSessions','resolveCountTrainings','resolveNextSessions']
})(window, window.angular);

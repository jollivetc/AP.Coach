/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){


  angular.module('training.module',  [
      'training.service','layout','training.component'
    ])
    .controller('trainingController',controllerStateTrainings)
    .controller('detailsTrainingController',controllerStateDetailTrainings)
    .config(['$stateProvider', function ($stateProvider) {
      $stateProvider
        .state('training', {
          parent: 'layout',
          url: '/training',
          resolve: {
            resolveTrainings: ['trainingServiceResource',function(trainingResource) {
              return trainingResource.getAll();
            }]
          },
          views: {
            '@layout': {
              templateUrl: 'training/training.html',
              controller: 'trainingController',
              controllerAs: 'trainingCtlr'
            }
          }
        })
        .state('detailsTraining', {
          data: {pageTitle: 'Détails d\'un Training'},
          parent: 'training',
          resolve: {
            currentTraining: ['$stateParams','trainingServiceResource', function ($stateParams,trainingResource) {
              if (isNaN($stateParams.idTraining)) {
                return {};
              }
              return trainingResource.getById(parseInt($stateParams.idTraining));
            }]
          },
          url: '/{idTraining}',
          views: {
            '@layout': {
              templateUrl: 'training/detailTraining.html',
              controller: 'detailsTrainingController',
              controllerAs: 'detailTraining'
            }
          }
        });
    }]);
  function  controllerStateDetailTrainings($stateParams,currentTraining,trainingServiceResource) {
    var vm = this;
    vm.training = angular.extend({},currentTraining);
    if (isNaN($stateParams.idTraining)) {
      vm.modeCreation = true;
      vm.edition = true;
    } else {
      vm.edition = false;
    }

    vm.editer = function() {
      vm.edition = true;
    };
    vm.save = function() {
      trainingServiceResource.enregistrer(vm.training);
    };
    vm.annuler = function() {
      vm.edition = false;
    };
  }
  controllerStateDetailTrainings.$inject = ['$stateParams','currentTraining','trainingServiceResource'];

  function  controllerStateTrainings($state,resolveTrainings) {
    var vm = this;
    vm.trainings = resolveTrainings;
    vm.ouvrirDetails = function(training) {
      $state.go('detailsTraining',{idTraining: training.id});
    };
    vm.creer = function(training) {
      $state.go('detailsTraining',{idTraining: 'new'});
    };
  }

  controllerStateTrainings.$inject = ['$state','resolveTrainings'];

})(window,window.angular);

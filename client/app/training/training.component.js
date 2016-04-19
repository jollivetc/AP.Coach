/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){



  angular.module('training.component',  [])
    .directive('listeTrainings', directiveListeTraining)
    .directive('elementListeTrainings', directiveElementListeTraining);

  function directiveListeTraining() {
    return {
      restrict: 'E',
      scope: {
        trainings: '='
      },
      templateUrl: 'training/listeTrainings.html'
    }
  }

  function directiveElementListeTraining() {
    return {
      restrict: 'E',
      scope: {
        training: '='
      },
      templateUrl: 'training/elementListeTrainings.html'
    }
  }

})(window,window.angular);

(function () {
  'use strict';

  describe('Trainings Test', function () {
    var $scope, createController;
    beforeEach(module('ui.router'));
    beforeEach(module('training.module'));
    beforeEach(inject(function ($rootScope,$controller,$injector,$templateCache) {
      createController = function(resolveTrainings) {
         return $controller('trainingController', {
          $scope: $scope,resolveTrainings:resolveTrainings
        });
      };

    }));

    it('should init with 0 training', function () {
      var controller = createController([]);
      expect(controller.trainings.length).toBe(0);
    });
  });
})();

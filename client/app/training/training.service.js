/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){



  angular.module('training.service',[])
    .factory('trainingServiceResource', trainingServiceResource);

  trainingServiceResource.$inject = ['$http','$q'];

  function trainingServiceResource($http,$q) {
    function getAll() {
      return $http.get('http://localhost:8080/api/trainings').then(function(response) {
        return response.data;
      });
    }

    function getById(id) {
      return $http.get('http://localhost:8080/api/trainings/'.concat(id)).then(function(response) {
        return response.data;
      });
    }
function enregistrer(training) {
  if (training.id) {
    return $http.put('http://localhost:8080/api/trainings/'.concat(training.id), training);
  } else {
    return $http.post('http://localhost:8080/api/trainings', training);
  }
}
    return {
      getAll: getAll,
      getById: getById,
      enregistrer: enregistrer
    };
  }

})(window,window.angular);

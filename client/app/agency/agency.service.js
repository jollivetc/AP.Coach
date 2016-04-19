/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){

  angular.module('agency.service',[])
    .factory('agencyServiceResource', agencyServiceResource);

  agencyServiceResource.$inject = ['$http'];

  function agencyServiceResource($http) {

    function getAll() {
      return $http.get('http://localhost:8080/api/agencies').then(function(response) {
        return response.data;
      });
    }
    function getById(id) {
      return $http.get('http://localhost:8080/api/agencies/'.concat(id)).then(function(response) {
        return response.data;
      });
    }
    return {
      getAll: getAll,
      getById:getById
    };
  }

})(window,window.angular);

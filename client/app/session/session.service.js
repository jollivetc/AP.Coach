/**
 * Created by micka on 12/03/16.
 */
'use strict';
(function(window,angular){

  angular.module('session.service',[])
    .factory('sessionServiceResource', sessionServiceResource);

  sessionServiceResource.$inject = ['$http','$q'];

  function sessionServiceResource($http,$q) {

    function getAll() {
      return $http.get('http://localhost:8080/api/sessions').then(function(response) {
        return response.data;
      });
    }
    function getById(id) {
      return $http.get('http://localhost:8080/api/sessions/'.concat(id)).then(function(response) {
        return response.data;
      });
    }
    function getNextSessions() {
      return $http.get('http://localhost:8080/api/sessions/coming').then(function(response) {
        return response.data;
      });
    }
    return {
      getAll: getAll,
      getById:getById,
      getNextSessions:getNextSessions
    };
  }

})(window,window.angular);

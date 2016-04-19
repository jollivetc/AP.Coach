(function () {
  'use strict';


  describe('dashboard Test :', function () {
    var scope, directiveListeNextSession, compile;

    beforeEach(module('dashboard.component'));
    beforeEach(module('templates'));

    beforeEach(inject(function ($rootScope,$compile) {
      scope = $rootScope.$new();
      directiveListeNextSession = '<next-sessions ' +
        'sessions="listeSessions" > ' +
        '</next-sessions> ';
      compile = $compile;
    }));

    it("should display 3 session panel ", function () {
      scope.listeSessions = [{"id":11,"date":"2015-08-06T10:58:26Z","location":"La Troncal","attendees":[{"id":9000071,"firstName":"Irène","lastName":"ROGER"},{"id":9000059,"firstName":"Måns","lastName":"LEFEBVRE"}],"coaches":[{"id":8999999,"firstName":"Maëlle","lastName":"BRETON"},{"id":9000064,"firstName":"Dorothée","lastName":"LECOMTE"}],"training":{"id":5,"name":"Hibernate","description":"Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viverra diam vitae quam. Suspendisse potenti.","level":"INTERMEDIATE","repositoryUrl":"https://ramrods.panorama.fr"}},
        {"id":12,"date":"2016-02-28T13:18:15Z","location":"Santo Amaro","attendees":[{"id":9000064,"firstName":"Dorothée","lastName":"LECOMTE"},{"id":9000085,"firstName":"Mårten","lastName":"MEYER"},{"id":9000011,"firstName":"Mahélie","lastName":"DESCHAMPS"},{"id":9000043,"firstName":"Aurélie","lastName":"PAYET"},{"id":9000053,"firstName":"Cléa","lastName":"SIMON"},{"id":9000049,"firstName":"Angélique","lastName":"MARTINEZ"},{"id":9000024,"firstName":"Marie-josée","lastName":"DUMAS"},{"id":9000089,"firstName":"Léone","lastName":"MULLER"},{"id":9000066,"firstName":"Gwenaëlle","lastName":"ROUX"},{"id":9000087,"firstName":"Anaëlle","lastName":"LEBLANC"}],"coaches":[{"id":9000040,"firstName":"Crééz","lastName":"DUMONT"}],"training":{"id":7,"name":"Hadoop","description":"Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.","level":"BEGINNER","repositoryUrl":"http://radio's.breach's.fr"}},
        {"id":13,"date":"2015-03-22T15:15:46Z","location":"Bali","attendees":[],"coaches":[{"id":9000044,"firstName":"Marie-hélène","lastName":"DUVAL"},{"id":9000009,"firstName":"Táng","lastName":"CARRE"}],"training":{"id":12,"name":"JEE 7","description":"Duis bibendum, felis sed interdum venenatis, turpis enim blandit mi, in porttitor pede justo eu massa. Donec dapibus. Duis at velit eu est congue elementum.","level":"ADVANCED","repositoryUrl":"https://bumpier.tattle's.com"}},
      ];
      var directiveCompile = compile(directiveListeNextSession)(scope);
      scope.$digest();
      var elementSession = directiveCompile.find('.next-session');
      expect(elementSession.length).toBe(3);
    });

    it("should display 0 session panel", function () {
      scope.listeSessions = [];
      var directiveCompile = compile(directiveListeNextSession)(scope);
      scope.$digest();
      var elementSession = directiveCompile.find('.next-session');
      expect(elementSession.length).toBe(0);
    });

  });

})();

module.exports = function(config){
  config.set({

    basePath : './',

    files : [
      'app/bower_components/jquery/dist/jquery.js',
      'app/bower_components/underscore/underscore.js',
      'app/bower_components/angular/angular.js',
      'app/bower_components/angular-mocks/angular-mocks.js',
      'app/bower_components/angular-ui-router/release/angular-ui-router.js',
      'app/bower_components/angular-bootstrap/ui-bootstrap.js',
      'app/bower_components/angular-bootstrap/ui-bootstrap-tpls.js',
      'app/layout/**/*.js',
      'app/training/**/*.js',
      'app/training/**/*.html',
      'app/dashboard/**/*.js',
      'app/dashboard/**/*.html',
      'app/session/**/*.js',
      'app/session/**/*.html',
      'test/**/*.js'
    ],
    preprocessors: {
      'app/**/*.html': ['ng-html2js']
    },
    ngHtml2JsPreprocessor: {
      stripPrefix: 'app/',
      moduleName: 'templates'
    },
    autoWatch : true,

    frameworks: ['jasmine'],

    browsers : ['PhantomJS'],
    reporters: ['progress'],
    plugins : [
            'karma-chrome-launcher',
            'karma-phantomjs-launcher',
            'karma-jasmine',
            'karma-growl-reporter',
            'karma-junit-reporter',
            'karma-ng-html2js-preprocessor'
            ],

    junitReporter : {
      outputFile: 'test_out/unit.xml',
      suite: 'unit'
    }

  });
};

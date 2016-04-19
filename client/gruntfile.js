/**
 * Created by micka on 16/03/16.
 */
module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),

    karma: {
      unit: {
        configFile: 'karma.conf.js'
      }
    },
    browserSync: {
      bsFiles: {
        src : ['app/**/*.css','app/**/*.js','app/**/*.html']
      },
      options: {
        server: {
          baseDir: "./app"
        }
      }
    }

  });

  grunt.loadNpmTasks('grunt-karma');
  grunt.loadNpmTasks('grunt-browser-sync');
  grunt.registerTask('test', ['karma']);
};

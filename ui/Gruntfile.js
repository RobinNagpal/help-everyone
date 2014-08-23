var paths = {
    css_dest: 'src/assets/css/',
    css_src: 'src/assets/styles/'
};

module.exports = function (grunt) {
    grunt.initConfig({
        sass: {

            build: {
                options: {
                    style: 'expanded',
                    trace: true,
                    loadPath: ["source/sass"]
                },
                dest: paths.css_dest + 'main.css',
                src: [paths.css_src + 'main.scss']
            }
        }
    });
    grunt.loadNpmTasks('grunt-contrib-sass');
    grunt.registerTask('default', ['sass:build']);

};
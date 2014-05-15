'use strict';
var util = require('util');
var path = require('path');
var yeoman = require('yeoman-generator');
var yosay = require('yosay');
var chalk = require('chalk');
var figlet = require('figlet');
var fs = require('fs');

var DropwizardGenerator = yeoman.generators.Base.extend({
    init: function () {
        this.pkg = require('../package.json');

        this.on('end', function () {
            if (!this.options['skip-install']) {
                this.installDependencies();
            }
        });
    },

    askFor: function () {
        var done = this.async();

        // Have Yeoman greet the user.
        this.log(yosay('Welcome to the marvelous Dropwizard generator!'));

        var prompts = [{//ask the user some questions
            type: 'input',
            name: 'projectName',
            message: 'What is the name of your project?',
            default: "myapp"
        },{
            type: 'input',
            name: 'packageName',
            message: 'What is your default package name?',
            default: "com.example"
        },{
            type: 'input',
            name: 'gradleVersion',
            message: 'What version of gradle should this project use?',
            default: "1.7"
        },{
            type: 'input',
            name: 'dropwizardVersion',
            message: 'What version of dropwizard should we use?',
            default: "0.6.2"
        },{
            type: 'input',
            name: 'groupID',
            message: 'What should the group id be?',
            default: "com.example"
        }];

        this.prompt(prompts, function (props) {
            this.projectName = props.projectName;
            this.packageName = props.packageName;
            this.groupID = props.groupID;
            this.gradleVersion = props.gradleVersion;
            this.dropwizardVersion = props.dropwizardVersion;
            done();
        }.bind(this));
    },

    app: function () {
        var jsrc = "/src/main/java/"+this.packageName.replace(".","/")+"/"+this.projectName;
        var tsrc = "/src/test/java/tests";
        var resourceTest = "/src/test/resources/";
        var resourceJava = "/src/main/resources/";
        function createSubDirs(prefix,context,moduleName){//should have scope ...
            context.mkdir(prefix+jsrc+moduleName);
            context[moduleName+"WDir"] = prefix+jsrc+moduleName; 
            context.mkdir(prefix+resourceJava);
            context.mkdir(prefix+tsrc);
            context.mkdir(prefix+resourceTest);
        };
        //create submodules
        var core = this.mkdir(this.projectName+"-core");
        var client = this.mkdir(this.projectName+"-client");
        var service =  this.mkdir(this.projectName+"-service");
        createSubDirs(core,this,"core");
        createSubDirs(client,this,"client");
        createSubDirs(service,this,"service");
        this.mkdir(service+"/src/dist/config");
        this.copy('_package.json', 'package.json');
        this.copy('_bower.json', 'bower.json');
    },

    projectfiles: function () {
        function writeBanner(path,banner){
	    fs.writeFile(path, banner, function(err) {
		if(err) {
		    console.log(err);
		} else {
		    console.log("The file was saved!");
		}
	    }); 
	}
        //this.copy('editorconfig', '.editorconfig');
        //this.copy('jshintrc', '.jshintrc');
        this.copy('gitignore','.gitignore');
        this.template("core/_build.gradle",this.projectName+"-core/build.gradle");
        this.template("client/_build.gradle",this.projectName+"-client/build.gradle");
        this.template("service/_build.gradle",this.projectName+"-service/build.gradle");
        this.template("_build.gradle","build.gradle");
        this.template("_settings.gradle","settings.gradle");
        
	//stub service files
        this.log(this.serviceWDir);
        this.template("service/_Service.java",this.serviceWDir+"/"+this.projectName+"Service.java");
	this.template("service/_ServiceConfig.java",this.serviceWDir+"/"+this.projectName+"ServiceConfig.java");
	this.template("service/_Resource.java",this.serviceWDir+"/"+this.projectName+"Resource.java");
	this.template("service/_ServiceConfigProvider.java",this.serviceWDir+"/"+this.projectName+"ServiceConfigProvider.java");
	this.template("service/_ServiceBundle.java",this.serviceWDir+"/"+this.projectName+"ServiceBundle.java");
	this.copy("service/_settings.yml",this.projectName+"-service/src/dist/config/settings.yml");
	
        //banner
	figlet["context"] = this;
	figlet(this.projectName, function(err, data) {
	    if (err) {
		console.log('Something went wrong...');
		console.dir(err);
		return;
	    }
	    console.log(data);
	    writeBanner(figlet.context.projectName+"-service/src/main/resources/"+"banner.txt",data);
	});

    }
});

module.exports = DropwizardGenerator;

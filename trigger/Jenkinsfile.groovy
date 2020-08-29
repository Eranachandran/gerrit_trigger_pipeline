pipeline {
	agent {
		label 'master'
	}
	parameters {
    	string (defaultValue: 'v2.9.5_FR', 
    	description: 'branch name of the repository', 
    	name: 'branch', 
    	trim: false)
    }

	stages {
		stage('clone_pipeline-test') {
			steps {
				echo "${params.branch}"
			}
		}
	}
}

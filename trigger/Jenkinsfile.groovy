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
				checkout([
					$class: 'GitSCM', 
					branches: [[name: '*/${params.branch}']],
					doGenerateSubmoduleConfigurations: false,
					extensions: [[$class: 'LocalBranch', localBranch: '${params.branch}'], 
					[$class: 'CleanBeforeCheckout'], 
					[$class: 'RelativeTargetDirectory', relativeTargetDir: 'heatstack']],
					submoduleCfg: [], 
					userRemoteConfigs: [[credentialsId: '2e5f717b-82f6-4526-a358-42e77b16c6d5',url: 'https://review.corestack.in/heatstack']]
					])
				echo ${params.region}
			}
		}
	}
}

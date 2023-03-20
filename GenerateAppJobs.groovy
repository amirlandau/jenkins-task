pipelineJob('App Pipeline') {
    definition {
        cps {
            script(readFileFromWorkspace('app/AppPipeline.jenkinsfile'))
            sandbox()
        }
    }
}


job('Nginx Job') {
    scm {
        github('amirlandau/jenkins-task', 'main')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('1372022/nginx')
            registryCredentials('1372022-dockerhub')
            buildContext('./nginx')
            forceTag(false)
            skipDecorate(true)
        }  
	}
}


job('Deploy And Validate') {
    scm {
        github('amirlandau/jenkins-task', 'main')
    }
    steps {
        shell(readFileFromWorkspace('DeployAndValidate.sh'))
    }
}

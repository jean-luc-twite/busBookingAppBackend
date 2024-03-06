pipeline {
    agent any
    tools{
        maven 'Maven3'
    }
    stages {
        stage('build maven project'){
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/jean-luc-twite/busBookingAppBackend']])
                  bat 'mvn clean install'
            }
        }
        stage('Build docker image'){
            steps{
                script{
                    bat 'docker build -t jlfidev/devops-integration .'
                }
            }
        }
        stage('Push image to hub'){
            steps{
                script{
                   withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                    bat 'docker login -u jlfidev -p %dockerhubpwd%'
                  }
                   bat 'docker push jlfidev/devops-integration '
                }
            }
        }


    }

}
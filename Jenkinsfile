pipeline {
  agent {
    docker {
      image 'maven:3.6.3-openjdk-15'
      args '--network docker-jenkins_jenkinsnet'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

  }
}
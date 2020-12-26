pipeline {
  agent {
    docker {
      image 'maven:3.6.3-openjdk-15'
      args '--network intercorp_network'
    }

  }
  stages {
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }

    stage('Test') {
      steps {
        sh 'mvn test'
      }
    }

  }
}
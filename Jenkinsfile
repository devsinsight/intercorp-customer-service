pipeline {
  agent {
    docker {
      image 'maven:3.6.3-openjdk-15'
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

    stage('Docker Build') {
      agent {
        dockerfile {
          filename './Dockerfile'
        }

      }
      steps {
        sh 'docker build -t customer-service-repository:1.0 .'
      }
    }

  }
}
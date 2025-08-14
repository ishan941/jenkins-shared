def call(String projectName, String tag){
    withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]){
        sh """
            echo "$dockerHubPass" | docker login -u "$dockerHubUser" --password-stdin
            docker tag $dockerHubUser/$projectName:latest $dockerHubUser/$projectName:$tag
            docker push $dockerHubUser/$projectName:$tag
            docker logout
        """
    }
}

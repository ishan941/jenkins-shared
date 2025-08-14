def call(String projectName, String tag){
     withCredentials([usernamePassword(credentialsId: 'dockerHub', usernameVariable: 'dockerHubUser', passwordVariable: 'dockerHubPass')]){
                    sh '''
                      docker login -u "$dockerHubUser" -p "$dockerHubPass"
                      docker push ${dockerHubUser}/${projectName}:${tag}
                      docker logout
                      '''
                }
}